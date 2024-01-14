package prgmrs.Hash;
import java.util.*;
public class 베스트앨범_42579 {

  class Solution {
    private static class Song{
      int times;
      int idx;
      public Song(int times, int idx){
        this.times = times;
        this.idx = idx;
      }
    }
    private static class Stat{
      String genre;
      int cnt;
      public Stat(String genre,int cnt){
        this.genre = genre;
        this.cnt = cnt;
      }
    }
    public List<Integer> solution(String[] genres, int[] plays) {

      TreeMap<String,Integer> map = new TreeMap<>();
      PriorityQueue<Song> pq = new PriorityQueue<>((o1,o2)->  o2.times - o1.times);
      List<Stat> arr = new ArrayList<>();

      for(int i = 0; i< genres.length; i++){
        if(!map.containsKey(genres[i])) map.put(genres[i],plays[i]);
        else{
          map.put(genres[i],map.get(genres[i])+plays[i]);
        }
      }
      for(String key :map.keySet()){
        arr.add(new Stat(key,map.get(key)));
      }

      Collections.sort(arr,(o1,o2)->o2.cnt-o1.cnt);

      List<Integer> answer = new ArrayList<>();
      int idx = 0;
      for(int i = 0 ; i<arr.size();i++){
        Stat stat = arr.get(i);
        //System.out.println(stat.genre);

        for(int j=0;j<genres.length;j++){
          if(genres[j].equals(stat.genre)){
            pq.add(new Song(plays[j],j));
          }
        }
        int count =0;
        while(!pq.isEmpty()){
          Song now = pq.poll();
          answer.add(now.idx);
          count ++;
          if(count==2) pq.clear();
        }

      }
      return answer;
    }
  }

}
