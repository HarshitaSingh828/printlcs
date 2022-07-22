import java.util.*;
import java.io.*;
public class Main{
       
    public static void main(String[]args){
       Scanner scn = new Scanner(System.in);
       String s1 = scn.nextLine();
       String s2 = scn.nextLine();
       
       int m = s1.length();
       int n = s2.length();
       
       int[][] t = new int[m+1][n+1];
       String ans = lcs(s1,s2,m,n,t);
       StringBuilder sb = new StringBuilder(ans);
         
       System.out.println(sb.reverse());
    }
    
    public static String lcs(String s1, String s2, int m, int n,int[][]t){
        
        for(int i = 0; i < m+1; i++){                                                                     
           for(int j = 0; j < n+1;j++){
               if(i == 0 || j == 0){
                   t[i][j] = 0;
               }
           }
       }
       
       for(int i = 1; i < m+1; i++){
           for(int j = 1; j < n+1; j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   t[i][j] = 1 + t[i-1][j-1];
               }
               else{
                   t[i][j] = Math.max(t[i][j-1] ,t[i-1][j]);
               }
           }
       }
       int i = m;
      int j = n;
       String ans = "";
        while(i > 0 && j > 0){
          if(s1.charAt(i-1) == s2.charAt(j-1)){
              char x = s1.charAt(i-1);
              ans = ans+x;
              i--;
              j--;
          }
          else{
              if(t[i][j-1] > t[i-1][j]){
                  j--;
              }
              else{
                  i--;
              }
          }
      }
       return ans;
    }
}
