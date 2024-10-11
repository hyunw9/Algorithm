package leetCode.ArraysHashing;

import java.util.HashMap;

public class valid_sudoku {
      public boolean isValidSudoku(char[][] board) {
        // 가로 세로를 돌면서 두번 존재한다면, 그건 false인것 
        //가로 반복
        for(int i = 0 ; i < 9 ; i++){
            HashMap<Character, Integer> map = new HashMap<>();

            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j]!='.'){
                    map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);
    
                    if(map.get(board[i][j])>1) return false;
                }

            }

            map = new HashMap<>();

            for(int j = 0 ; j < 9 ; j++){
                if(board[j][i]!='.'){
                    map.put(board[j][i],map.getOrDefault(board[j][i],0)+1);

                    if(map.get(board[j][i])>1) return false;
                }
            }
        }
                                        
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9 ; j+=3){
                System.out.println(i +" "+ j);
                if(!check(board,i,j)) return false;
            }
        }
        // check(board,6,6);

        //세로 반복

        return true;
    }

    public static boolean check(char [][] board,int y, int x){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = y; i < y +3 ; i++){
            for(int j = x ;j <x+3; j++){
                if(board[i][j]!='.'){
                    map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);

                    if(map.get(board[i][j])>1) return false;
                }
            }
        }
        return true;
    }
}
