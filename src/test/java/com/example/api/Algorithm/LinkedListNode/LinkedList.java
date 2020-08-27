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

    void removeDups() {
        Node n = header;

        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    private Node KthToLast(Node first, int k) {
        Node n = first;
        int total = 1;

        while (n.next != null) {
            total++;
            n = n.next;
        }

        n = first;

        for (int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }

        return n;
    }

    class Reference {
        public int count = 0;
    }

    private Node getFirst() {
        return header;
    }

    private Node recursiveKthToLast(Node n, int k, Reference r) {

        int dd = (n != null && n.data != 0) ? n.data : 0;
        System.out.println("Node n.data => " +  dd);
        System.out.println("입문");
        //System.out.println("숫자 => " + r.count);
        if (n == null) {
            System.out.println("온적있니?");
            return null;
        }

        Node found = recursiveKthToLast(n.next, k, r);

        System.out.println("Node found => "  + found);
        System.out.println("카운트");
        r.count++;

        System.out.println(" r.count++ ->"  +  r.count);
        if (r.count == k) {

            System.out.println("무슨노드야???"  +  n.data);
            return n;
        }

        return found;
    }

    private Node pointerKthToLast(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
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

    @Test
    public void 메인_Linked_List_중복값_삭제_실행() {
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(3);
        ll.append(2);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }

    @Test
    public void 단방향_LinkedList의_끝에서_K번째_노드를_찾는_알고리즘_방법1() {
        LinkedList ll = new LinkedList();

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        int k = 1;
        Node kth = KthToLast(ll.header, k);

        // 뒤에서 k번째 값은 kth.data 입니다.
        System.out.println("Last k(" + k + ")th data is " + kth.data);
    }

    @Test
    public void 단방향_LinkedList의_끝에서_K번째_노드를_찾는_알고리즘_재귀함수_방법2() {
        LinkedList ll = new LinkedList();

        ll.append(2);
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        int k = 2; // 뒤에서 k번째 값은 kth.data 입니다.
        Reference r = new Reference();
        Node found = recursiveKthToLast(ll.getFirst(), k, r);
        System.out.println("Last k(" + k + ")th data is " + found.data);
    }

    @Test
    public void 단방향_LinkedList의_끝에서_K번째_노드를_찾는_알고리즘_포인터_방법3() {
        LinkedList ll = new LinkedList();

        ll.append(2);
        ll.append(1);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        int k = 2; // 뒤에서 k번째 값은 kth.data 입니다.
        Node found = pointerKthToLast(ll.getFirst(), k);
        System.out.println("Last k(" + k + ")th data is " + found.data);
    }
}
