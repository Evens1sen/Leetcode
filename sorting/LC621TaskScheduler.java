package sorting;

import java.util.*;

public class LC621TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(queueSolution(tasks, n));
    }

    /*
        max: The max frequency of tasks
        total: The number of tasks have max frequency
        We first schedule max tasks, and insert others in the time gap
        If can insert, time = (n + 1) * (max - 1) + total
            A B C
            A B C
            A B
        Else, time = len(tasks)
            A B C D E
            A B C D
            A B
     */
    public static int greedySolution(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        int max = 0, tot = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, freq[i]);
        }
        for (int i = 0; i < 26; i++) {
            tot += max == freq[i] ? 1 : 0;
        }

        return Math.max(tasks.length, (n + 1) * (max - 1) + tot);
    }

    public static int queueSolution(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : freq) {
            if (num != 0) {
                pq.add(num);
            }
        }

        Deque<int[]> queue = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            if (!pq.isEmpty()) {
                int f = pq.poll();
                f--;
                if (f > 0) {
                    queue.offer(new int[]{f, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.poll()[0]);
            }
            time++;
        }

        return time;
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char tname : tasks) {
            freq[tname - 'A']++;
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> t2.freq - t1.freq);
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                pq.add(new Task((char) ('A' + i), freq[i]));
            }
        }

        Set<Task> cooling = new HashSet<>();
        List<Task> schedule = new ArrayList<>();
        int time = 0;
        while (!pq.isEmpty() || !cooling.isEmpty()) {
            if ((time - n - 1) >= 0 && cooling.contains(schedule.get(time - n - 1))) {
                Task restored = schedule.get(time - n - 1);
                cooling.remove(restored);
                pq.add(restored);
            }

            if (pq.isEmpty()) {
                time++;
                schedule.add(new Task('0', 0));
                continue;
            }

            Task toScheduled = pq.poll();
            toScheduled.freq--;
            schedule.add(toScheduled);
            if (toScheduled.freq != 0) {
                cooling.add(toScheduled);
            }
            time++;
        }

        return time;
    }

    public static class Task {
        char name;
        int freq;

        public Task(char name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }
}
