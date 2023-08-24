package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.StringTokenizer;

public class 부분수열의합 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] arr;
    static int CNT = 0;
    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        
        // 진부분집합
        if (S == 0){
            CNT--;
        }

        System.out.println(CNT);
    }

    public static void input(){

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void rec_func(int k, int value) {

        if(k == (N + 1)) {
            if(value == S) CNT++;
        } else {
            // include
            rec_func(k + 1, value + arr[k]);
            // not include
            rec_func(k + 1, value);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
