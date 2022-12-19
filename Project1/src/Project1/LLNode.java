package Project1;

public class LLNode<T> {
    private T data;
    private LLNode<T> next;

    public LLNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public LLNode<T> getNext() {
        return next;
    }
    
    public void setNext(LLNode<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }