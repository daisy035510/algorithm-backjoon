package backjoon.algo.fc.sort;

import java.io.*;
import java.util.*;

public class 단어정렬 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Str[] arr;
    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){

        N = sc.nextInt();
        arr = new Str[N];

        for(int i = 0 ; i < N; i++) {
            arr[i] = new Str(sc.nextLine());
        }
    }

    public static void pro() {

        Arrays.sort(arr);
        List<Str> tempList = Arrays.asList(arr);

        List<String> list = new ArrayList<>();
        for(Str s: tempList) {
            list.add(s.getStr());
        }

        Set<String> set = new LinkedHashSet<>(list);
        set.stream()
                .forEach(System.out::println);

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

    static class Str implements Comparable<Str> {
        String str;

        Str(String s) {
            this.str = s;
        }

        @Override
        public int compareTo(Str o) {
            // 오름차순

            int meLen = this.str.length();
            int otherLen = o.str.length();

            if (meLen != otherLen) {
                return Integer.compare(meLen, otherLen);
            } else {
                return this.str.compareTo(o.str);
            }
        }

        public String getStr() {
            return this.str;
        }
    }

}
