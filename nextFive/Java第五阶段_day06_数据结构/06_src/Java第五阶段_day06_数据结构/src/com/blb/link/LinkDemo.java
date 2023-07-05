package com.blb.link;

//单向链表的代码实现
public class LinkDemo {

    public static void main(String[] args) {

        LinkList theList = new LinkList(); // make new list
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);
        System.out.println(theList.isEmpty());
        theList.displayList();
        theList.deleteFirst();
        theList.displayList();

    }

}

//链表中的节点对象
class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.print("{" + data + "} ");
    }
}

class LinkList{

    private Node first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) { // make new link
        Node newNode = new Node(data);
        newNode.next = first; // newLink --> old first
        first = newNode; // first --> newLink
    }

    public Node deleteFirst(){     // delete first item
        if(!isEmpty()) {
            Node temp = first;          // save reference to link
            first = first.next;         // delete it: first-->old next
            return temp;                // return deleted link
        }
        return null;

    }
    public void displayList() {
        System.out.print("List (first-->last): ");
        Node current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.display(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

}