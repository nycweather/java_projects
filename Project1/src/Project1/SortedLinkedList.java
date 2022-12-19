package Project1;

public class SortedLinkedList<T extends Comparable<T>> {
    private LLNode<T> head;

    public SortedLinkedList() {
        head = null;
    }

    public void add(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        if (head == null || element.compareTo(head.getData()) < 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            LLNode<T> current = head;
            while (current.getNext() != null && element.compareTo(current.getNext().getData()) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public boolean remove(T element) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(element)) {
            head = head.getNext();
            return true;
        }
        LLNode<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(element)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return false;
        }
        current.setNext(current.getNext().getNext());
        return true;
    }

    public boolean contains(T element) {
        LLNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T get(int index) {
        LLNode<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    public int size() {
        int count = 0;
        LLNode<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LLNode<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
