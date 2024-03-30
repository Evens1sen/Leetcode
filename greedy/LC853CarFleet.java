package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC853CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<int[]> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new int[]{position[i], speed[i]});
        }

        cars.sort(Comparator.comparingInt(c -> c[0]));

        int res = n;
        int[] lead = cars.get(n - 1);
        for (int i = n - 2; i > 0; i--) {
            int[] cur = cars.get(i);
            if ((target - cur[0]) / cur[1] < (target - lead[0]) / lead[1]) {
                res--;
            } else {
                lead = cur;
            }
        }
        return res;
    }
}
