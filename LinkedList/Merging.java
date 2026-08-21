public class Merging {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void Merge(Merging list2){
        if(head==null){
            head = list2.head;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = list2.head;
    }
    public void Print(){
        for(Node i=head; i!=null; i=i.next){
            System.out.print(i.data+" ");
        }
    }
    public static void main(String[] args) {
        Merging list1 = new Merging();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        list1.Print();
        System.out.println();

        Merging list2 = new Merging();
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);

        list2.Print();
        System.out.println();

        
        list1.Merge(list2);
        list1.Print();

    }
}

