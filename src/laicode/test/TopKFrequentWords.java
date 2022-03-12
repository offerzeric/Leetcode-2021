package laicode.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * description
 *
 * @author ericzhang 2022/03/11 15:20
 */
public class TopKFrequentWords {
   public String[] topKFrequent(String[] combo, int k) {
      // Write your solution here
      if(combo.length == 0){
         return new String[0];
      }
      String[] res = null;
      Map<String, Integer> map = convertStringToMap(combo);
      PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue(k,new Comparator<Map.Entry<String, Integer>>(){
         @Override
         public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
            return e1.getValue().compareTo(e2.getValue());
         }
      });
      for(Map.Entry<String, Integer> entry : map.entrySet()){
         if(pq.size() < k){
            pq.offer(entry);
         }else{
            if(entry.getValue() > pq.peek().getValue()){
               pq.poll();
               pq.offer(entry);
            }
         }
      }
      res = pqToStringArray(pq);
      return res;
   }
   private Map<String, Integer> convertStringToMap(String[] combo){
      Map<String, Integer> map = new HashMap<>();
      for(String item:combo){
         if(map.containsKey(item)){
            map.put(item,map.get(item)+1);
         }else{
            map.put(item,1);
         }
      }
      return map;
   }
   private String[] pqToStringArray(PriorityQueue<Map.Entry<String, Integer>> pq){
      String[] res = new String[pq.size()];
      int index = res.length - 1;
      while(!pq.isEmpty()){
         res[index--] = pq.poll().getKey();
      }
      return res;
   }
}
