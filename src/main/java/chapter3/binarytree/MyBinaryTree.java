package chapter3.binarytree;

import chapter2.linkedlist.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 * @author koujn
 * @date 2021/4/30 9:36
 */
public class MyBinaryTree {

    /**
     * 构建二叉树
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList == null && inputList.isEmpty()){
            return null;
        }
        Integer data =  inputList.poll();
        if(data != null){
            node =new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树非递归前序遍历
     * @param root  二叉树节点
     */
    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子,则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     * @param root 二叉树根节点
     */
    public static void levelOrderTraversal(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if(node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if(node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode binaryTree = createBinaryTree(inputList);
        System.out.println("前序遍历： ");
        preOrderTraveral(binaryTree);
        System.out.println("中序遍历 ：");
        inOrderTraveral(binaryTree);
        System.out.println("后续遍历 ： ");
        postOrderTraveral(binaryTree);
        System.out.println("非递归前序遍历： ");
        preOrderTraveralWithStack(binaryTree);
    }
}
