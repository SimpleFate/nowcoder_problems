package com.hust.corey;

import java.util.*;

/**
 * Created by Administrator on 2017/8/14.
 */

/**
 * name:
 * subsets
 * url:
 * https://www.nowcoder.com/practice/c333d551eb6243e0b4d92e37a06fbfc9?tpId=46&tqId=29100&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * extra:
 *
 */
public class Problem007 implements Problem {

    @Override
    public void runSolution(Object... objects) {

        ArrayList<ArrayList<Integer>> res = solution(new int[]{1, 2, 3});

        for (ArrayList<Integer> array : res) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer>> solution(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int length = S.length;
        Arrays.sort(S);
        result.add(new ArrayList<Integer>() {});
        for (int len = 1; len <= length; len++) {
            int start = result.size() - 1;
            for (int i = start; i >= 0 && result.get(i).size() == len - 1; i--) {
                ArrayList<Integer> tmp = result.get(i);
                int size = tmp.size();
                ArrayList<ArrayList<Integer>> tmpRes = new ArrayList<>();
                if (size != 0) {
                    for (int j = length - 1; S[j] > tmp.get(size - 1); j--) {
                        int num = S[j];
                        ArrayList<Integer> added = new ArrayList<>(tmp);
                        added.add(num);
                        tmpRes.add(added);
                    }
                } else {
                    for (int j = 0; j < length; j++) {
                        ArrayList<Integer> added = new ArrayList<>();
                        added.add(S[j]);
                        tmpRes.add(added);
                    }
                }
                result.addAll(tmpRes);
            }
        }
        Collections.sort(result,new MyComp());
        return result;
    }
    class MyComp implements Comparator<ArrayList<Integer>>{
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if(o1.size() > o2.size())
                return 1;
            else if(o1.size() < o2.size())
                return -1;
            else {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) > o2.get(i))
                        return 1;
                    else if (o1.get(i) < o2.get(i))
                        return -1;
                    else
                        continue;
                }
                return 0;
            }
        }
    }
}