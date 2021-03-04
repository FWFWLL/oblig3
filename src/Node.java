public class Node<T> {
    T data;
    Node<T> previous = null;
    Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }
}