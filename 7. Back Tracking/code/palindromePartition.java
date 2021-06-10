import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class palindromePartition {
    
    ArrayList<ArrayList<String>> palPar = new ArrayList<ArrayList<String>>();
    
    public boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        return str.length()==1 || str.equals(sb.reverse().toString());
    }
    
    public void customSort(ArrayList<ArrayList<String>> palPar){
        Collections.sort(palPar, new Comparator<ArrayList<String>>(){
            public int compare(ArrayList<String> a, ArrayList<String> b){
                int size = Math.min(a.size(), b.size());
                for(int i=0; i<size; i++){
                    int cmp = Integer.compare(a.get(i).length(),b.get(i).length());
                    if(cmp!=0) return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
            
        });
    }
    public void palindromePar(int start, int end, String a, ArrayList<String> par){
        if(start == end){
            palPar.add(new ArrayList<String>(par));
            return;
        }
        for(int i=start; i<end; i++){
            String temp = a.substring(start, i+1);
            if(isPalindrome(temp)){
                par.add(temp);
                palindromePar(i+1, end, a, par);
                par.remove(par.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<String>> partition(String a) {
        palindromePar(0, a.length(), a, new ArrayList<String>());
        customSort(palPar);
        return palPar;
    }
    public static void main(String[] args) {
        palindromePartition p = new palindromePartition();
        ArrayList<ArrayList<String>> set = p.partition("aab");
        
        for(ArrayList<String> s : set) System.out.println(s);
    }
}
//Same logic as https://github.com/AbhishekSingh1180/Data-Structure-And-Algorithm/blob/master/7.%20Back%20Tracking/code/noOfWayStrFormFromSet.java