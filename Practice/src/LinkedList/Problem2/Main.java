package LinkedList.Problem2;

import LinkedList.Node;
import LinkedList.Util.AppUtil;

public class Main {

    public static int lengthOfLinkedList(Node head){
        int length = 0;

        Node temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public static Node deleteTailNode(Node head){
        Node temp = head;

        if(temp == null || temp.next == null) return null;

        while(temp.next != null && temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public static boolean searchElement(Node head, int item){
        Node temp = head;

        while(temp != null){
            if(temp.data == item){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        AppUtil.printLinkedList(head);
        System.out.println("Length of LL: " + lengthOfLinkedList(head));
        System.out.println("===========");

        head = deleteTailNode(head);
        AppUtil.printLinkedList(head);

        System.out.println("Length of LL: " + lengthOfLinkedList(head));

        System.out.println(searchElement(head,50));
    }
}
