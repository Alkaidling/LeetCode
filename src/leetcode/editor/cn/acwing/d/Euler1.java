package leetcode.editor.cn.acwing.d;

import java.io.*;

class Euler1 {
    static int N = 1000010;
    static int[] phi = new int[N]; //用于保存每个数字的欧拉函数
    static int[] primes = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt;

    static void get_phis(int n){
        phi[1] = 1; //1的欧拉函数为1
        for(int i=2; i<=n; i++){
            if(!st[i]){
                primes[cnt++] = i;
                phi[i] = i-1;
            }
            for(int j=0; primes[j]<=n/i; j++){
                st[primes[j]*i] = true;
                phi[primes[j]*i] = phi[i] * (primes[j]-1);
                if(i%primes[j]==0){
                    phi[primes[j]*i] = phi[i] * primes[j];
                    break;
                }
            }
        }
    }


    public static void main(String[]args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        get_phis(n);

        long res = 0;
        for(int i=1; i<=n; i++){
            res+=phi[i];
        }

        System.out.println(res);
    }
}