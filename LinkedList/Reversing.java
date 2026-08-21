public class Reversing {

    Node head;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);

        if(head==null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int Size(){
        int count = 0;
        Node current_node = head;
        while(current_node!=null){
            count++;
            current_node = current_node.next;
        }
        return count;
    }

    public void Reverse(){
        int[] arr = new int[Size()];
        int index=0;

        while(head!=null){
            arr[index++] = head.data;
            head = head.next;
        }

        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Reversing list = new Reversing();
        list.addFirst(60);
        list.addFirst(50);
        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.Reverse();
    }
}
