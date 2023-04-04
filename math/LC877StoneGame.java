package math;

public class LC877StoneGame {

    // Very tricky
    // If we have stones [a1, a2, a3, ..., an] where n is even
    // We separate stones by index as odd = [a1, a3, a5, ...] and even = [a2, a4, a6, ...]
    // The total number of stones sum(odd) != sum(even)
    // If the first player choose the odd pile, the second can only choose even
    // And vice versa
    // Therefore, the first player can choose the larger pile
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
