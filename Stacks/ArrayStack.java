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


    // method for breaking one stack into two parts
    public Object[] breakStack(ArrayStack stack){
        if(size == 0){
            throw new IllegalStateException("stack is empty");
        }

        ArrayStack s1 = new ArrayStack(size/2);
        ArrayStack s2 = new ArrayStack(size/2);
        int originalSize = size;
        int mid = size/2;

        for(int i=0; i<mid; i++){
            s1.push(stack.pop());
        }

        for(int i = mid; i<originalSize; i++){
            s2.push(stack.pop());
        }

        Object[] newArr = new Object[2];
        newArr[0] = s1;
        newArr[1] = s2;

        return newArr;
    }

    // this method will merge two stacks into one stack

    public static ArrayStack mergeStacks(ArrayStack s1, ArrayStack s2){
        ArrayStack mergeStack = new ArrayStack(s1.Size()+s2.Size());

        while(!s1.isEmpty()){
            mergeStack.push(s1.pop());
        }

        while(!s2.isEmpty()){
            mergeStack.push(s2.pop());
        }

        return mergeStack;
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
        ArrayStack stack1 = new ArrayStack(3);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        ArrayStack stack2 = new ArrayStack(3);
        stack2.push(7);
        stack2.push(8);

        // ArrayStack mergedStack = mergeStacks(stack1,stack2);
        // System.out.println("merged stack is : " + mergedStack);

        System.out.println("Stack before breaking : " + stack1);

        Object[] breaked_Stacks = stack1.breakStack(stack1);

        System.out.println("After breaking.....");

        ArrayStack s1 = (ArrayStack)breaked_Stacks[0];
        ArrayStack s2 = (ArrayStack)breaked_Stacks[1];

        System.out.println("first stack is : "+s1);
        System.out.println("second stack is : "+s2);



        

        // System.out.println("top is : "+a.peek());
        // System.out.println("pop : "+a.pop());
        // System.out.println("after top is : "+a.peek());
    }
}


