package backjoon.algo.fc.exhaustivesearch;

import java.io.*;
import java.util.StringTokenizer;

public class N과M_2 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    public static void rec_func(int n) {

        if(n == (M + 1)) {

//            int[] copyArray = Arrays.stream(selected)
//                                    .toArray();
//
//            // 오름차순 정렬
//            Arrays.sort(copyArray);
//
//            // 오름차순 비교
//            for(int i = 1; i <= M; i++){
//                if(copyArray[i] != selected[i]) {
//                    return;
//                }
//            }

            // int[] -> Integer boxing
            // arrays -> list
//            List<Integer> list = Arrays.stream(selected)
//                                .boxed()
//                                .collect(Collectors.toList());
//
//            // 중복 제거
//            Set<Integer> set = new LinkedHashSet<>(list);
//            if(set.size() != list.size()) {
//                return;
//            }

            for(int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {

            int start = selected[n - 1];

            for(int k = (start + 1); k <= N; k++){
                selected[n] = k;
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