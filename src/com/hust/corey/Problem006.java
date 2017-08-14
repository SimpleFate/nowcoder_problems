package com.hust.corey;

import java.util.Scanner;

/**
 * Created by HUST Corey on 2017/8/12.
 */
public class Problem006 implements Problem {

    void solution(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] array = str.toCharArray();
        int[] count = new int[2];
        for(char ch : array)
            count[0] = ch=='B'?count[0]+1:count[0];
        count[1] = array.length - count[0];
        char[] prefix = {'B','G'};
        int min = 0;
        for(int i=0;i<2;i++){
            char[] copy = new char[array.length];
            System.arraycopy(array,0,copy,0,array.length);
            int result = 0;
            for(int j=0;j<count[i];j++){
                if(copy[j] == prefix[i])
                    continue;
                int repPos = findNext(copy,j,prefix[i]);
                if(repPos != -1)
                    result += swap(copy,j,repPos);
            }
            if(i==0 || result < min)
                min = result;
        }
        System.out.println(min);

    }
    int findNext(char[] array,int start,char target){
        for(int i=start;i<array.length;i++){
            if(array[i] == target)
                return i;
        }
        return -1;
    }
    int swap(char[] array,int index1,int index2){
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return index2 - index1;
    }

    @Override
    public void runSolution(Object... objects) {
        solution();
    }

}
