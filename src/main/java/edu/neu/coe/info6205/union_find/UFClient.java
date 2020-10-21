package edu.neu.coe.info6205.union_find;
import java.util.Random;


public class UFClient {
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
     * @param args
     */
    public static void main(String args[]){
            int n = Integer.parseInt(args[0]);
            System.out.println(count(n)+" connections generated");
        }

}
