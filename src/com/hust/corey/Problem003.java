package com.hust.corey;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/11.
 */

/**
 * name:
 * 双核处理（网易）
 * url:
 * https://www.nowcoder.com/test/question/9ba85699e2824bc29166c92561da77fa?pid=4575457&tid=9776720
 * extra:
 * 动态规划，01背包型问题。
 *
 */
public class Problem003 implements Problem {
    @Override
    public void runSolution(Object... objects) {
        solution();
    }
    void solution(){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] t = new int[size];
        int len = 0;
        for(int i=0;i<size;i++){
            t[i] = in.nextInt() / 1024;
            len += t[i];
        }
        int[][] resTab = new int[size+1][len/2+1];

        for(int i=1;i<=size;i++){
            for(int j=1;j<=len/2;j++){
                if(i != 1 && resTab[i-1][j] == 0)
                    continue;
                int lBound = (j-t[i-1]) >= 0?j-t[i-1]:-1;
                int vis = 0;
                if(lBound != -1)
                    vis = t[i-1] + resTab[i-1][lBound];
                int unvis = resTab[i-1][j];
                resTab[i][j] = vis > unvis? vis:unvis;
            }
        }
        int res = len - resTab[size][len/2];
        System.out.println(res*1024);
//        showTab(resTab);
    }

    void showTab(int[][] resTab){
        for(int i = 0;i<resTab.length;i++){
            for(int j=0;j<resTab[0].length;j++){
                System.out.print(resTab[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
