import java.io.*; 
import java.util.*;

/**
     * Given two arrays A and B of length N, determine if there is a way to make A
     * equal to B by reversing any subarrays from array B any number of times
     * 
     * @param array_a
     * @param array_b
     * @return
     */



class EqualArrays {

  // Add any helper functions you may need here
  

  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
    Arrays.sort(array_a);
    Arrays.sort(array_b);
    
    for(int i = 0; i < array_a.length; i++){
      if(array_a[i] != array_b[i]) return false;
    }
    
    return true;    
  }

}
