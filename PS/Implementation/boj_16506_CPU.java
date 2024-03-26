package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_16506_CPU {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static HashMap<String,String> map;
  public static void main(String[] args) throws IOException {
    init();
    map=new HashMap<>();
    set();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    for(int i = 0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      String opcode = map.get(st.nextToken());
      int rD = Integer.parseInt(st.nextToken());
      int rA = Integer.parseInt(st.nextToken());
      int rB = Integer.parseInt(st.nextToken());
      if(opcode.charAt(4)=='0'){
        bw.write(opcode+"0"+getBinary(rD,3)+getBinary(rA,3)+getBinary(rB,3)+"0\n");
      }else if(opcode.charAt(4)=='1'){
        bw.write(opcode+"0"+getBinary(rD,3)+getBinary(rA,3)+getBinary(rB,4)+"\n");

      }
    }
    close();
  }

  public static String getBinary(int n,int t ){
    String s = "";
    for(int i = 0; i<t; i++){
      s = n%2+ s;
      n=n/2;
    }
    return s;
  }

  public static void set(){
    map.put("ADD","00000");
    map.put("ADDC","00001");
    map.put("SUB","00010");
    map.put("SUBC","00011");
    map.put("MOV","00100");
    map.put("MOVC","00101");
    map.put("AND","00110");
    map.put("ANDC","00111");
    map.put("OR","01000");
    map.put("ORC","01001");
    map.put("NOT","01010");
    map.put("MULT","01100");
    map.put("MULTC","01101");
    map.put("LSFTL","01110");
    map.put("LSFTLC","01111");
    map.put("LSFTR","10000");
    map.put("LSFTRC","10001");
    map.put("ASFTR","10010");
    map.put("ASFTRC","10011");
    map.put("RL","10100");
    map.put("RLC","10101");
    map.put("RR","10110");
    map.put("RRC","10111");
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
