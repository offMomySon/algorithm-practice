import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs;
    private static int N, S, COUNT;
    private static int[] nums;

    private static void input(){
        fs = new FastScanner();

        N = fs.nextInt();
        S = fs.nextInt();
        nums = new int[N+1];
        for (int i = 1; i <=N; i++) nums[i] = fs.nextInt();
    }


    static void rec_func(int k, int cur_value){
        if(N+1 == k){
            if(S == cur_value)
                COUNT++;
            return;
        }

        rec_func(k+1, cur_value+ nums[k]);
        rec_func(k+1, cur_value);
    }


    public static void main(String[] args) {
        input();

        rec_func(1,0);

        if(S == 0)
            COUNT--;

        System.out.println(COUNT);
    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while((st == null || !st.hasMoreTokens())){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String readLine(){
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
