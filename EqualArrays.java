import java.io.*; 
import java.util.*;

/**
* Given two arrays A and B of length N, determine if there is a way to make A
* equal to B by reversing any subarrays from array B any number of times
* 
*/



class EqualArrays {

  // Add any helper functions you may need here
  
  //Treating this problem as an anagram problem since 
  //we can reverse B multiple ways
  
  //This approach will be O(nlogn) due to sorting
  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
        
    Arrays.sort(array_a);
    Arrays.sort(array_b);
    
    for(int i = 0; i < array_a.length; i++){
      if(array_a[i] != array_b[i]) return false;
    }
    
    return true;    
  }
  
  //O(N) 
  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
    
    HashMap<Integer,Integer> map = new HashMap<>();

    Integer freq;
    for(int e: array_a){
        freq = map.get(e);
        map.put(e, (freq == null) ? 1 : freq + 1 );        
    }

    for(int e: array_b){
        freq = map.get(e);
        if( freq == null || freq == 0) return false;
        map.put(e, freq - 1 );        
    }
    
    return true;
  }

}
