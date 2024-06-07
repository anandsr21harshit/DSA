package LinkedList.ReverseLinkedList;

import LinkedList.Node;
import LinkedList.Util.AppUtil;

import java.util.Collections;

public class Main {

    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;

        while(curr != null){
            // store ref of next node
            Node front = curr.next;

            // reverse direction of current node's next pointer to prev
            curr.next = prev;

            // make prev as current node
            prev = curr;

            curr = front;

        }

        return prev;
    }

    public static void main(String[] args) {
//        Node head = null;
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println("LL before reversing");
        AppUtil.printLinkedList(head);

        Node reverseHead = reverseLinkedList(head);

        System.out.println("LL after reversing");
        AppUtil.printLinkedList(reverseHead);

    }
}
