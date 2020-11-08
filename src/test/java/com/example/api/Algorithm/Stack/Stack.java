package com.example.api.Algorithm.Stack;

import org.apache.ibatis.type.Alias;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.EmptyStackException;

@RunWith(JUnit4.class)
@Alias("AlgorithmStack")
public class Stack<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;

        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Test
    public void Stack_구현하기() {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("s.pop() = " + s.pop());
        System.out.println("s.pop() = " + s.pop());
        System.out.println("s.peek() = " + s.peek());
        System.out.println("s.pop() = " + s.pop());
        System.out.println("s.isEmpty() = " + s.isEmpty());
        System.out.println("s.pop() = " + s.pop());
        System.out.println("s.isEmpty() = " + s.isEmpty());
    }

}
