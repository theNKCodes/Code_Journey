import java.util.Scanner;

public class loops {
    public static void main(String[] args) {
        // Types of Loops
        // 1. while loop | 2. for loop | 3. do while loop

        /*1. while loop
            Syntax
            while(condition){
                //this loop valid till condition is true.
                //whenever condition false loops ends
            }
        */
        // //ex. 1.1 Printed Hello World 10 times
        // int counter = 0;
        // while (counter < 10) {
        //     System.out.println(" Hello world");
        //     counter++; // counter +=1;
        // }

        //ex. 1.2 Print number from 1 to 10
        // int ct = 0;
        // while (ct < 10){
        //     System.out.print((ct+1+" "));
        //     ct++;
        // }
        // System.out.println();

        // //ex. 1.3  Print number from 1 to n
        Scanner sc = new Scanner(System.in);
        // int range = sc.nextInt();
        // int ct1 = 1;
        // while(ct1<= range){
        //     System.out.print(ct1 + " ");
        //     ct1++;
        // }

        // //ex. 1.4 Print sum of first n natural numbers
        // //Scanner sc = new Scanner(System.in);
        // int p = sc.nextInt();
        // int sum1 = 0;
        // while(p>0){
        //     sum1 += p;
        //     p--;
        // }
        // System.out.println("Sum of first n natural no. "+sum1);

        /* 2. for loop
         * Syntax
            for( initialisation ; condition ; updation ){
             
            }
         */

        //  //ex. 2.1
        // for (int i = 0; i <= 10; i++) {
        //     System.out.println("Hello World");
        // }
        // System.out.println();


        // //ex. 2.2 Print square Pattern
        // System.out.println("2.2 Printing Square Pattern");
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }


        // //ex. 2.3 Reverse a number
        // int num2 = 4567725;
        // int rev = 0;
        // while (num2 > 0) {
        //     int lastdigit = num2 % 10;
        //     System.out.print(lastdigit + " ");
        //     num2 /= 10;
        //     rev *= 10;
        //     rev += lastdigit;
        // }
        // System.out.println(rev);

        /*
         * 3. do while loop
         * Syntax 
            do{
                }while(condition);
         */
        // //ex. 3.1 
        // int ct3 = 1;
        // do{
        //     System.out.println("Hello Friends");
        //     ct3++;
        // }while(ct3<=10);

        /* Break Statements - Used to exit the loops
         */
        //ex. 
        // for(int i=1; i<=5;i++){
        //     if(i==3){
        //         break;
        //     }
        //     System.out.println(i);
        // }
        // System.out.println("I am out of the loop");

        // Question Break Keyword
        // Keep Entering numbers till user enters a multiple of 10
        // //Scanner sc = new Scanner(System.in);
        // while(true){
        //     int num = sc.nextInt();
        //     if(num % 10 == 0) break;
        //     else System.out.println("You Entered : " + num);
        // }
    }
}
