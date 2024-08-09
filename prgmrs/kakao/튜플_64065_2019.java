package prgmrs.kakao;

public class 튜플_64065_2019 {
    import java.util.*;

class Solution {
    public int[] solution(String s) {
        

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((o1,o2)->o1.size()-o2.size());
        
        String [] str = s.split("\\},\\{");
        // System.out.println(Arrays.toString(str));
        str[0] = str[0].replaceAll("[{}]","");
        str[str.length-1] =str[str.length-1].replaceAll("[{}]",""); 
        for(String v: str){
            ArrayList<Integer> list = new ArrayList<>();
            String[] splitted  = v.split(",");
            for(String val : splitted){
                list.add(Integer.parseInt(val));
            }
            pq.add(list);
        }

        int[] answer = new int[pq.size()];
        Set<Integer> set = new HashSet<>();
        
        while(!pq.isEmpty()){
            ArrayList<Integer> li = pq.poll();
            
            for(int v: li){
                if(!set.contains(v)){
                    set.add(v);
                    answer[li.size()-1] = v;
                    
                }
            }
        }
        return answer;
    }
}
}
