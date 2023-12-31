package greedy;

public class LC134GasStation {

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
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

        int tank = 0;
        int i = position;
        while ((i + 1) % n != position) {
            tank += gas[i];
            tank -= cost[i];
            if (tank < 0) {
                return -1;
            }
            i = (i + 1) % n;
        }
        if (tank < cost[i]) {
            return -1;
        }

        return position;
    }
}
