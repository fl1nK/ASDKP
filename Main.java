public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.insert(1, 4);
        linkedList.insert(1, 0);
        linkedList.insert(1, 0);
        linkedList.insert(1, 10);
        linkedList.insert(1, 4);
        linkedList.insert(1, 0);
        linkedList.insert(1, 0);
        linkedList.insert(1, 10);

        System.out.println("get: " + linkedList.get(10));
        linkedList.display();
        System.out.println();
        System.out.println("set");
        linkedList.set(6, 100);
        System.out.println();
        System.out.println("remove ");
        linkedList.remuve(4);

    }
}
