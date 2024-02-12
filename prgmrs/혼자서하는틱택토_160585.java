package prgmrs;

public class 혼자서하는틱택토_160585 {

  public int solution(String[] board) {
    int answer = -1;
    int first = 0;
    int second = 0;
    char[][] map = new char[3][3];
    for(int i = 0 ; i < 3;  i++){

      for(int j = 0 ; j < 3 ; j++){
        map[i][j]= board[i].charAt(j);
        if(map[i][j]=='O')first++;
        else if(map[i][j]=='X') second++;
      }
    }

    if(second>first) return 0;
    if(first-second>1) return 0;
    boolean fflag= check(map,'O');
    boolean sflag=check(map,'X');

    //한쪽이 3개 완성시 다른 쪽은 더 만들 수 없음.
    //선공이 세개 다 만들면, 후공은 선공보다 1개 작아야 하고
    //후공이 세개 다 만들면, 선공은 완성되지 않아야 하고 후공과 체크 갯수가 똑같아야 함

    //후공은 선공보다 개수가 많을 수 없음. (이상은 가능 )
    if(fflag&&sflag){
      return 0;
    }else if(fflag){
      if(second+1!=first) return 0;
    }else if(sflag){
      if(fflag) return 0;
      else if(first!=second) return 0;
    }

    return 1;
  }
  public boolean check(char[][] map,char ops){
    for(int i = 0 ; i < 3;i++){
      int cnt=0;
      for(int j = 0 ; j <3; j++){
        if(map[i][j]==ops){
          cnt++;
        }
      }
      if(cnt==3) return true;
      cnt = 0 ;
      for(int j = 0 ; j<3; j++){
        if(map[j][i]==ops){
          cnt++;
        }
      }
      if(cnt==3) return true;

    }
    int cnt = 0;
    for(int i = 0; i < 3;i++){
      if(map[i][i]==ops) cnt++;
    }
    if(cnt==3) return true;
    cnt = 0;
    for(int i = 0; i < 3;i++){
      if(map[i][2-i]==ops) cnt++;
    }
    if(cnt==3) return true;

    return false;

  }

}
