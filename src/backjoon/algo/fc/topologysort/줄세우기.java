package backjoon.algo.fc.topologysort;

import java.io.*;
import java.util.*;

public class 줄세우기 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) {
        input();
        pro();
    }
    public static void input(){

         N = sc.nextInt();
         M = sc.nextInt();
         adj = new ArrayList[N+1];
         indeg = new int[N+1];

         for(int i = 0; i <= N; i++) {
             adj[i] = new ArrayList<>();
         }

         for(int i = 1; i <= M; i++) {

             int x = sc.nextInt();
             int y = sc.nextInt();

             adj[x].add(y);
             indeg[y]++;
         }

       // System.out.println(Arrays.deepToString(adj));
       // System.out.println(Arrays.toString(indeg));
    }

    public static void pro() {

        Deque<Integer> dequeue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(indeg[i] == 0) {
                dequeue.add(i);
            }
        }


        while(!dequeue.isEmpty()) {

            int n = dequeue.poll();

            for(int y : adj[n]) {
                indeg[y]--;
                if(indeg[y] == 0){
                    dequeue.add(y);
                }
            }
            System.out.println(n);
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
