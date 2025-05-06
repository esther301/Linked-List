package com.example.linkedlistapplicationdemo.controller;

import com.example.linkedlistapplicationdemo.service.LinkedListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linkedlist")
public class LinkedListController {
    private final LinkedListService linkedListService;

    public LinkedListController(LinkedListService linkedListService) {
        this.linkedListService = linkedListService;
    }

    // Singly Linked List Endpoints
    @PostMapping("/singly/add")
    public ResponseEntity<String> addToSinglyList(@RequestBody Integer data) {
        linkedListService.addToSinglyList(data);
        return ResponseEntity.ok("Added " + data + " to singly linked list");
    }

    @DeleteMapping("/singly/remove")
    public ResponseEntity<String> removeFromSinglyList(@RequestParam int data) {
        boolean removed = linkedListService.removeFromSinglyList(data);
        if (removed) {
            return ResponseEntity.ok("Removed " + data + " from singly linked list");
        }
        return ResponseEntity.badReque st().body(data + " not found in singly linked list");
    }

    @GetMapping("/singly")
    public ResponseEntity<List<Integer>> getSinglyList() {
        return ResponseEntity.ok(linkedListService.getSinglyList());
    }

    // Doubly Linked List Endpoints
    @PostMapping("/doubly/add")
    public ResponseEntity<String> addToDoublyList(@RequestParam int data) {
        linkedListService.addToDoublyList(data);
        return ResponseEntity.ok("Added " + data + " to doubly linked list");
    }

    @DeleteMapping("/doubly/remove")
    public ResponseEntity<String> removeFromDoublyList(@RequestParam int data) {
        boolean removed = linkedListService.removeFromDoublyList(data);
        if (removed) {
            return ResponseEntity.ok("Removed " + data + " from doubly linked list");
        }
        return ResponseEntity.badRequest().body(data + " not found in doubly linked list");
    }

    @GetMapping("/doubly")
    public ResponseEntity<List<Integer>> getDoublyList() {
        return ResponseEntity.ok(linkedListService.getDoublyList());
    }

    // Circular Linked List Endpoints
    @PostMapping("/circular/add")
    public ResponseEntity<String> addToCircularList(@RequestBody Integer data) {
        linkedListService.addToCircularList(data);
        return ResponseEntity.ok("Added " + data + " to circular linked list");
    }

    @DeleteMapping("/circular/remove")
    public ResponseEntity<String> removeFromCircularList(@RequestParam int data) {
        boolean removed = linkedListService.removeFromCircularList(data);
        if (removed) {
            return ResponseEntity.ok("Removed " + data + " from circular linked list");
        }
        return ResponseEntity.badRequest().body(data + " not found in circular linked list");
    }

    @GetMapping("/circular")
    public ResponseEntity<List<Integer>> getCircularList() {
        return ResponseEntity.ok(linkedListService.getCircularList());
    }
}