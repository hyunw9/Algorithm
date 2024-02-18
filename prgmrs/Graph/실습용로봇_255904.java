package prgmrs.Graph;

public class 실습용로봇_255904 {


    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public int[] solution(String command) {
      int[] answer = new int[2];
      answer[0] = 0;
      answer[1]=0;
      int idx= 0 ;

      int x=dx[idx];
      int y=dy[idx];
      for(int i = 0; i<command.length(); i++){
        char now = command.charAt(i);

        //System.out.println(Arrays.toString(answer));
        if(now == 'R'){
          idx++;
          if(idx ==4) idx =0;
          x = dx[idx];
          y = dy[idx];
        }else if(now=='L'){
          idx--;
          if(idx==-1) idx=3;
          x= dx[idx];
          y = dy[idx];
        }else if(now=='G'){
          answer[0]+= x;
          answer[1]-= y;

        }else if(now == 'B'){
          answer[0] -= x;
          answer[1]+= y;

        }

      }

      return answer;
    }

}
