package LinkedList.Util;

import LinkedList.Node;

public class AppUtil {
    public static void printLinkedList(Node head){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
