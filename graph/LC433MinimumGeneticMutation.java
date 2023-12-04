package graph;

import java.util.*;

public class LC433MinimumGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AAAACCCC";
        String endGene = "CCCCCCCC";
        String[] bank = {"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"};

        System.out.println(minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }

        List<Character> choices = List.of('A', 'C', 'G', 'T');
        Set<String> strBank = new HashSet<>();
        Collections.addAll(strBank, bank);

        if (!strBank.contains(endGene)) {
            return -1;
        }

        int res = 0;
        Deque<String> queue = new LinkedList<>();
        queue.add(startGene);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curStr = queue.poll();
                if (curStr.equals(endGene)) {
                    return res;
                }
                visited.add(curStr);

                char[] cur = curStr.toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    for (Character choice : choices) {
                        if (cur[i] != choice) {
                            char prev = cur[i];
                            cur[i] = choice;
                            String mutation = new String(cur);
                            if (strBank.contains(mutation) && !visited.contains(mutation)) {
                                queue.offer(mutation);
                            }
                            cur[i] = prev;
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
