import java.io.*; 
import java.util.*;

 /**
     * Given a list of n integers arr[0..(n-1)], determine the number of different
     * pairs of elements within it which sum to k. If an integer appears in the list
     * multiple times, each copy is considered to be different; that is, two pairs
     * are considered different if one pair includes at least one array index which
     * the other doesn't, even if they include the same values.
     * 
     */

class PairSums {
  

  int numberOfWays(int[] arr, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int dif, count=0;

      Integer val;
      for(int e: arr){  
          val = map.get(e);
          if( val != null ){
              count += val;
              map.put(e, val + 1);
          }
          else{
              dif = k - e;
              map.put(dif, 1);
          }          
      }
      return count;
  }
  
  int numberOfWays2(int[] arr, int k) {
    Map<Integer,Integer>maps = new HashMap<>();
    int counter = 0;
    int diff = 0;
      
    for( int num : arr) {
        diff = k - num;
        if ( maps.containsKey(num) ){
            counter += maps.get(num);
            maps.put(num, maps.get(num)+1);
          }
        else{
            maps.put(diff, 1);
        }
      }
    return counter;
 }
    
 int numberOfWays3(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        //count and store frequencies
        Integer freq;
        for(int e: arr){  
            freq = map.get(e);
            map.put(e, freq == null ? 1 : freq+1);          
        }

        //second traversal
        int dif, count=0;
        for(int i = 0; i < n; i++){
            dif = k - arr[i];
            if( map.containsKey(dif)){
                count += map.get(dif);
            }
            if(k - arr[i] == arr[i]){
                count--;
            }
        } 
        
        //return half of the count
        return count/2;
  }
}
