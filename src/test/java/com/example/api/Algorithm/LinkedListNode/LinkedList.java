package com.example.api.Algorithm.LinkedListNode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedList {

    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    public LinkedList() {
        header = new Node();
    }

    void append(int d) {
       Node end = new Node();
       end.data = d;

       Node n = header;

       while (n.next != null) {
           n = n.next;
       }

       n.next = end;
    }

    void delete(int d) {
        Node n = header;

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;

        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }

        System.out.println(n.data);
    }

    @Test
    public void 메인_실행() {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }
}
