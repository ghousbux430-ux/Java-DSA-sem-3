public class Deletion{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public static Node Delete(Node start, int value){

        if(start == null || start.data > value){
            return start;
        }

        if(start.data == value){
            return start.next;
        }


        for(Node i=start; i.next != null; i=i.next){
            if(i.next.data > value){
                break;
            }

            if(i.next.data == value){
                i.next = i.next.next;
                break;
            }
        }

        return start;
    }


    public static void Display(Node start){
        for(Node i = start; i != null; i=i.next){
            System.out.print(i.data+" ");
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);
        n1.next.next.next = new Node(40);
        n1.next.next.next.next = new Node(50);

        Display(n1);
        System.out.println();
        n1 = Delete(n1,40);
        Display(n1);
        
    }

}
