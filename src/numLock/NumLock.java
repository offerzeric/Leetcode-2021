package numLock;

import org.junit.Test;

import java.util.*;

/**
 * 自动锁   4个1-10  翻到deasdends 就死锁   翻到target解锁   最少的转动次数   如果解锁不了返回-1
 * bfs
 *
 * @author ericzhang 2021/08/19 9:27 上午
 */
public class NumLock {

    String start = "0000";
    String target = "0009";
    String[] deadends = {"8888"};
    Set<String> visited = new HashSet<>();
    int step = 0;

    public int openLock(){
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String poll = q.poll();
                if (poll.equals(target)) {
                    return step;
                }
                if (check4Dead(poll)) {
                    continue;
                }
                char[] chars = poll.toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    String addCur = addOne(poll,i1);
                    String minusCur = minusOne(poll,i1);
                    if(check4Visited(addCur)) {
                        q.offer(addCur);
                        visited.add(addCur);
                    }
                    if(check4Visited(minusCur)) {
                        q.offer(minusCur);
                        visited.add(minusCur);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean check4Visited(String cur) {
        for (String s : visited) {
            if(s.equals(cur)){
                return false;
            }
        }
        return true;
    }

    private String minusOne(String poll, int i1) {
        char[] chars = poll.toCharArray();
        if(chars[i1] == '0'){
            chars[i1] = '9';
        }else {
            Integer temp = (int) chars[i1];
            temp -= 1;
            String s = temp.toString();
            chars[i1] = s.toCharArray()[0];
        }
        return new String(poll);
    }

    private String addOne(String poll, int i1) {
        char[] chars = poll.toCharArray();
        if(chars[i1] == '9'){
            chars[i1] = '0';
        }else {
            Integer temp = (int) chars[i1];
            temp += 1;
            String s = temp.toString();
            chars[i1] = s.toCharArray()[0];
        }
        return new String(poll);
    }

    private boolean check4Dead(String poll) {
        for (String deadend : deadends) {
            if(poll.equals(deadend)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int step = openLock();
        System.out.println(step);
    }
}

