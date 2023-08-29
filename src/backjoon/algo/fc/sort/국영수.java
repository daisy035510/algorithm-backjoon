package backjoon.algo.fc.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input(){
         N = sc.nextInt();

         for(int i = 0; i < N; i++) {

             String str = sc.nextLine();
             String[] arr = str.split(" ");
             studentList.add(new Student(arr[0], Integer.valueOf(arr[1]), Integer.valueOf(arr[2]),Integer.valueOf(arr[3])));
         }
    }

    public static void pro() {

        Collections.sort(studentList);

        studentList.forEach(s-> {
            System.out.print(s.name);
            System.out.println();
        });
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

    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        @Override
        public int compareTo(Student other) {
            if(this.korean != other.korean) return Integer.compare(other.korean, this.korean);
            if(this.english != other.english) return Integer.compare(english, other.english);
            if(this.math != other.math) return Integer.compare(other.math, this.math);
            return name.compareTo(other.name);
        }
    }
}
