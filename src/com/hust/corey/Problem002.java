package com.hust.corey;
import java.io.*;
/**
 * Created by Administrator on 2017/8/10.
 */

/**
 * name:
 * 数独（华为）
 * url:
 * https://www.nowcoder.com/practice/2b8fa028f136425a94e1a733e92f60dd?tpId=49&tqId=29298&tPage=1&rp=1&ru=/ta/2016test&qru=/ta/2016test/question-ranking
 *
 */
public class Problem002 implements Problem{
    @Override
    public void runSolution(Object... objects) {

    }
    void solution()throws IOException{
        int[][] array = new int[9][9];
        boolean[] existed = new boolean[81];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                array[i][j] = br.read();
                existed[array[i][j]] = true;
            }
        //TODO to be continued

    }
}
