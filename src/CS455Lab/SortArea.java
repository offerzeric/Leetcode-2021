package CS455Lab;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * description
 *
 * @author ericzhang 2022/03/09 21:49
 */
public class SortArea {
   public static void main(String[] args) {
      Rectangle[] rectangles = new Rectangle[3];
      Rectangle r1 = new Rectangle(1, 2, 2, 3);
      Rectangle r2 = new Rectangle(2, 3, 3, 4);
      Rectangle r3 = new Rectangle(3, 4, 4, 5);
      rectangles[0] = r3;
      rectangles[1] = r2;
      rectangles[2] = r1;
      Arrays.sort(rectangles, new Comparator<Rectangle>() {
         @Override
         public int compare(Rectangle o1, Rectangle o2) {
            if ((o1.getHeight() * o1.getWidth() ) == (o2.getHeight() * o2.getWidth())) {
               return 0;
            }
            return (o1.getHeight() * o1.getWidth()) < (o2.getHeight() * o2.getWidth()) ? -1 : 1;
         }
      });
      for (Rectangle rectangle : rectangles) {
         System.out.println(rectangle.getWidth()*rectangle.getHeight());
      }
   }
}
