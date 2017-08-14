package com.hust.corey;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
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
       try{
           solution();
       }catch (IOException e){
           e.printStackTrace();
       }
    }


    void solution()throws IOException{
        int[][] array = new int[9][9];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                array[i][j] = in.nextInt();
            }
        int pos = findNext(array,0,0);

        if(pos != -1)
            dfs(array,pos/9);
    }
    int findNext(int[][] array,int row,int col){
        for (int i = row; i < 9; i++) {
            for(int j = col; j < 9; j++){
                if(array[i][j] == 0)
                    return row*9 + col;
            }
        }
        return -1;
    }
    int[] findNextLine(int[][] array,int row){
        int[] cols = new int[9];
        for(int i=0;i<9;i++){
            if(array[row][i] == 0){
                cols[i] = -1;
            }
        }
        return cols;
    }
    void dfs(int[][] array,int row){
        int[] cols = findNextLine(array,row);
        for (int i = 0; i < 9; i++) {
            if(cols[i] == 0)
                continue;
            for (int j = 1; j <= 9 ; j++) {
                if(checkAll(array,row,i,j)){
                    cols[i] = j;
                }
            }
            
        }


    }
    boolean checkAll(int[][] array,int row,int col,int num){
        return checkCol(array,col,num)
                && checkRow(array,row,num)
                && checkSquare(array,row,col,num);
    }
    boolean checkSquare(int[][] array,int row,int col,int num){
        int sRow = row/3 * 3;
        int sCol = col/3 * 3;
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(array[i][j] == num)
                    return false;
            }
        }
        return true;
    }
    boolean checkRow(int[][] array,int row,int num){
        for(int i=0;i<array[row].length;i++){
            if(array[row][i] == num)
                return false;
        }
        return true;
    }
    boolean checkCol(int[][] array,int col,int num){
        for(int i=0;i<array.length;i++){
            if(array[i][col] == num)
                return false;
        }
        return true;
    }
}
