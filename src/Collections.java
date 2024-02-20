import java.util.LinkedList;

public class Collections {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.addFirst(0);
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
    }
}
