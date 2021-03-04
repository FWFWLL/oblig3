public class Main {
    public static void main(String[] args) {
        /* Declaring a doubly linked list with the integer type */
        List<String> list = new DoublyLinkedList<String>();
        /* Filling the list */
        list.add("C");
        System.out.println(list.toString());
        list.add(0, "A");
        System.out.println(list.toString());
        list.add("D");
        System.out.println(list.toString());
        list.add(1, "B");
        /* Displaying the DLL pre-modification */
        System.out.println(list.toString());
        System.out.println("Number of nodes: " + list.size());
    }
}