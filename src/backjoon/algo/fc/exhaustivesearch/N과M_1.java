package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과M_1 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static int N, M;
    public static Integer[] selected;
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    public static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new Integer[M + 1];
    }

    public static void rec_func(int n) {

        if(n == (M + 1)) {

            int aLen = selected.length;
            Set<Integer> set = new LinkedHashSet<>(Arrays.asList(selected));
            int bLen = set.size();

            if(aLen != bLen)
                return;

            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');

        } else {
            for(int i = 1; i <= N; i++) {
                selected[n] = i;
                rec_func(n + 1);
                selected[n] = 0;
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
