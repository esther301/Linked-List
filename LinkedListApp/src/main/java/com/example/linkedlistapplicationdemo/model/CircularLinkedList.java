package com.example.linkedlistapplicationdemo.model;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public boolean remove(T data) {
        if (head == null) return false;

        Node<T> current = head;
        Node<T> prev = null;

        do {
            if (current.data.equals(data)) {
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!current.data.equals(data)) return false;

        if (current.next == head && prev == null) {
            head = null;
        } else if (current == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = current.next;
            prev.next = head;
        } else {
            prev.next = current.next;
        }
        size--;
        return true;
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        if (head == null) return list;

        Node<T> current = head;
        do {
            list.add(current.data);
            current = current.next;
        } while (current != head);
        return list;
    }

    public int size() {
        return size;
    }
}