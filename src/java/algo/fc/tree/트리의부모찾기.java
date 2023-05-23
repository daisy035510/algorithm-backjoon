package algo.fc.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    static ArrayList<Integer>[] adj;
    static int n;

    static int parent[];

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input() {

        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접 리스트 구성하기
        for (int i = 1; i < n; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void pro() {
        // 1 번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        dfs(1, -1);

        // 정답 출력하기
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);

    }

    public static void dfs(int x, int par) {
        System.out.println("x : " + x + ", par : " + par);

        for(int y : adj[x]) {
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
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
