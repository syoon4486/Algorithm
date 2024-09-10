import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[]arr;

    static class Meeting implements  Comparable<Meeting>{
        int start;
        int end;
        int sub;

        public Meeting(int start,int end){
            this.start = start;
            this.end = end;
            this.sub = end - start;
        }

        @Override
        public int compareTo(Meeting o) {
            if(end!=o.end) return end - o.end;

            return start-o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr= new int[200001];
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//회의 시작시간
            int end = Integer.parseInt(st.nextToken());//회의 끝시간

            pq.offer(new Meeting(start,end));
        }


        int cnt = 0, end = 0;
        while(!pq.isEmpty()){
            Meeting current = pq.poll();// 짧은 미팅시간의 미팅을 꺼내서,
            //배치할 수 있으면 배치한다.
            if(current.start >= end && isEmptyTime(current.start, current.end)){
                fillTime(current.start,current.end);
                cnt++;
                end = current.end;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();


    }

    private static void fillTime(int start, int end) {
        for(int i=start; i<end; i++){
            arr[i] = 1; //회의 진행중 상태로 변경
        }


    }

    private static boolean isEmptyTime(int start, int end) {
        for(int i=start; i<end; i++){
            if(arr[i]==1) return false;
        }
        return true;
    }

}