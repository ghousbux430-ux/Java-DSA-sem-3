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

    // this method delete the top element of the stack.
    public Object pop(){
        if(size==0){
            throw new IllegalStateException("stack is empty");
        }
        Object temp = top.data;
        top = top.next;
        --size;
        return temp;
    }

    // this method delete the element which you want.
    public Object pop(Object obj){
        if(obj==top.data){
            return top=top.next;
        }
        Node i = top;
        while(i.next != null){
            if(i.next.data == obj){
                i.next = i.next.next;
                break;
            }
            i = i.next;
        }
        return top;
    }

    public void push(Object obj){
        top = new Node(obj,top);
        size++;
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

    // this method will used to break the stack
    public LinkedStack breakStacks(LinkedStack list){
        LinkedStack l1 = new LinkedStack();
        int mid = size/2;

        for(int i = 0; i<mid; i++){
            l1.push(list.top.data);
            list.pop();
        }

        return l1;
    }

    // this method will use to merge the stacks
    public static LinkedStack mergeStacks(LinkedStack a1, LinkedStack a2) {
        LinkedStack mergedStack = new LinkedStack();

        while (!a1.isEmpty()) {
            mergedStack.push(a1.pop());
        }

        while (!a2.isEmpty()) {
            mergedStack.push(a2.pop());
        }

        return mergedStack;
    }

    public String toString(){

        StringBuffer bf = new StringBuffer();
        if(size == 0){
            throw new IllegalStateException("Stack is empty");
        }

        for(Node i = top; i != null; i=i.next){
            bf.append(i.data + " ");
        }

        return bf + " ";
    }


    public static void main(String[] args) {
        LinkedStack s1 = new LinkedStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);

        LinkedStack l2 = new LinkedStack();
        l2.push(7);
        l2.push(8);
        l2.push(9);

        LinkedStack m_Stack = mergeStacks(s1,l2);
        System.out.println("merged stack is : " + m_Stack);
        m_Stack.pop(2);
        System.out.println("merged stack after poping 2 : "+m_Stack);


        // System.out.println("before breaking : "+s1);
        // LinkedStack s2 = s1.breakStacks(s1);
        // System.out.println("After breaking 1st stack is : "+s2);
        // System.out.println("After breaking 2nd stack is : "+s1);

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
        // s.sort();
        // while(!s.isEmpty()) {
        //     System.out.print(s.pop() + " ");
        // }

    }
}





