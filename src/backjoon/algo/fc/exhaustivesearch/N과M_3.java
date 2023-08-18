package backjoon.algo.fc.exhaustivesearch;

import backjoon.algo.fc.cmm.Format;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_3 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
    }

    public static void pro() {

        StringBuilder sb = new StringBuilder();

        for(int i = 1;  i <= N; i++) {
            sb.append(i)
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
