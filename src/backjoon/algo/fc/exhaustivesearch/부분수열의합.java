package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class 부분수열의합 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] arr;
    static int RLST = 0;
    public static void main(String[] args) {
        input();
        pro();
        System.out.println("RLST : " + RLST);
    }

    public static void input(){

        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void pro() {

        // 1. 정렬
        Arrays.sort(arr);

        // 2. 부분수열 갯수

        int sum = 0;
        int start = 1;

        while(start < N) {
            for(int i = start; i < N; i++) {
                sum += arr[i];
                if(sum == S) {
                    RLST++;
                    break;
                }
            }
            
            // 초기화
            sum = 0;
            start++;
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
