package LinkedList.Util;

import LinkedList.Node;

public class AppUtil {
    public static void printLinkedList(Node head){
        Node temp = head;

        StringBuffer sbf = new StringBuffer();
        sbf.append("[");
        while(temp != null){
            if(lengthOfLinkedList(head) == 1){
                sbf.append(temp.data);
                temp = temp.next;
                break;
            }
            if(temp.next == null){
                sbf.append(temp.data);
                temp = temp.next;
                break;
            }
            sbf.append(temp.data).append(",");
            temp = temp.next;
        }

        sbf.append("]");

        System.out.println(sbf);
    }

    public static int lengthOfLinkedList(Node head){
        int count = 0;

        Node temp = head;

        while(temp != null){
            count ++;
            temp = temp.next;
        }

        return count;
    }
}
