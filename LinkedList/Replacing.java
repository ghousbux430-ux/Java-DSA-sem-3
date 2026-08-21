public class Replacing{

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node Replace(Node start, int x, int y){
        if(start==null){
            return start;
        }

        if(start.data == x){
            start.data = y;
            return start;
        }

        for(Node i = start; i.next!=null; i=i.next){
            if(i.next.data > x){
                break;
            }

            if(i.next.data==x){
                i.next.data = y;
                break;
            }
        }
        return start;
    }

    public static void Print(Node start){

        for(Node i=start; i!=null; i=i.next){
            System.out.print(i.data+" ");
        }

        System.out.println();
    }


    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);

        Print(n1);

        Replace(n1,20,25);

        Print(n1);
    }
}

