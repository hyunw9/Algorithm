package leetCode.TwoPointers;

public class trapping_rain_water {
        
    public int trap(int[] height) {
        int l = 0;
        int r = 1;
        int sum=0;
        while( l <= r && r < height.length){

            if(height[r]>height[r-1]){
                int key = height[r-1];
                int idx = r-1;
                int maxVal =0;
                int maxidx  =0;
                while(--idx >= 0){
                    // idx -=1;
                    if(height[idx]> maxVal){

                            maxVal = Math.max(maxVal,height[idx]);
                            maxidx = idx;

                    }
                    // idx-=1;
                    // if(height[idx] > key) break;
                    
                }
                idx = maxidx;
                // System.out.println("found idx : "+maxidx);
                // System.out.println("found maxVal : "+maxVal);
                int min = Math.min(maxVal,height[r]);

                for(int i = idx; i < r; i++){
                    if(height[i]< min){
                        sum += min-height[i];
                        // System.out.println("add num : " +(min-height[i]));
                        
                        height[i] = min;
                    }
                }
                // System.out.println(Arrays.toString(height));


            }
            // System.out.println("l : "+ l + " r : "+ r );
            r+=1;

        }
        return sum;
    }
    
}
