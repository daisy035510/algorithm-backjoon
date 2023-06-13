package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M3 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static int N, M;
    public static int[] selected;

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
    }

    public static void pro() {
        rec_func(1);
        System.out.println(sb.toString());

    }

    public static void rec_func(int k) {

        if(k == (M + 1)) {
//            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(" ");
            sb.append('\n');
        } else {
            for(int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                System.out.print("k: " + k + ", cand : " + cand + ", selected: ");
                Arrays.stream(selected)
                                .forEach(System.out::print);
                System.out.println();
                rec_func(k+1);
                selected[k] = 0;
            }
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
