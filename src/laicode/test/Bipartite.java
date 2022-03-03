package laicode.test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/02/28 14:14
 */
public class Bipartite {
   public boolean isBipartite(List<GraphNode> graph) {
      // write your solution here
      // bfs every node to check the neighbor and point
      if(graph.size() == 0 || graph.size() == 1){
         return true;
      }
      HashMap<GraphNode,Integer> visit = new HashMap();
      Queue<GraphNode> queue = new ArrayDeque();
      for(int i = 0;i < graph.size();i++){
         GraphNode temp = graph.get(i);
         if(visit.containsKey(temp)){
            //保证了每次存入一个node 他的所有neighbor都被bfs赋值过或者都被bfs判断过
            continue;
         }
         visit.put(temp,0);
         queue.offer(temp);
         while(!queue.isEmpty()){
            GraphNode node = queue.poll();
            int val = visit.get(node);
            int need = val==0?1:0;
            for(GraphNode n : node.neighbors){
               if(visit.containsKey(n)){
                  if(visit.get(n) != need){
                     return false;
                  }
               }else{
                  visit.put(n,need);
                  queue.offer(n);
               }
            }
         }
      }
      return true;
   }
}
