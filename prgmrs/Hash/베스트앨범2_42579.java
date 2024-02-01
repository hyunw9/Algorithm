package prgmrs.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 베스트앨범2_42579 {


  static class Song{
    String genre;
    int no;
    int times;
    int total;
    public Song(String genre, int no, int times, int total){
      this.genre = genre;

      this.no = no;
      this.times = times;
      this.total = total;
    }
  }
  public int[] solution(String[] genres, int[] plays) {
    //total 높은 장르 순,
    //Total 이 같으면, 많이 재생된 노래 먼저 수록
    // 재생 횟수가 같으면 고유번호 낮은 노래 수록
    int[] answer = {};
    HashMap<String, Integer> cnt = new HashMap<>();
    PriorityQueue<Song> q = new PriorityQueue<>((o1,o2)->{
      if(o1.total == o2.total){

        if(o1.times == o2.times ){
          return o1.no - o2.no;
        }
        return o2.times-o1.times;
      }
      return o2.total- o1.total;
    });
    HashMap<String,Integer> map = new HashMap<>();

    for(int i = 0 ; i < genres.length; i++){
      map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
      cnt.put(genres[i],0);
    }
    for(int i = 0;i < genres.length; i++){
      q.add(new Song(genres[i],i,plays[i],map.get(genres[i])));
    }

    ArrayList<Integer> tmp = new ArrayList<>();
    while(!q.isEmpty()){
      Song song = q.poll();
      // System.out.println("genre: "+ song.genre+" plays: "+ song.times+" no: "+ song.no+ " total: "+ song.total);

      if(cnt.get(song.genre)<2){
        tmp.add(song.no);
        cnt.put(song.genre,cnt.get(song.genre)+1);
      }
    }
    int[] ans = new int[tmp.size()];
    for(int i = 0; i <ans.length; i++){
      ans[i] = tmp.get(i);
    }

    return ans;
  }

}
