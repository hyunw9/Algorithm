package prgmrs.kakao;
import java.util.*;

public class 주차요금계산_2022 {

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int perMin = fees[2];
        int perPrice = fees[3];
        
        Map<String, Integer> map = new TreeMap<>();
        HashMap<String, String> diff = new HashMap<>();
        
        for(int i = 0 ; i < records.length; i++){
            String[] input = records[i].split(" ");
            if(input[2].equals("IN")){
                diff.put(input[1],input[0]);
            }else if(input[2].equals("OUT")){
                int min = calculate(diff.get(input[1]),input[0]);
                map.put(input[1],map.getOrDefault(input[1],0)+min);
                diff.remove(input[1]);
                // System.out.println(min);
            }
            // System.out.println(diff);
        }
        if(!diff.isEmpty()){
            for(String k : diff.keySet()){
                int min = calculate(diff.get(k),"23:59");
                map.put(k,map.getOrDefault(k,0)+min);
            }
        }
        // map 에 가격이 저장되어있음. 
        ArrayList<Integer> ans = new ArrayList<>();
        for(String k : map.keySet()){
            int min = map.get(k);
            int fee = 0;
            if(min <= defaultTime){
                fee = defaultFee;
            }else {
                fee+=defaultFee;
                min-=defaultTime;
                if(min%perMin>0){
                    min = min/perMin + 1;
                } else{
                    min = min/perMin;
                }
                
                fee+= (min*perPrice);
            }
            ans.add(fee);
        }
        // System.out.println(map);
        
        
        // "차번호 : 시간"
        // IN 이면 diff에 시간 기록
        // out 이면 diff값과 계산해서 Map 에 추가. 
            //만약 출차가 없다면 (0이라면) 23:59 에 나간것으로 간주. 
        // 번호 작은순으로 주차요금 보여주기 
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    public static int calculate(String in ,String out){
        String []i = in.split(":");
        int ih = Integer.parseInt(i[0]);
        int im = Integer.parseInt(i[1]);
        
        String []o = out.split(":");
        
        int oh = Integer.parseInt(o[0]);
        int om = Integer.parseInt(o[1]);
        
        int min = om-im;
        int hr = oh-ih;
        if(min <0){
            min+=60;
            hr-=1;
        }
        // System.out.println(Arrays.toString(i));
        // System.out.println(Arrays.toString(o));
        // System.out.println("im: "+ im + " om : "+ om+ " min : "+ min + " hr : " + hr);
        return hr*60 + min;
        //-20 + 60 = 
        // 1020 2300 == 1250
        //2300 - 2259;
    }
}
}
