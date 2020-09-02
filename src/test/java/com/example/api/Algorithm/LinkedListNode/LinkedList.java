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

        public Node() {}

        public Node(int i) {
            this.data = i;
        }

        public Node addNext(int i) {
            Node newNode = new Node();
            newNode.data = i;

            Node n = this;
            while (n.next != null) {
                n = n.next;
            }

            n.next = newNode;

            return n;
        }

        public Node addNext(Node node) {

            Node n = this;
            while (n.next != null) {
                n = n.next;
            }

            n.next = node.next;

            return n;
        }

        public Node get(int index) {
            Node n = this;

            for (int i = 0; i < index; i++) {
                n = n.next;
            }

            return n;
        }

        public void print() {
            Node n = this;

            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    public LinkedList() {
        header = new Node();
    }

    public Node get(int i) {
        Node n = header;

        for (int j = 0; j < i; j++) {
            n = n.next;
        }

        return n;
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
        System.out.println("Node n.data => " + dd);
        System.out.println("입문");
        //System.out.println("숫자 => " + r.count);
        if (n == null) {
            System.out.println("온적있니?");
            return null;
        }

        Node found = recursiveKthToLast(n.next, k, r);

        System.out.println("Node found => " + found);
        System.out.println("카운트");
        r.count++;

        System.out.println(" r.count++ ->" + r.count);
        if (r.count == k) {

            System.out.println("무슨노드야???" + n.data);
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

    private static boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;

        return true;
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

    @Test
    public void 단방향_LinkedList의_중간노드_삭제() {
        LinkedList ll = new LinkedList();

        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        deleteNode(ll.get(2));
        ll.retrieve();
    }

    @Test
    public void 단방향_LinkedList의_Digit합산_알고리즘() {
        LinkedList l1 = new LinkedList();

        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();

        LinkedList l2 = new LinkedList();

        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve();

        Node node = sumeLists(l1.header.next, l2.header.next, 0);

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }

        System.out.println(node.data);
    }

    private static Node sumeLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();

        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        System.out.println("value =>" + value);
        result.data = value % 10;

        System.out.println("result =>" + result.data);

        if (l1 != null || l2 != null) {
            Node next = sumeLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = next;
        }

        return result;
    }

    /*
      4 -> 1 -> 9 = 419
    + 0 -> 3 -> 4 =  34
    -------------------

     */
    @Test
    public void 단방향_LinkedList의_Digit합산_알고리즘_거꾸로_계산하기() {
        LinkedList l1 = new LinkedList();

        l1.append(4);
        l1.append(1);
        l1.append(9);
        l1.retrieve();

        LinkedList l2 = new LinkedList();

        l2.append(3);
        l2.append(4);
        l2.retrieve();

        Node node = sumLists(l1.header.next, l2.header.next);
        while (node.next != null) {
            System.out.println(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    private static Node sumLists(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 < len2) {
            l1 = LPadList(l1, len2 - len1);
        } else {
            l2 = LPadList(l2, len1 - len2);
        }

        Storage storage = addLists(l1, l2);

        if (storage.carry != 0) {
            storage.result = insertBefore(storage.result, storage.carry);
        }

        return storage.result;
    }

    private static Storage addLists(Node l1, Node l2) {

        if (l1 == null && l2 == null) {
            return new Storage();
        }

        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        int data = value % 10;

        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;

        return storage;
    }

    private static int getListLength(Node l) {
        int total = 0;

        while (l != null) {
            total++;
            l = l.next;
        }

        return total;
    }

    private static Node insertBefore(Node node, int data) {
        Node before = new Node();
        before.data = data;

        if (node != null) {
            before.next = node;
        }

        return before;
    }

    private static Node LPadList(Node l, int length) {
        Node head = l;

        for (int i = 0; i < length; i++) {
            head = insertBefore(head, 0);
        }

        return head;
    }

    static class Storage {
        int carry = 0;
        Node result = null;
    }


    /*
     * 주어진 두개의 단방향 Linked List 에서 교차되는 노드를 찾으시오. (단, 교차점은 값이 아닌 주소로 찾아야함)
    -------------------

     */
    @Test
    public void 단방향_LinkedList의_교차점_찾기() {
        Node n1 = new Node(5);
        Node n2 = n1.addNext(7);
        Node n3 = n2.addNext(9);
        Node n4 = n3.addNext(10);
        Node n5 = n4.addNext(7);
        Node n6 = n5.addNext(6);

        Node m1 = new Node(6);
        Node m2 = m1.addNext(8);
        Node m3 = m2.addNext(n4);

        n1.print();
        m1.print();

        Node n = getIntersection(n1, m1);

        if (n != null) {
            System.out.println("Intersection: " + n.data);
        } else {
            System.out.println("Not found");
        }
    }

    private static Node getIntersection(Node l1, Node l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if (len1 > len2) {
            l1 = l1.get(len1 - len2);
        } else if (len1 < len2) {
            l2 = l2.get(len2 - len1);
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }


    @Test
    public void 단방향_LinkedList의_루프_찾기() {
        Node n1 = new Node(1);
        Node n2 = n1.addNext(2);
        Node n3 = n2.addNext(3);
        Node n4 = n3.addNext(4);
        Node n5 = n4.addNext(5);
        Node n6 = n5.addNext(6);
        Node n7 = n6.addNext(7);
        Node n8 = n7.addNext(8);

        n8.addNext(n4);

        Node n = findLoop(n1);

        if (n != null) {
            System.out.println("Start of loop : " + n.data);
        } else {
            System.out.println("Loop Not Found");
        }
    }

    private static Node findLoop(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}