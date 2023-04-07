package math;

public class LC204CountPrimes {

    // Eratosthenes sieve
    // Time complexity: O(nloglogn)
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {
                continue;
            }

            count++;
            for (int j = 1; j * i < n; j++) {
                notPrime[j * i] = true;
            }
        }

        return count;
    }
}
