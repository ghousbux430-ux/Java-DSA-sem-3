package Queue;


interface Queue{
    public int size();
    public Object first();
    public void add(Object obj);
    public Object remove();
}

public class LinkedQueue implements Queue {
    static class Node{
        Object data;
        Node prev = this, next = this;

        Node(Object data){
            this.data = data;
        }

        Node(Object data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node head = new Node(null);

    public int size(){
        return size;
    }

    public void add(Object obj){
        ++size;
        head.prev.next = new Node(obj,head.prev,head);
        head.prev = head.prev.next;
    }

    public Object first(){
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }

        return head.next.data;
    }

    public Object remove(){
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        --size;
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;

        return temp;
    }

    public static void main(String[] args) {

        LinkedQueue q = new LinkedQueue();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println("Queue size: " + q.size());
        System.out.println("First element: " + q.first());

        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Queue size after removal: " + q.size());
        System.out.println("First element now: " + q.first());

        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Queue size: " + q.size());
    }
}
