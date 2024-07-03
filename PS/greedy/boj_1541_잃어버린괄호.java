package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class boj_1541_잃어버린괄호 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static class Num {
        char op ;
        int num;

        public Num(char op,int num){
            this.op = op;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        String line = br.readLine();
        Num[] arr = new Num[line.length()];
        ArrayList<Num> list = new ArrayList<>();
        char op ='+';
        for(int i = 0;i< line.length();i++){

            if(i==0 || line.charAt(i)=='+'){
                op = '+';
            }else if(line.charAt(i)=='-'){
                op = '-';
            }
            if(Character.isDigit(line.charAt(i))){
                int j = i;
                String a = "";

                while(j<line.length()&&Character.isDigit(line.charAt(j))){
                    a+=line.charAt(j++);
                }

                list.add(new Num(op,Integer.parseInt(a)));
                i=j;
            }
        }
        int max = 0;
        int total = 0;
        for(int i = 0 ; i < list.size();i++){

            Num now = list.get(i);
            if(now.op == '-'){
                int j = i;
                int sum = 0;
                while(j<list.size()){
                    if(list.get(j).op=='+'){
                        sum -= list.get(j).num;

                    }else{
                        sum += list.get(j).num;
                    }
                    j++;
                    System.out.println(sum);
                }
                if(sum> max){
                    max = sum;
                }
            }else {
                total += now.num;
            }
            System.out.println(max);
        }
        bw.write((total - max)+"");
//        for(int i = 0 ; i < list.size();i++){
//            System.out.println(list.get(i).num);
//        }
        close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
