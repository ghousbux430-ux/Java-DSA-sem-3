public class NodeSublist {

    int data;
    NodeSublist next;

    // Constructor
    public NodeSublist(int data) {
        this.data = data;
        this.next = null;
    }

    // Constructor with next node
    NodeSublist(int data, NodeSublist next) {
        this.data = data;
        this.next = next;
    }

    // Insert a value in sorted order
    public static NodeSublist insert(NodeSublist start, int x) {

        // Insert at beginning
        if (start == null || start.data > x) {
            start = new NodeSublist(x, start);
            return start;
        }

        NodeSublist p = start;

        // Find the correct position
        while (p.next != null) {
            if (p.next.data > x) {
                break;
            }

            p = p.next;
        }

        // Insert the new node
        p.next = new NodeSublist(x, p.next);

        return start;
    }

    // Create a sublist from index p to q
    static NodeSublist sublist(NodeSublist list, int p, int q) {
        // Invalid range or empty list
        if (list == null || p < 0 || p > q) {
            return null;
        }
        NodeSublist newList = null;
        NodeSublist current = list;
        int counter = 0;
        // Traverse the list
        while (current != null && counter <= q) {

            if (counter >= p) {
                newList = insert(newList, current.data);
            }
            current = current.next;
            counter++;
        }
        return newList;
    }

    // Split the linked list into two halves
    static NodeSublist[] splitInHalf(NodeSublist list) {

        if (list == null) {
            return new NodeSublist[]{null, null};
        }

        // Count total nodes
        int totalCount = 0;
        NodeSublist temp = list;

        while (temp != null) {
            totalCount++;
            temp = temp.next;
        }

        // Calculate midpoint
        // For odd length, first half gets the extra node
        int mid = (totalCount + 1) / 2;

        // Move to midpoint
        NodeSublist current = list;

        for (int i = 1; i < mid; i++) {
            current = current.next;
        }

        // Separate the two halves
        NodeSublist secondHalf = current.next;
        current.next = null;

        return new NodeSublist[]{list, secondHalf};
    }

    public static void main(String[] args) {

        // Create an empty linked list
        NodeSublist a = null;

        // Insert elements
        a = insert(a, 30);
        a = insert(a, 50);
        a = insert(a, 10);
        a = insert(a, 20);
        a = insert(a, 40);
        a = insert(a, 60);

        // Create sublist from index 2 to 4
        NodeSublist newList = sublist(a, 2, 4);

        System.out.println("Sublist:");

        for (NodeSublist b = newList; b != null; b = b.next) {
            System.out.println(b.data);
        }

        // Split the original list into two halves
        NodeSublist[] parts = splitInHalf(a);

        System.out.println("\nFirst part:");

        for (NodeSublist b = parts[0]; b != null; b = b.next) {
            System.out.println(b.data);
        }

        System.out.println("\nSecond part:");

        for (NodeSublist b = parts[1]; b != null; b = b.next) {
            System.out.println(b.data);
        }
    }
}
