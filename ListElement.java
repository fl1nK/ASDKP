import java.util.NoSuchElementException;

class Node<T> {

    public Node<T> next;
    public T data;

    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [next=" + next + ", data=" + data + "]";
    }
}

class LinkedList<T> {

    Node<T> start = null;
    Node<T> end = null;

    public void insertAtStart(T data) {
        Node<T> nptr = new Node<T>(data, null);
        if (empty()) {
            start = nptr;
            end = start;
        } else {
            nptr.next = start;
            start = nptr;
        }

    }
    public void insert(int position, T data) {
        if (position != 1 && empty())
            throw new IllegalArgumentException("Empty");
        if (position == 1) {
            insertAtStart(data);
            return;
        }

        Node<T> nptr = new Node<T>(data, null);
        if (position == size()) {

            Node<T> startPtr = start;
            Node<T> endPtr = startPtr;
            while (startPtr.next != null) {
                endPtr = startPtr;
                startPtr = startPtr.next;
            }
            endPtr.next = nptr;
            nptr.next = end;
        } else {
            position -= 1;
            Node<T> startPtr = start;
            for (int i = 1; i < size(); i++) {
                if (i == position) {
                    Node<T> temp = startPtr.next;
                    startPtr.next = nptr;
                    nptr.next = temp;
                }
                startPtr = startPtr.next;
            }
        }
        if (position >= size())
            throw new IllegalArgumentException("Такої позиції немає!");

    }

    public void insertAtEnd(int data) {
        Node<T> nptr = (Node<T>) new Node<Integer>(data, null);
            end.next = nptr;
            end = nptr;

    }

    public int get(T data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        return index(start, data, 0);
    }

    private int index(Node<T> link, T data, int index) {
        if (link != null) {
            if (link.data == data) {
                return index;
            }
            return index(link.next, data, ++index);
        }
        return -1;
    }

    public int size() {
        return size(start, 0);
    }

    private int size(Node<T> link, int i) {
        if (link == null)
            return 0;
        else {
            int count = 1;
            count += size(link.next, 0);
            return count;
        }
    }

    public void display() {
        if (empty())
            throw new NoSuchElementException("Empty");
        display(start);
    }

    private void display(Node<T> link) {
        if (link != null) {
            System.out.print(link.data + " ");
            display(link.next);
        }
    }

    public boolean empty() {
        return start == null;
    }

    public void set(int position, T data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        if (position == 1)
            start.data = data;
        else if (position == size())
            end.data = data;
        else if(position > size()){
            for (int i = size(); i < position; i++ ){
                insertAtEnd(0);
            }
            insertAtEnd((Integer) data);
        }
        else {
            Node<T> startPtr = start;
            for (int i = 1; i <= position; i++) {
                if (i == position)
                    startPtr.data = data;
                startPtr = startPtr.next;
            }
        }
        display();
    }
}