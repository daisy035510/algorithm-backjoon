package algo.fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 단지번호붙이기 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;
    static int[][] adj;
    static ArrayList<Integer> group;
    static String[] a;

    public static void main(String[] args) {

        input();
        pro();

    }
    public static void input() {
        N = scan.nextInt();
        a = new String[N];

        for(int i = 0; i < N; i++) {
            a[i] = scan.nextLine();
        }

        visit = new boolean[N][N];
    }

    public static void pro() {

        group = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j] == false && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        sb.append(group.size()).append('\n');
        for(int n : group) {
            sb.append(n).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for(int k = 0; k < dir.length; k++) {
            int nx = dir[k][0] + x;
            int ny = dir[k][1] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 지도를 벗어남
            if(a[nx].charAt(ny) == '0') continue; // 0 이면 방문할 필요 없음
            if(visit[nx][ny]) continue; // 방문했던 곳이면 방문할 필요 없음

            dfs(nx, ny);
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
