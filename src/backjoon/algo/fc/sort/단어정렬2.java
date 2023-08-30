package backjoon.algo.fc.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 단어정렬2 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] a;

    static class MyCompartor implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if(s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }

            return s1.compareTo(s2);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){

        N = sc.nextInt();
        a = new String[N];

        for(int i = 0; i < N; i++){
            a[i] = sc.nextLine();
        }
    }

    public static void pro() {

        Arrays.sort(a, new MyCompartor());

        for(int i = 0 ; i < N; i++) {
            if(i == 0 || a[i].compareTo(a[i - 1]) != 0) {
                sb.append(a[i]).append("\n");
            }
        }

        System.out.println(sb.toString());

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
