package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/02/28 14:15
 */
public class GraphNode {
   public int key;
   public List<GraphNode> neighbors;

   public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
   }
}
