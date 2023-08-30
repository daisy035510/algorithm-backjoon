package backjoon.algo.fc.sort;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 파일정리 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] arr;

    public static void main(String[] args) {

        input();
        pro();

        System.out.println(sb.toString());
    }

    public static void input(){

        N = sc.nextInt();
        arr = new String[N];

        for(int i = 0; i < N; i++) {

            String[] temp  = sc.nextLine().split("\\.");
            arr[i] = temp[1]; // 확장자
        }

    }

    public static void pro() {

        Arrays.sort(arr);

        Map<String, Integer> map = new LinkedHashMap<>();
        for(String s: arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

//        for(String s: map.keySet()) {
//            sb.append(s).append(" ").append(map.get(s)).append("\n");
//        }

        map.keySet()
                .forEach(s -> sb.append(s).append(" ").append(map.get(s)).append("\n"));
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
