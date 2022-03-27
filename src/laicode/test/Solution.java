package laicode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2022/03/25 23:40
 */
public class Solution {

   /**
    * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    * <p>
    * 求在魔王苏醒之前，可以获取到价值最高的宝物列表；
    *
    * @param packageSize  int整型 背包容量
    * @param wakeTime     int整型 魔王睡醒时长
    * @param treasureInfo int整型二维数组 宝物信息数组；宝物信息数组；[[宝物id, 宝物距离, 宝物重量, 宝物价值]]
    * @return int整型一维数组
    */
   public static int[] getTreasures(int packageSize, int wakeTime, int[][] treasureInfo) {
      // write code here
      if (wakeTime == 0 || packageSize == 0) {
         return new int[0];
      }
      int[] maxRes = new int[treasureInfo.length];
      int time = 0;
      int size = 0;
      List<Integer> cur = new ArrayList<>();
      List<List<Integer>> list = new ArrayList<>();
      int index = 0;
      getTreasures(index, list, cur, packageSize, wakeTime, treasureInfo, time, size);
      int valueSumForEachRes = 0;
      int global = Integer.MIN_VALUE;
      for (List<Integer> integers : list) {
         for (Integer integer : integers) {
            int value = treasureInfo[integer - 1][3];
            valueSumForEachRes += value;
         }
         if (global < valueSumForEachRes) {
            global = valueSumForEachRes;
            putToRes(integers, maxRes);
         }
      }
      return maxRes;
   }

   private static void putToRes(List<Integer> integers, int[] maxRes) {
      int index = 0;
      while (index < integers.size() && index < maxRes.length) {
         maxRes[index] = integers.get(index);
         index++;
      }
   }

   private static void getTreasures(int index, List<List<Integer>> list, List<Integer> cur, int packageSize, int wakeTime, int[][] treasureInfo, int time, int size) {
      if (time == wakeTime || size == packageSize || cur.size() == treasureInfo.length || index == treasureInfo.length) {
         list.add(new ArrayList<>(cur));
         return;
      }
      for (int i = index; i < treasureInfo.length; i++) {
         swap(i, index, treasureInfo);
         cur.add(treasureInfo[index][0]);
         getTreasures(index + 1, list, cur, packageSize, wakeTime, treasureInfo, time + 1, size + treasureInfo[index][2]);
         cur.remove(cur.size()-1);
         swap(i, index, treasureInfo);
      }
   }

   private static void swap(int i, int index, int[][] treasureInfo) {
      int[] temp = treasureInfo[i];
      treasureInfo[i] = treasureInfo[index];
      treasureInfo[index] = temp;
   }

   public static void main(String[] args) {
      int pack = 6;
      int wake = 10;
      int[][] tr = new int[3][3];
      tr[0] = new int[]{1,2,3,4};
      tr[1] = new int[]{2,3,2,2};
      tr[2] = new int[]{3,4,1,4};
      getTreasures(pack,wake,tr);
   }


}
