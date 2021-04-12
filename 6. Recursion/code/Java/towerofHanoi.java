//Given N discs print the path movement of all discs.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class towerofHanoi
{
    static void towerOfHanoi(char Source, char Temp, char Destination, int noOfDics)    // S: source  T: temp   Destination: Destination  n: no. of dics
    {
        if(noOfDics==0) return;
        towerOfHanoi(Source,Destination,Temp,noOfDics-1);      // n-1 discs from source to temp
        System.out.println(noOfDics+" : "+Source+" --> "+Destination);  // nth disc from source to destination
        towerOfHanoi(Temp,Source,Destination,noOfDics-1); // n-1 discs from temp to destination
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfDics = Integer.parseInt(br.readLine()); 
        towerOfHanoi('A','B','C',noOfDics);
    }
}