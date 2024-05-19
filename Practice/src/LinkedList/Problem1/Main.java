package LinkedList.Problem1;

import LinkedList.Node;
import LinkedList.Util.AppUtil;

public class Main {

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

        AppUtil.printLinkedList(head);

        Node newHead = insertAtTheBeginning(head,5);
        System.out.println("============");
        AppUtil.printLinkedList(newHead);

        insertAtTheEnd(newHead,50);
        System.out.println("============");
        AppUtil.printLinkedList(newHead);

    }


}
