package backjoon.algo.fc.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int S, E;
    static ArrayList<Edge>[] edges;
    static boolean[] visited;
    static int[] dist;

    public static class Edge{
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class Info {
        int idx, dist;
        Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
//        System.out.println(dist[E]);
        Arrays.stream(dist)
                .forEach(System.out::print);
    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();
        edges = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            edges[from].add(new Edge(to, cost));
        }

        S = sc.nextInt();
        E = sc.nextInt();
    }

    public static void pro() {

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        for(int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Info(S, 0));
        dist[S] = 0;

        while(!pq.isEmpty()) {

            Info info = pq.poll();

            // 정보가 다르면 무시할 값이기 때문에 스킵한다
            if(dist[info.idx] != info.dist) {
                System.out.println("dist[info.idx]  : " + dist[info.idx]);
                System.out.println("info.idx: " + info.idx + ",  info.dist  : " + info.dist);
                continue;
            }

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보들을갱신해준다
            for(Edge e : edges[info.idx]) {

                if(dist[info.idx] + e.cost >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다
                dist[e.to] = dist[info.idx] + e.cost;
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
