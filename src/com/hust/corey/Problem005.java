package com.hust.corey;

import java.util.Scanner;

/**
 * Created by HUST Corey on 2017/8/12.
 */
public class Problem005 implements Problem {
    class Coord{
        int x;
        int y;
        public Coord(int x,int y){
            this.x = x;
            this.y = y;
        }
        public Coord(){

        }
    }
    void solution(){
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        Coord[] taxis = new Coord[n];
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            taxis[i] = new Coord(x[i],y[i]);
        }
        Coord firm = new Coord();
        firm.x = in.nextInt();
        firm.y = in.nextInt();
        int walkcost = in.nextInt();
        int taxicost = in.nextInt();
        Coord origin = new Coord(0,0);
        int minCost = 0;
        for(int i=0;i<n;i++){
            int cost1 = getSteps(origin,taxis[i]) * walkcost;
            int cost2 = getSteps(taxis[i],firm) * taxicost;
            if(i == 0 || cost1+cost2<minCost){
                minCost = cost1+cost2;
            }
        }
        int walk = getSteps(origin,firm)*walkcost;
        minCost = minCost<=walk?minCost:walk;
        System.out.println(minCost);
    }
    int getSteps(Coord p1,Coord p2){
        int x  = p1.x - p2.x;
        x = x>=0?x:-x;
        int y = p1.y - p2.y;
        y = y>=0?y:-y;
        return x+y;
    }
    @Override
    public void runSolution(Object... objects) {
        solution();
    }
}
