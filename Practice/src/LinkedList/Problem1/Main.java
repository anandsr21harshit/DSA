package LinkedList.Problem1;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {

    private static void printLinkedList(Node head){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static Node insertAtTheBeginning(Node head, int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        return head;
    }

    private static Node insertAtTheEnd(Node head,int data){
        Node temp = head;

        Node newEntry = new Node(data);

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newEntry;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printLinkedList(head);

        Node newHead = insertAtTheBeginning(head,5);
        System.out.println("============");
        printLinkedList(newHead);

        insertAtTheEnd(newHead,50);
        System.out.println("============");
        printLinkedList(newHead);

    }


}
