public class Insertion {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void addFirst(Node start,int value){
        Node newNode = new Node(value);
        if(start == null){
            start = newNode;
            return;
        }
        newNode.next = start;
        start = newNode;
    }

    public static void addLast(Node start,int value){
        Node newNode = new Node(value);

        if(start == null){
            start = newNode;
        }

        Node current = start;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }


    public static void Display(Node start){
        for(Node i = start; i!=null; i=i.next){
            System.out.print(i.data + " ");
        }
    }

    public static void main(String[] args) {
        Node list = new Node(10);
        list.next = new Node(20);
        addLast(list,30);
        Display(list);
    }

}

