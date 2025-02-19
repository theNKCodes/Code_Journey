import java.util.Scanner;

public class Patterns {
// *
// * *
// * * *
// * * * *
// * * * * *
    public static void main(String[] args){
        // Print Star Patterns
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
System.out.println();
        //Inverted Start Pattern
        for(int i=0 ; i<n; i++){
            for(int j=n ; j>i; j--){
                System.out.print("* ");
            }
            System.out.println("");
        }
System.out.println();
        // Print Half Pyramid Pattern
        for(int i = 1; i<=n; i++){
            for(int j= 1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
System.out.println();
        char ct = 'a';
        for(int i=1 ; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(ct+" ");
                ct++;
            }
            System.out.println();
        }
    }
}
