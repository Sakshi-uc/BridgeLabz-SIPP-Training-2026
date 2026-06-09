class Solutions{
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;
        int ans=0;
        while(n>0){
            int m=n%10;
            product= product*m;
            sum=sum+m;
            
            n=n/10;
        }
        ans=product-sum;
        System.out.print(ans);
        return ans;
    }
}