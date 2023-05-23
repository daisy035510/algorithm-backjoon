package algo.fc.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {
        }

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) {
        input();
        pro();
    }
    static void input() {
        N = sc.nextInt(); // edge 의 갯수
        M = sc.nextInt(); // 버스의 갯수
        dist = new int[N + 1];
        edges = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }

        start = sc.nextInt();
        end = sc.nextInt();
    }

    static void pro() {
        dijkstra(1);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {

        // 모든 정점까지에 대한 거리를 무한대로 초기화해준다
        for(int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙 생성
        PriorityQueue<Info> pq  = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        // 시작점에 대한 거리 정보를 갱신해준다
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Info info = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미 없는 낡은 정보이므로 폐기한다
            if(dist[info.idx] != info.dist) continue;

            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신한다.
            for(Edge e : edges[info.idx]) {

                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신한고 pq에 기록해준다.
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
