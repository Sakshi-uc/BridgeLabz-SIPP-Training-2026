class Solution {
    public int reverse(int x) {
        int maxi = Integer.MAX_VALUE;
        int mini= Integer.MIN_VALUE;
        int rev =0;
        while(x!=0){
            int l=x%10;
            x=x/10;
            if(rev>maxi/10){
                return 0;
            }
            if(rev<mini/10){
                return 0;
            }
            if(rev==maxi/10){
                if(l>7){
                    return 0;
                }
                
            }
            if(rev==mini/10){
                if(l<-8){
                    return 0;
                }
            }
            rev=rev*10 +l;
        }
        return rev;

    }
}