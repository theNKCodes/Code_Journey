import java.util.Scanner;

public class Advance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        // for (int i = 0; i < n-1; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if(i==0 || i==n-2){
        //             System.out.print("* ");
        //         }
        //         else if(j==0){
        //             System.out.print("* ");
        //         }
        //         else if(j==3){
        //             System.out.print("* ");
        //         }
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i<=n; i++){
            for(int j=0; j<n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
