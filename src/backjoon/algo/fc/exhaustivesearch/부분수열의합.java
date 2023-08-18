package backjoon.algo.fc.exhaustivesearch;

import backjoon.algo.fc.cmm.Format;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class 부분수열의합 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] arr;
    static int rslt = 0;
    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){
        N = sc.nextInt();
        S = sc.nextInt();

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void pro() {

        // 정렬
        List<Integer> list = arr.;

        int sum = 0;
        int cnt = 2;
        
        for(int i = 1; i < N; i++) {

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
