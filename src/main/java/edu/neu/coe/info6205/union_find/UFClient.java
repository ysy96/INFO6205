package edu.neu.coe.info6205.union_find;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.TimeLogger;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;



public class UFClient{


    /**
     * generate random pairs from 0 to n-1
     * determine if they are connected using connected()
     * if not connected using union() method
     * @param n
     * @return
     */
    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random rand = new Random();
        int connection = 0;
        loop:while(uf.components()>1){
            int p = rand.nextInt(n-1);
            int q = rand.nextInt(n-1);
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
     * Benchmark the execution time
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
