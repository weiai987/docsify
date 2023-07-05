package com.blb.tree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;

public class TreeListDemo01 {

    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode('A');
        BinaryTreeNode b = new BinaryTreeNode('B');
        BinaryTreeNode c = new BinaryTreeNode('C');
        BinaryTreeNode d = new BinaryTreeNode('D');
        BinaryTreeNode e = new BinaryTreeNode('E');
        BinaryTreeNode f = new BinaryTreeNode('F');

        a.setLeftChirld(b);
        a.setRightChirld(c);
        b.setLeftChirld(d);
        c.setLeftChirld(e);
        c.setRightChirld(f);

        BinaryTree tree = new BinaryTree(a);
//       先序遍历
        tree.preOrderTreeNode(tree.getRoot());
//       中序遍历
        tree.inOrderTreeNode(tree.getRoot());
//       后序遍历
        tree.postOrderTreeNode(tree.getRoot());
    }

}
/**
 * 二叉树节点
 */
class BinaryTreeNode  {
    private char data;  //数据
    private BinaryTreeNode leftChirld;  //左孩子
    private BinaryTreeNode rightChirld; //右孩子

    public BinaryTreeNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public BinaryTreeNode getLeftChirld() {
        return leftChirld;
    }
    public void setLeftChirld(BinaryTreeNode leftChirld) {
        this.leftChirld = leftChirld;
    }
    public BinaryTreeNode getRightChirld() {
        return rightChirld;
    }
    public void setRightChirld(BinaryTreeNode rightChirld) {
        this.rightChirld = rightChirld;
    }

    @Override
    public String toString() {
        return " {" + data + '}';
    }
}

/**
 * 二叉树
 */
class BinaryTree {
    private BinaryTreeNode root;

    //初始化二叉树
    public BinaryTree(){}

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    //   先序遍历
    public void preOrderTreeNode(BinaryTreeNode node){
        if(node == null){
            return ;
        }
        System.out.println(node);
        preOrderTreeNode(node.getLeftChirld());
        preOrderTreeNode(node.getRightChirld());
    }

    //    中序遍历
    public void inOrderTreeNode(BinaryTreeNode node){
        if(node == null){
            return ;
        }
        inOrderTreeNode(node.getLeftChirld());
        System.out.println(node);
        inOrderTreeNode(node.getRightChirld());
    }

    //    后序遍历
    public void postOrderTreeNode(BinaryTreeNode node){
        if(node == null){
            return ;
        }
        postOrderTreeNode(node.getLeftChirld());
        postOrderTreeNode(node.getRightChirld());
        System.out.println(node);
    }
}