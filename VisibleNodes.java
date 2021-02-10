import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here

/**
 * Number of Visible Nodes 
 * There is a binary tree with N nodes. You are viewing
 * the tree from its left side and can see only the leftmost nodes at each
 * level. Return the number of visible nodes. Note: You can see only the
 * leftmost nodes, but that doesn't mean they have to be left nodes. The
 * leftmost node at a level could be a right node.
 */


class Rank {

  class Node {
    int data; 
    Node left; 
    Node right; 
    Node() {
      this.data = 0; 
      this.left = null; 
      this.right = null; 
    }
    Node(int data) {
      this.data = data; 
      this.left = null; 
      this.right = null; 
    }
  }
  
  // Add any helper functions you may need here
  ArrayList<Integer> answer = new ArrayList<>();
  
  void visibleNodes(Node root, int level) {
        // Write your code here
        if( root == null) return;

        if( !answer.contains(level)){
            answer.add(level);
        }
        
        visibleNodes(root.left, level + 1);
        visibleNodes(root.right, level + 1);
      }
  

  int visibleNodes(Node root) {
    // Write your code here
    visibleNodes(root, 0);
    return answer.size(); 
    
  }

}
