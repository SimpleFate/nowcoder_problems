package com.hust.corey;

/**
 * Created by Administrator on 2017/8/10.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * name:
 * 最高分是多少（华为）
 * url:
 * https://www.nowcoder.com/practice/3897c2bcc87943ed98d8e0b9e18c4666?tpId=49&tqId=29275&tPage=1&rp=1&ru=/ta/2016test&qru=/ta/2016test/question-ranking
 * extra:
 * Scanner的平均耗时是BufferedReader的10倍左右
 */
public class Problem001 implements Problem{
    @Override
    public void runSolution(Object... objects) {
        solution();
    }
    void solution(){
        Scanner in = new Scanner(System.in);
        int N,M;
        int[] scores;
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            scores = new int[N];
            for(int i=0;i<N;i++){
                scores[i] = in.nextInt();
            }
            for(int i=0;i<M;i++){
                char cmd = in.next().charAt(0);
                int start = in.nextInt();
                int end = in.nextInt();
                if(cmd == 'Q')
                    System.out.println(getHighest(scores,start,end));
                else
                    scores[start-1] = end;
            }
        }
    }
    int getHighest(int[] scores,int start,int end){
        if(start > end){
            int tmp = start;
            start = end;
            end = tmp;
        }
        int max = scores[start-1];
        for(int i = start-1;i<end;i++){
            if(scores[i] > max)
                max = scores[i];
        }

        return max;
    }
}
