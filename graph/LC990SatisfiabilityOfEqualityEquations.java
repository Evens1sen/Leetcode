package graph;

public class LC990SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int left = eq.charAt(0) - 'a';
                int right = eq.charAt(3) - 'a';
                uf.union(left, right);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int left = eq.charAt(0) - 'a';
                int right = eq.charAt(3) - 'a';
                if (uf.isConnected(left, right)) {
                    return false;
                }
            }
        }
        return true;
    }
}
