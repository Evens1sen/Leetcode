package greedy;

public class LC134GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int max = Integer.MIN_VALUE, position = -1;
        for (int i = 0; i < n; i++) {
            if (gas[i] - cost[i] > max) {
                max = gas[i] - cost[i];
                position = i;
            }
        }

        int tank = gas[position];
        int i = position;
        while (tank > 0) {
            if (tank < cost[i]) {
                return -1;
            }
            tank = tank - cost[i] + gas[(i + 1) % n];
            i = (i + 1) % n;
            if (i == position) {
                break;
            }
        }
        return position;
    }
}
