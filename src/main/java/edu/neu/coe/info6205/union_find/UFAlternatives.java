package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFAlternatives {
    public static int count(int n) {
        WQUPC uf = new WQUPC(n);
        Random rand1 = new Random();
        int connection = 0;
        loop:while(uf.count()>1){
            int p = rand1.nextInt(n-1);
            int q = rand1.nextInt(n-1);
            if(!uf.connected(p,q)){
                uf.union(p, q);
                System.out.println("("+p+","+q+")");
            }
            else{
                System.out.println("("+p+","+q+")");
                break loop;
            }
            connection++;
        }
        return connection;
    }

    /**
     * Getting input from users to determine the number of sites
     * and print out the connections generated using count() method
     * Benchmark to see the execution time
     * @param args
     */
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        long startTime = System.currentTimeMillis();
        System.out.println(count(n)+" connections generated");
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}
