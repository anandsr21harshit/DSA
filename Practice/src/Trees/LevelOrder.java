package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrder {
    
    public static List<List<Integer>> levelOrder(Node root) {

        // First find height of tree
        // Then print k distance node where 0<= k < height
        // int height = heightOfTree(root);
        // List<List<Integer>> res = new ArrayList<>();
        
        // int k = 0;
        // while(k < height){
        //     List<Integer> temp = new ArrayList<>();
        //     res.add(kDistanceNode(root,k,temp));
        //     k++;
        // }

        // Using Queue Data Structure
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node curr = queue.poll();
                level.add(curr.data);
                if (curr.leftNode != null) {
                    queue.add(curr.leftNode);
                }
                if (curr.rightNode != null) {
                    queue.add(curr.rightNode);
                }
            }
            res.add(level);
        }
        return res;
        
    }

    public static int heightOfTree(Node root){
        if(root == null) return 0;
        return Math.max(heightOfTree(root.leftNode),heightOfTree(root.rightNode)) + 1;
    }

    public  static int maxDepth(Node root) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return count;
        queue.add(root);
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(curr.leftNode != null) queue.add(curr.leftNode);
                if(curr.rightNode != null) queue.add(curr.rightNode);
            }
        }

        return count;
    }

    public static List<Integer> kDistanceNode(Node root, int k,List<Integer> res){
        if(root == null) return res;
        if(k == 0) {
            res.add(root.data);
        }
        else{
            kDistanceNode(root.leftNode,k-1,res);
            kDistanceNode(root.rightNode,k-1,res);
        }

        return res;
    }

    public static int maxNode(Node root){
        if(root == null) return Integer.MIN_VALUE;

        return Math.max(root.data,Math.max(maxNode(root.leftNode), maxNode(root.rightNode)));
    }

    public static List<Integer> leftViewofTree(Node root, int level, List<Integer> res){
        if(root == null) return res;
        if(res.size() == level) {
            res.add(root.data);
        }
        leftViewofTree(root.leftNode, level+1, res);
        leftViewofTree(root.rightNode, level+1, res);

        return res;
    }

    public static List<Integer> rightViewOfTree(Node root, int level, List<Integer> res){
        if(root == null) return res;

        if(res.size() == level) res.add(root.data);
        rightViewOfTree(root.rightNode, level+1, res);
        rightViewOfTree(root.leftNode, level+1, res);

        return res;
    }
    public static void main(String[] args) {

        /*
         *         0
         *       /   \
         *      2     4
         *     /     /  \
         *    1     3    -1
         *   / \     \     \  
         *  5   1     6     8
         */
        Node root = new Node(0);
        root.leftNode = new Node(2);
        root.rightNode = new Node(4);
        root.leftNode.leftNode = new Node(1);
        root.leftNode.rightNode = null;
        root.rightNode.leftNode = new Node(3);
        root.rightNode.rightNode = new Node(-1);

        root.leftNode.leftNode.rightNode = new Node(1);
        root.leftNode.leftNode.leftNode = new Node(5);

        root.rightNode.leftNode.rightNode = new Node(6);
        root.rightNode.rightNode.rightNode = new Node(8);
        
        
        System.out.println(maxDepth(root));
        System.out.println("maximumNode: " + maxNode(root));
        System.out.println(leftViewofTree(root, 0, new ArrayList<>()));
        System.out.println(rightViewOfTree(root, 0, new ArrayList<>()));
    }
}
