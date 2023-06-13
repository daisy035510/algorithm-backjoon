package backjoon.algo.fc.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        input();
        pro();

        Arrays.stream(dist)
                .forEach(System.out::println);
    }
    static int N, M, S;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    public static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.nextInt();
        edges = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= N; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edges[from].add(new Edge(to, weight));
        }
    }

    public static void pro() {

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Info(S, 0));
        dist[S] = 0;

        while(!pq.isEmpty()) {

            Info info = pq.poll();

            // 검증을 해야함
            if(dist[info.idx] != info.dist) continue;

            for(Edge e : edges[info.idx]) {

                if(dist[info.idx] + e.weight > dist[e.to]) continue;

                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
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
