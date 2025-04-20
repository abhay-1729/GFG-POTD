//Problem: Find only Repetitive Element from 1 to n-1
class Solution {
    public int findDuplicate(int[] arr) {
        // code here
        int x =1;
        for(int i=2;i<arr.length;i++){
            x=x^i;
        }
        for(int i:arr){
            x=x^i;
        }
        return x;
    }
}
