package Stacks;

public class ArrayStack{
    private int size;
    private Object[] a;

    public ArrayStack(int capacity){
        a = new Object[capacity];
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public int Size(){
        return size;
    }


    public Object peek(){
        if(size == 0){
            throw new IllegalStateException("stack is empty");
        }else{
            return a[size-1];
        }
    }

    public Object pop(){
        if(size == 0){
            throw new IllegalStateException("stack is empty");
        }

        Object temp = a[--size];
        a[size] = null;
        return temp;
    }

    public void resize(){
        Object[] aa = a;
        a = new Object[2*aa.length];

        System.arraycopy(aa,0,a,0,size);
    }

    public void push(Object obj){
        if(size == a.length){
            resize();
        }
        a[size++] = obj;
    }

    public String toString(){
        StringBuffer bf = new StringBuffer();

        if(size == 0){
            throw new IllegalStateException("stack is empty");
        }

        for(int i=0; i<a.length; i++){
            bf.append(a[i] + " ");
        }

        return bf + " ";
    }

    public static void main(String[] args) {
        ArrayStack a = new ArrayStack(3);
        a.push("this");
        a.push("is");
        a.push(2);
        a.push("and");
        a.push(3);

        System.out.println(a);

        // System.out.println("top is : "+a.peek());
        // System.out.println("pop : "+a.pop());
        // System.out.println("after top is : "+a.peek());
    }
}


