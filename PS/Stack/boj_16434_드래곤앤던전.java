package PS.Stack;

import java.io.*;
import java.util.*;
public class boj_16434_드래곤앤던전 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int initAttack = Integer.parseInt(st.nextToken());
        ArrayList<int[]> roomInfo = new ArrayList<>();
        long minHp=1;
        long maxHp=(long)1e18;
        for(int i  = 0 ; i< n ; i ++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            roomInfo.add(new int[] {t,a,h});
        }
        long answer =0 ;
        while(minHp<=maxHp){
            long mid = (minHp+maxHp)/2;

            if(isSurvival(mid,initAttack,roomInfo)){
                answer = mid ; 
                maxHp = mid -1;
            }else{
                minHp = mid +1; 
            }
        }
        System.out.println(answer);
        close();
    }

    public static boolean isSurvival(long hp,long attack, ArrayList<int[]> rooms){

        long currentHp = hp;
        long currentAttack = attack;
        for(int[] room : rooms){
            int t = room[0];
            int a = room[1];
            int h = room[2];

            if(t == 1){
                long turnsToKillMonster = (h + currentAttack -1) / currentAttack;
                long turnsToDie = (currentHp+ a -1) / a;

                if(turnsToDie < turnsToKillMonster){
                    return false;
                }else{
                    currentHp -= (turnsToKillMonster -1) * a;
                }
            }else{
                currentAttack +=a;
                currentHp = Math.min(hp, currentHp+h);

            }
            
        }
        return currentHp>0;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
