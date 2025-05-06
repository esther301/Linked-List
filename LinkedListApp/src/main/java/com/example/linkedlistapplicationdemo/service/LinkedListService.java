package com.example.linkedlistapplicationdemo.service;

import com.example.linkedlistapplicationdemo.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkedListService {
    private final SinglyLinkedList<Integer> singlyList = new SinglyLinkedList<>();
    private final DoublyLinkedList<Integer> doublyList = new DoublyLinkedList<>();
    private final CircularLinkedList<Integer> circularList = new CircularLinkedList<>();

    // Singly Linked List Operations
    public void addToSinglyList(int data) {
        singlyList.add(data);
    }

    public boolean removeFromSinglyList(int data) {
        return singlyList.remove(data);
    }

    public List<Integer> getSinglyList() {
        return singlyList.toList();
    }

    // Doubly Linked List Operations
    public void addToDoublyList(int data) {
        doublyList.add(data);
    }

    public boolean removeFromDoublyList(int data) {
        return doublyList.remove(data);
    }

    public List<Integer> getDoublyList() {
        return doublyList.toList();
    }

    // Circular Linked List Operations
    public void addToCircularList(int data) {
        circularList.add(data);
    }

    public boolean removeFromCircularList(int data) {
        return circularList.remove(data);
    }

    public List<Integer> getCircularList() {
        return circularList.toList();
    }
}