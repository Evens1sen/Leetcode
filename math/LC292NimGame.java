package math;

public class LC292NimGame {

    // Can use recursion or dp, since f(n) = !f(n-1) && !f(n-2) && !f(n-3)
    // Also can be solved by math
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
