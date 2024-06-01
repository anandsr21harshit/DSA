package LinkedList.Problem3;

import LinkedList.Node;
import LinkedList.Util.AppUtil;

public class Main {

    // brute force
    // O(N)
    // this requires two traversals
    public static Node findMiddleNodeBruteForce(Node head){
        int length = AppUtil.lengthOfLinkedList(head);  // O(N)
        Node temp = head;
        for(int i=0;i<length/2;i++){   // O(N/2)
            temp = temp.next;
        }

       return temp;
    }

    public static Node findMiddleNode(Node head){
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
//        Node head = null;
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        System.out.println(findMiddleNodeBruteForce(head).data);
        System.out.println(findMiddleNode(head).data);
    }
}
