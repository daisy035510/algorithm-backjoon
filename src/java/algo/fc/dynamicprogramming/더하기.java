package algo.fc.dynamicprogramming;

/**
 * 1, 2, 3 더하기
 */

import java.io.*;
import java.util.StringTokenizer;

class 더하기 {

    static FastReader scan = new FastReader();
    static int[] arr;

    public static void main(String[] args) {

        int n = scan.nextInt();

        // 초기화
        setInput(n);

        // 처리
        int rslt = getResult(n);

        System.out.println(rslt);

    }

    public static void setInput(int n) {
        // 초기화
        arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
    }

    public static int getResult(int n) {

        for(int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
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
