package com.example.api.HashCodeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;

@RunWith(JUnit4.class)
public class HashTable {
    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String value() {
            return value;
        }

        void value(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data;

    public HashTable() {}

    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashcode = 0;

        for (char c : key.toCharArray()) {
            hashcode += c;
        }

        return hashcode;
    }

    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null;

        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }

        return null;
    }

    void put(String key, String value) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);

        System.out.println( key + ", hashcode(" + hashcode + "), index(" + index + ")");

        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value(value);
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);

        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.value();
    }

    @Test
    public void 메인_실행() {
        HashTable h = new HashTable(3);
        h.put("sung", "She is pretty");
        h.put("jin", "She is model");
        h.put("hee", "She is an angel");
        h.put("min", "She is cute");
        h.put("sung", "She is pretty2");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
        System.out.println(h.get("jae"));
    }

}

