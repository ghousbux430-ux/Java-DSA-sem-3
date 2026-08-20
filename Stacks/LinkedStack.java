package Stacks;
public class LinkedStack{

    public static class Node{
        Object data;
        Node next;

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private int size;
    public Node top;

    public boolean isEmpty(){
        return (size==0);
    }
    public int Size(){
        return size;
    }

    public Object peek(){
        if(size==0){
            throw new IllegalStateException("stack is empty");
        }
        return top.data;
    }

    public Object pop(){
        if(size==0){
            throw new IllegalStateException("stack is empty");
        }

        Object temp = top.data;
        top = top.next;
        --size;
        return temp;
    }

    public Object bottom_element(){
        if(size==0){
            throw new IllegalStateException("stack is empty");
        }
        Node bottom = top;
        Object b = null;
        while(bottom!=null){
            b = bottom.data;
            bottom = bottom.next;
        }
        return b;
    }

    public Object middle_element(){
        if(size==0){
            throw new IllegalStateException("stack is empty");
        }

        Node current = top;
        int middle = size/2;
        for(int i=0; i<middle; i++){
            current = current.next;
        }
        return current.data;
       
    }

    private void insertAtBottom(Object data) {
        if (isEmpty()) {
            push(data);
            return;
        }
        Object temp = pop();
        insertAtBottom(data);
        push(temp);
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Object temp = pop();
        reverse();
        insertAtBottom(temp);
    }

    public Object Max(){
        if(isEmpty()){
            throw new IllegalStateException("stack is empty");
        }

        Object max = peek();
        Node p = top;
        while(p != null){
            Object temp = pop();
            if((int)temp>(int)max){
                max = temp;
            }
            p = p.next;
        }
        return max;
        
    }

    public void sort(){
        LinkedStack sorted = new LinkedStack();

        while(!isEmpty()){
            Object temp = pop();
            while(!sorted.isEmpty() && (int)sorted.peek()<(int)temp){
                push(sorted.pop());
            }

            sorted.push(temp);
        }

        while(!sorted.isEmpty()){
            push(sorted.pop());
        }
    }


    public void Display(){
        Node p = top;
        while(p != null){
            System.out.print(p.data+"-->");
            p = p.next;
        }
        System.out.print("null");
    }
    public void push(Object obj){
        top = new Node(obj,top);
        size++;
    }
    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        s.push(1);
        s.push(20);
        s.push(3);
        s.push(4);
        s.push(5);
        // System.out.println(s.peek());
        // System.out.println("Bottom element is : "+s.bottom_element());
        // System.out.println("mid is : "+s.middle_element());
        // System.out.println("Before reversing.....");
        // s.Display();
        // s.reverse();
        // System.out.println();
        // System.out.println("After reversing.....");
        // s.Display();
        // System.out.println();
        // System.out.println("peek "+s.peek() );
        // System.out.println("maximium element of the stack is : " + s.Max());
        s.sort();
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }
}





