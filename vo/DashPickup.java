package vo;

public class DashPickup {

    /**
     * dp[i][0]: Min time need to walk to restaurant i
     * dp[i][1]: Min time need to drive to restaurant i
     * dp[i][0] = dp[i-1][1] + 2 * t_walk
     * dp[i][1] = min(dp[i-1][0],  dp[i-1][1]) + t_parking
     * res = min(dp[n][0], dp[n][1]) + t_driving
     * <p>
     * Follow up: What if we can walk to multiple restaurants
     * dp[i]: The min time we're parking at restaurant i
     * dp[i] = min(dp[j] + 2 * t[j][i-1]) + p[i] for all j < i
     * t[j][i-1] = t[i-1] - t[j]
     * dp[i] = min(dp[j] - 2t[j]) + 2t[i-1] + p[i]
     */
    public int minPickupTime(int[] restaurant, int[] parkingTime, int walkingSpeed, int drivingSpeed) {
        int n = restaurant.length;
        int dp0 = Integer.MAX_VALUE;
        int dp1 = parkingTime[0];
        int drivingTime = (restaurant[n - 1] - restaurant[0]) / drivingSpeed;

        for (int i = 1; i < n; i++) {
            dp0 = dp1 + 2 * (restaurant[i] - restaurant[i - 1]) / walkingSpeed;
            dp1 = Math.min(dp0, dp1) + parkingTime[i];
        }

        return Math.min(dp0, dp1) + drivingTime;
    }

    public int minPickupTime2(int[] restaurant, int[] parkingTime, int walkingSpeed, int drivingSpeed) {
        int n = restaurant.length;
        int[] dp = new int[n];
        dp[0] = parkingTime[0];
        int[] time = new int[n];
        for (int i = 1; i < n; i++) {
            time[i] = time[i - 1] + (restaurant[i] - restaurant[i - 1]) / walkingSpeed;
        }

        int min = dp[0] - 2 * time[0];
        for (int i = 1; i < n; i++) {
            dp[i] = min + 2 * time[i - 1] + parkingTime[i];
            min = Math.min(min, dp[i] - 2 * time[i]);
        }

        int drivingTime = (restaurant[n - 1] - restaurant[0]) / drivingSpeed;
        return dp[n - 1] + drivingTime;
    }
}
