package com.company;

import java.util.*;

public class woody
{
    static int knapsack(int X,int Y,int distanceTravelledX, int distanceTravelledY,int distanceX[],int distanceY[],int hour[],int n,int i)
    {
        if(i == n)
        {
            if(distanceTravelledX < X || distanceTravelledY < Y)
            {
                return 1000000000;
            }
            else
            {
                return 0;
            }
        }

        return Math.min(knapsack(X,Y,distanceTravelledX,distanceTravelledY,distanceX,distanceY,hour,n,i+1),knapsack(X,Y,distanceTravelledX+distanceX[i],distanceTravelledY+distanceY[i],distanceX,distanceY,hour,n,i+1) + hour[i]);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int X = input.nextInt();
        int Y = input.nextInt();

        int x[] = new int[N];
        int y[] = new int[N];
        int h[] = new int[N];

        for (int i=0;i<N;i++)
        {
            x[i] = input.nextInt();
            y[i] = input.nextInt();
            h[i] = input.nextInt();
        }

        int ans = (knapsack(X,Y,0,0,x,y,h,N,0));

        if(ans == 1000000000)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans);
        }
    }
}
