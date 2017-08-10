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
 *
 */
public class Problem001 implements Problem{
    @Override
    public void runSolution(Object... objects) {
        solution();
    }
    void solution(){
        ArrayList<Integer> result;
        Scanner in = new Scanner(System.in);
        int N,M;
        int[] scores;
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();
            scores = new int[N];
            result = new ArrayList<>(M);
            for(int i=0;i<N;i++){
                scores[i] = in.nextInt();
            }
            for(int i=0;i<M;i++){
                char cmd = in.next().charAt(0);
                int start = in.nextInt();
                int end = in.nextInt();
                if(cmd == 'Q')
                    result.add(getHighest(scores,start,end));
                else
                    scores[start-1] = end;
            }
            for(int res : result){
                System.out.println(res);
            }
        }
    }
    int getHighest(int[] scores,int start,int end){
        if(start > end){
            int tmp = start;
            start = end;
            end = tmp;
        }
        int length = end - start + 1;
        int[] copy = new int[length];
        int max;
        System.arraycopy(scores,start-1,copy,0,length);
        max = copy[0];
        for(int num : copy){
            if(num > max)
                max = num;
        }
        return max;
    }
}
