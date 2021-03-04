public class SortedLinkedList<T extends Comparable<T>> extends DoublyLinkedList<T> {
    @Override
    /* Adds nodes sorted */
    public void add(T data) {
        if(size() == 0) {
            super.add(data);
            return;
        }
        Node<T> currentNode = head;
        for(int i = 0; i < size(); i++) {
            if(i != 0) {
                currentNode = currentNode.next;
            }
            if(currentNode.data.compareTo(data) > 0) {
                super.add(i, data);
                return;
            } 
        }
        super.add(data);
    }

    @Override
    /* Removes the last node in the list */
    public T remove() {return remove(size() - 1);}

    @Override
    /* Stop you from using set(int pos, T data) in our lovingly sorted list */
    public void set(int pos, T data) throws UnsupportedOperationException {throw new UnsupportedOperationException();}

    @Override
    /* Stop you from using add(int pos, T data) in our lovingly sorted list */
    public void add(int pos, T data) throws UnsupportedOperationException {throw new UnsupportedOperationException();}
}
