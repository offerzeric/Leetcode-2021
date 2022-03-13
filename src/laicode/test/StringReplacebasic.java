package laicode.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * description
 *
 * @author ericzhang 2022/03/12 15:49
 */
public class StringReplacebasic {
   public String replace(String input, String source, String target) {
      // newEnd往右边 不包括newEnd是已经确认要的
      // oldEnd是正在考虑的元素  oldEnd往右边是考虑过的  oldEnd与newEnd中间是不要的
      if(input.length() == 0){
         return input;
      }
      char[] in = input.toCharArray();
      char[] sou = source.toCharArray();
      int index = sou.length - 1;
      int times = findThetimes(in,sou);
      int oldLength = in.length;
      if(target.length() > source.length()){
         //in = Arrays.copyOf(in,in.length+times*(target.length() - source.length()));
         in = Arrays.copyOf(in,in.length*3);

      }
      int newEnd = in.length - 1;
      int oldEnd = oldLength  - 1;
      char[] tar = target.toCharArray();
      Queue<Character> queue = new ArrayDeque<>();
      //如果全部匹配 替换 如果
      while(oldEnd >= 0){
         if(in[oldEnd] == sou[index] && index == 0){
            for(int i = tar.length - 1; i >= 0; i--){
               in[newEnd--] = tar[i];
            }
            oldEnd--;
            index = sou.length - 1;
            queue.clear();
         }else if(in[oldEnd] == sou[index] && oldEnd == 0){
            while(!queue.isEmpty()){
               in[newEnd--] = queue.poll();
            }
            in[newEnd--] = in[oldEnd--];
         }else if(in[oldEnd] == sou[index] ){
            queue.offer(in[oldEnd]);
            oldEnd--;
            index--;
         }else if(in[oldEnd] != sou[index] && in[oldEnd] == sou[sou.length - 1]){
            while(!queue.isEmpty()){
               in[newEnd--] = queue.poll();
            }
            //zmtnhd d 这个情况 index此时就是比h
            oldEnd--;
            index = sou.length - 2;
            queue.offer(sou[sou.length - 1]);
         }else{
            while(!queue.isEmpty()){
               in[newEnd--] = queue.poll();
            }
            in[newEnd--] = in[oldEnd--];
            index = sou.length - 1;
         }
      }
      return new String(in,newEnd+1,in.length - 1 - newEnd);
   }
   private int findThetimes(char[] in,char[] sou){
      int ii = 0;
      int si = 0;
      int res = 0;
      while(ii < in.length){
         if(in[ii] == sou[si] && si == sou.length - 1){
            res++;
            si = 0;
            ii++;
         }else if(in[ii] == sou[si]){
            ii++;
            si++;
         }else{
            si = 0;
            ii++;
         }
      }
      return res;
   }
}
