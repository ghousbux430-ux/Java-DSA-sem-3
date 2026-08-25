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
        Node prev = this,
        next = this;

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

    // This method will minus the credit and debit
    public void isRemaining(LinkedQueue credit, LinkedQueue debit){
        int remaining = credit.sum() - debit.sum();

        if(remaining>0){
            System.out.println("Remaining balance in my pocket is : "+remaining);
        }else if(remaining<0){
            System.out.println("I spent "+remaining+" extra");
        }else{
            System.out.println("Neither remaining nor i extra spent");
        }
    }

    // This method will calculate the sum of the Queue
    public int sum(){
        int sum = 0;
        Node p = head.next;
        while(p!=head){
            sum+=(int)p.data;

            p = p.next;
        }
        return sum;
    }

    public String toString() {
        if (size == 0) {
            throw new IllegalStateException("queue is empty");
        }
        StringBuffer sb = new StringBuffer();
        Node p = head.next;
        while (p != head) {
            sb.append(p.data);
            if(p.next != head){
                sb.append(", ");
            }
            p = p.next;
        }
        return sb.toString();

    }

    public static void main(String[] args) {

         LinkedQueue credit = new LinkedQueue();
        credit.add(200);
        credit.add(100);
        credit.add(250);
        credit.add(500);
        credit.add(150);
        credit.add(80);
        credit.add(400);

        LinkedQueue debit = new LinkedQueue();

        debit.add(90);
        debit.add(190);
        debit.add(120);
        debit.add(340);
        debit.add(60);
        debit.add(50);
        debit.add(250);

        System.out.println("each day credit in a week : "+credit);
        System.out.println("each day debit in a week : "+debit);

        System.out.println("sum of credit is : "+credit.sum());
        System.out.println("sum of debit is : "+debit.sum());
        credit.isRemaining(credit,debit);

    }
}
