public class Stable<T> extends DoublyLinkedList<T> {
    public void leggPaa(T data) {add(data);}
    public T taAv() {return remove(size() - 1);}
}
