class solve{
    int fun(int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }
}
class Solution {
    public int sum(int num1, int num2) {
     solve s = new solve();
     return s.fun(num1,num2);
    }
}