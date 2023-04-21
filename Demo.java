import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        List<Integer> lst3 = new ArrayList<>();
        lst1.add(1);
        lst2.add(2);
        lst3.add(3);
        lst.add(lst1);
        lst.add(lst2);
        lst.add(lst3);
        System.out.println(lst);

        for (List<Integer> cur : lst) {
            cur.add(5);
        }
        System.out.println(lst);
    }
}
