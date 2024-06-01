package LinkedList.ReverseLinkedList;

import LinkedList.Node;
import LinkedList.Util.AppUtil;

public class Main {

    public static Node reverseLinkedList(Node head){
        Node temp = head.next;
        Node prev = head, curr = null;
        head.next = null;

        while(temp != null){
            curr = temp;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
//        head.next.next.next.next = new Node(50);
//        head.next.next.next.next.next = new Node(60);

        System.out.println("LL before reversing");
        AppUtil.printLinkedList(head);

        Node reverseHead = reverseLinkedList(head);

        System.out.println("LL after reversing");
        AppUtil.printLinkedList(reverseHead);

    }
}
