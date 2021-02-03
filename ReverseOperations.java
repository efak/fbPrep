import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class ReverseOperations {
  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }

  // Add any helper functions you may need here  

  Node reverse(Node head) {
    // Write your code here
    Node current, runner, dummy, prev, revhead;
        dummy = new Node(-1);
        dummy.next = head;
        current = dummy;
        runner = dummy;

        while (current.next != null) {
            if (current.next.data % 2 == 0) {
                runner = current.next;
                while (runner.next != null && runner.next.data % 2 == 0) {
                    runner = runner.next;
                }

                // reverse
                prev = current;
                revhead = (runner != null) ? runner.next : null;
                while (current != runner) {
                    Node newNode = new Node(current.next.data);
                    newNode.next = revhead;
                    revhead = newNode;
                    current = current.next;
                }

                prev.next = revhead;

            } else {
                current = current.next;
            }

        }

        return dummy.next;
  }

}
