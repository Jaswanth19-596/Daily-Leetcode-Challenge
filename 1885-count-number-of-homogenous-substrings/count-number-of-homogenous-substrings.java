class Solution {
    public int countHomogenous(String s) {

        long n = 1;
        final int mod = (int)1e9 + 7;
        long res = 0;
        for(int i = 1;i<s.length();i++){

            if(s.charAt(i) == s.charAt(i-1)){
                n += 1;
            }
            else{
                long temp = ((((n%mod) * ((n + 1)%mod)) % mod)/2)%mod;
                res = (res + temp) % mod;
                n = 1;
            }
        }
        long temp = ((((n%mod) * ((n + 1)%mod)) % mod)/2)%mod;
        res = (res%mod + temp%mod);
    
        return (int)res;

    }
}