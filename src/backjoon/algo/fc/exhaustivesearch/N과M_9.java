package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.*;

public class N과M_9 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums, used;
    static int[] selected;

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        rec_func(1);

//        list =  List.of(sb.toString().split("\n"));
////        list.forEach(System.out::println);
//
//        // 중복 제거
//        Set<String> set = new LinkedHashSet<>(list);
//        for(String s : set) {
//            System.out.println(s);
//        }

        System.out.println(sb.toString());
    }

    public static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N + 1];
        used = new int[N + 1];
        selected = new int[M + 1];

        for(int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums, 1, N + 1);
    }

    public static void rec_func(int k) {

        if(k == (M + 1)) {

            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
//            list.add(sb.toString());

        } else {

            int last_cand = 0;

            for(int cand = 1; cand <= N; cand++) {

                if(used[cand] == 1) continue;
                if(nums[cand] == last_cand) continue;

                selected[k] = nums[cand];
                used[cand] = 1;
                last_cand = nums[cand];

                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;
                last_cand = 0;
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
