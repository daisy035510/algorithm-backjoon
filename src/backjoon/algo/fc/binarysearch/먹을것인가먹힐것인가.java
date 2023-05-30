package backjoon.algo.fc.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;
    public static void main(String[] args) {


        input();
        pro();

    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N + 1];
        B = new int[M + 1];

        for(int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = 1; i <= M; i++) {
            B[i] = sc.nextInt();
        }
    }

    public static void pro() {

       // B를 정렬
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {

        int res = L - 1;
        while(L <= R) {

            int mid = (L + R) / 2;
            if(A[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
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
