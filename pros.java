public class pros {
    public static int recursion(int rec){
        if (rec == 0){
            return 0;
        }
        return rec * recursion(rec-1);
    }
    public void main(String []args) {
        int n = 4;
        int[] answer = {};

        System.out.println("recursion(n); = " + recursion(n));
    }

}
