package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    // left root right
    static void inOrderPrint(Node root){
        if(root == null)return;
        inOrderPrint(root.leftNode);
        System.out.print(root.data + " ");
        inOrderPrint(root.rightNode);
    }

    // root left right
    static void preOrderPrint(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");

        preOrderPrint(root.leftNode);
        preOrderPrint(root.rightNode);
    }
    
    // left right root
    static void postOrderPrint(Node root){
        if(root == null) return;

        postOrderPrint(root.leftNode);
        postOrderPrint(root.rightNode);
        System.out.print(root.data + " ");
    }

    static List<Integer> inOrderIterativeTraversal(Node root){
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (true) {
            if(node != null){
                stack.push(node);
                // move to left node
                node = node.leftNode;
            }else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                inOrder.add(node.data);
                node = node.rightNode;
            }
        }

        return inOrder;
    }
    
    static List<Integer> preOrderIterativeTraversal(Node root){
        List<Integer> preOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (true) {
            if(node != null){
                stack.push(node); 
                preOrder.add(node.data);
                node = node.leftNode;
            }else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                node = node.rightNode;
            }
        }

        return preOrder;
    }

    public static int isSum(Node root){
        if(root == null) return 1;
        if(root.leftNode == null && root.rightNode == null) return 1;
        
        int sum = 0;
        
        if(root.leftNode != null) sum = sum + root.leftNode.data;
        if(root.rightNode != null) sum = sum + root.rightNode.data;
        
        if(root.data == sum && isSum(root.leftNode) == 1 && isSum(root.rightNode) == 1){
            return 1;
        }

        return 0;
    }
    
    public static boolean isBalanced(Node root){
        if(root == null) return false;
        if(heightOfBalancedTree(root) == -1) return false;
        return true;
    }
    // return actual height if balanced
    // else return -1
    public static int heightOfBalancedTree(Node root){
        if(root == null) return 0;
        int leftHeight = heightOfBalancedTree(root.leftNode);
        int rightHeight = heightOfBalancedTree(root.rightNode);
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }
    
    public static void main(String[] args) {
    /*
     *               35
                    /  \
                  20    15
                /  \   /  \
               15    5 10   5
     */
        Node root = new Node(35);
        root.leftNode = new Node(20);
        root.rightNode = new Node(15);
        root.leftNode.leftNode = new Node(15);
        root.leftNode.rightNode = new Node(5);
        // root.leftNode.rightNode = new Node(25);
        root.rightNode.leftNode = new Node(10);
        root.rightNode.rightNode = new Node(5);
        root.rightNode.rightNode.rightNode = new Node(21);
        root.rightNode.rightNode.rightNode.rightNode = new Node(50);
        System.out.println("InOrder:");
        inOrderPrint(root);
        System.out.println();
        System.out.println("PreOrder:");
        preOrderPrint(root);
        System.out.println();
        System.err.println("PostOrder:");
        postOrderPrint(root);
        System.out.println();
        System.out.println("InOrder Iterative:");
        System.out.println(inOrderIterativeTraversal(root));
        System.out.println("PreOrder Iterative:");
        System.out.println(preOrderIterativeTraversal(root));
        System.out.println("PostOrder Iterative:");

        System.out.println("ChildrenSum: " + isSum(root));

        System.out.println("Height:" + heightOfBalancedTree(root));
        System.out.println("IsBalanced:" + isBalanced(root));

    }
}
