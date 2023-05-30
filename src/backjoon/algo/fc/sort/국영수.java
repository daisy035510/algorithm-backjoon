package backjoon.algo.fc.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수 {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;

    static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {

            String input = sc.nextLine();
            String[] arr = input.split(" ");

            Person person = new Person();
            person.setName(arr[0]);
            person.setKorean(Integer.valueOf(arr[1]));
            person.setEnglish(Integer.valueOf(arr[2]));
            person.setMath(Integer.valueOf(arr[3]));

            personList.add(person);
        }
    }

    static void pro() {
        // interface
       /* personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {

                boolean bKorean     = p1.sameKoreanScore(p2);   // 국어점수
                boolean bEnglish    = p1.sameEnglishScore(p2);  // 영어점수
                boolean bMath       = p1.sameMathScore(p2);     // 수학점수

                // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                if(bKorean && bEnglish && bMath) {
                    // compareToIgnorecase()
                     return p1.name.compareTo(p2.name);
                // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                } else if(bKorean && bEnglish) {
                    return p2.math - p1.math;
                // 국어 점수가 같으면 영어 점수가 증가하는 순서로
                } else if(bKorean) {
                    return p1.english - p2.english;
                }

                // 국어 점수가 감소하는 순서로
                return p2.korean - p1.korean;
            }
        });*/

        // 람다식
        /*personList.sort((p1, p2) -> {

            boolean bKorean     = p1.sameKoreanScore(p2);   // 국어점수
            boolean bEnglish    = p1.sameEnglishScore(p2);  // 영어점수
            boolean bMath       = p1.sameMathScore(p2);     // 수학점수

            // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
            if(bKorean && bEnglish && bMath) {
                // compareToIgnorecase()
                return p1.name.compareTo(p2.name);
                // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            } else if(bKorean && bEnglish) {
                return p2.math - p1.math;
                // 국어 점수가 같으면 영어 점수가 증가하는 순서로
            } else if(bKorean) {
                return p1.english - p2.english;
            }

            // 국어 점수가 감소하는 순서로
            return p2.korean - p1.korean;
        });*/

        // 스트림
        personList.stream()
                .sorted((p1, p2) -> {

                    boolean bKorean = p1.sameKoreanScore(p2);   // 국어점수
                    boolean bEnglish = p1.sameEnglishScore(p2);  // 영어점수
                    boolean bMath = p1.sameMathScore(p2);     // 수학점수

                    // 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                    if (bKorean && bEnglish && bMath) {
                        // compareToIgnorecase()
                        return p1.name.compareTo(p2.name);
                        // 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                    } else if (bKorean && bEnglish) {
                        return p2.math - p1.math;
                        // 국어 점수가 같으면 영어 점수가 증가하는 순서로
                    } else if (bKorean) {
                        return p1.english - p2.english;
                    }

                    // 국어 점수가 감소하는 순서로
                    return p2.korean - p1.korean;
                })
                .forEach(p -> System.out.println(p.name));

//        personList.stream()
//                .forEach(p -> System.out.println(p.name));
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

    static class Person {

        String name;
        int korean;
        int english;
        int math;

        public void setName(String name) {
            this.name = name;
        }

        public void setKorean(int korean) {
            this.korean = korean;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        public void setMath(int math) {
            this.math = math;
        }

        // 국어점수가 같다면
        public boolean sameKoreanScore(Person p) {

            if(this.korean == p.korean)
                return true;
            else
                return false;
        }

        // 영어점수가 같다면
        public boolean sameEnglishScore(Person p) {

            if(this.english == p.english)
                return true;
            else
                return false;
        }

        // 수학점수가 같다면
        public boolean sameMathScore(Person p) {

            if(this.math == p.math)
                return true;
            else
                return false;
        }

    }
}


