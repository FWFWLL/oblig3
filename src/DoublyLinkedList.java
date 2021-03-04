public class DoublyLinkedList<T> implements List<T> {
    protected Node<T> head = null;
    protected Node<T> tail = null;

    public DoublyLinkedList() {}

    /* Returns how many nodes are in the list */
    public int size() {
        int size = 0;
        if(head == null) return size;
        for(Node<T> n = head; n.next != null; n = n.next) size++;
        return size + 1; // +1 for full size ¯\_(ツ)_/¯
    }

    /* Add node to the specified position */
    public void add(int pos, T data) throws InvalidListIndex {
        Node<T> newNode = new Node<T>(data);
        /* Checks if the positional parameter is invalid */
        if(pos < 0 || pos > size()) throw new InvalidListIndex(pos);
        else {
            /* Checks first if position 0 was passed */
            if(pos == 0) {
                /* Then checks if head is NULL and instead assigns head */
                if(head == null) head = newNode;
                else {
                    head.previous = newNode;
                    newNode.next = head;
                    head = newNode;
                    if(size() == 2) tail = head.next;
                }
            } else if(pos == size()) {
                if(tail == null) tail = newNode;
                else {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = newNode;
                }
            } else {
                Node<T> currentNode = head;
                for(int i = 0; i < pos; i++) currentNode = currentNode.next;
                newNode.previous = currentNode.previous;
                newNode.next = newNode.previous.next;
                newNode.previous.next = newNode.next.previous = newNode;
            }
        }
    }

    /* Add a node to the end */
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if(head == null) head = newNode;
        else if(tail == null) {
            tail = newNode;
            head.next = tail;
            tail.previous = head;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    /* Replace the data at the specified position */
    public void set(int pos, T data) throws InvalidListIndex {
        if(pos < 0 || pos > size() - 1 || (pos == 0 && head == null)) throw new InvalidListIndex(pos);
        else {
            if(pos == 0) head.data = data;
            else if(pos == size() - 1) tail.data = data;
            else {
                Node<T> currentNode = head;
                for(int i = 0; i < pos; i++) currentNode = currentNode.next;
                currentNode.data = data;
            }
        }
    }

    /* Gets the node in the specified position */
    public T get(int pos) throws InvalidListIndex {
        if(pos < 0 || pos > size() - 1 || (pos == 0 && head == null)) throw new InvalidListIndex(pos);
        else if (pos == 0) return head.data;
        else if(pos == size()) return tail.data;
        else {
            Node<T> currentNode = head;
            for(int i = 0; i < pos; i++) currentNode = currentNode.next;
            return currentNode.data;
        }
    }

    /* Remove node at the specified position */
    public T remove(int pos) throws InvalidListIndex {
        T data = null;
        /* Checks if the positional parameter is invalid or if the list is empty */
        if(pos < 0 || pos > size() - 1 || (pos == 0 && head == null)) throw new InvalidListIndex(pos);
        else {
            /* Checks first if position 0 was passed and runs the positionless method */
            if(pos == 0) {
                data = head.data;
                head = null;
            } else if(pos == size() - 1 && tail != null) {
                /* If the tail and the head are the only nodes in the list then we don't want to assign the head as the tail */ 
                if(tail.previous == head) {
                    data = tail.data;
                    head.next = null;
                    tail = null;
                } else {
                    data = tail.data;
                    tail.previous.next = null;
                    tail = tail.previous;
                }
            } else {
                Node<T> currentNode = head;
                for(int i = 0; i < pos; i++) currentNode = currentNode.next;
                data = currentNode.data;
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                currentNode = null;
            }

        }
        return data;
    }

    /* Remove node from the start */
    public T remove() throws InvalidListIndex {
        T data = null;
        if(head == null) throw new InvalidListIndex(0);
        else {
            if(size() == 1) {
                data = head.data;
                head = null;
            } else {
                data = head.data;
                head.next.previous = null;
                head = head.next;
            }
        }
        return data;
    }

    /* Visualize the list */
    public String toString() {
        String string = "";
        Node<T> currentNode = head;
        for(int i = 0; i < size(); i++) {
            string += "Position: " + String.valueOf(i) + ", Data = " + currentNode.data + '\n';
            currentNode = currentNode.next;
        }
        return string;
    }
} 
