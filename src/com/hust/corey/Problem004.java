package com.hust.corey;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/11.
 */

/**
 * name:
 * 魔力手环（网易）
 * url:
 * https://www.nowcoder.com/question/next?pid=4575457&qid=83058&tid=9776720
 * extra：
 * k值为10亿级别的整数
 */
public class Problem004 implements Problem {
    @Override
    public void runSolution(Object... objects) {

    }
    void solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] circle = new int[n];
        for(int i=0;i<n;i++){
            circle[i] = in.nextInt();
        }

    }
}
