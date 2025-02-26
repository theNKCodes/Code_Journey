import java.util.Scanner;

public class conditions {
    public static void main(String[] args) {
        // if,else | else if | ternery operator | switch

        /* Syntax 1. if-else Statements
            if(condition){

            }
            else{

            }
         */
            // Ex. 1.1 if-else
            System.out.println("If else\n 1.1 Adult or Not");
            int age = 20;
            if (age >= 18) {
                System.out.println("Adult");
            } else {
                System.out.println("Not Adult");
            }

            // Ex. 1.2 Print the largest of 2
            System.out.println("1.2 Printing Largest of two no. : ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b) {
                System.out.println(a + " is largest of two");
            }
            if (a == b) {
                System.out.println("Both are equal");
            } else {
                System.out.println(b + " is largest of two");
            }

            //Ex. 1.3 Print if a number is Odd or Even
            // Scanner sc = new Scanner(System.in);
            System.out.println("1.3 Even or Odd");
            int c = sc.nextInt();
            if (c % 2 == 0) {
                System.out.println("EVEN");
            } else {
                System.out.println("ODD");
            }

        /* Syntax 2. else if Statements
            if(condition){

            }
            else if{

            }
         */
            //ex. 2.1 else-if
            System.out.println("2. else if\n 2.1 Adult | Child | Baby");
            int age1 = 15;
            if (age1 >= 18) {
                System.out.println("Adult");
            }else if(age1>13 && age1<18){
                System.out.println("Child");
            } 
            else {
                System.out.println("Baby");
            }

            //Income Tax Calculator
            System.out.println("2.2 Income Tax Calculator");
            int Income = sc.nextInt();
            int Tax;
            if (Income < 500000) {
                System.out.println(" 0 % Tax");
                Tax = 0;
            } else if (Income >= 500000 && Income < 1000000) {
                System.out.println("20 % Tax");
                Tax = (int) (Income * 0.2);
            } else {
                System.out.println("30 % Tax");
                Tax = (int) (Income * 0.3);
            }
            System.out.println("Your Tax is : " + Tax);

            // Print Largest of 3 no.
            // Scanner sc = new Scanner(System.in);
            System.out.println("2.3 Print Largest of three\n Input 3 numbers : ");
            int a2 = sc.nextInt();
            int b2 = sc.nextInt();
            int c2 = sc.nextInt();
            if (a2 > b2) {
                if (a2 > c2) {
                    System.out.println(a2 + " is largest");
                } else {
                    System.out.println(c2 + " is largesr");
                }
            } else {
                if (b2 > c2) {
                    System.out.println(b2 + " is largest");
                } else {
                    System.out.println(c2 + " is largest");
                }
            }
        
        
        /* Ternary Operators -> Here three operands are used
         * variable = condition ? statement1 : statement2;  //Here if codition is true then statement1 executes else statement2 executes
         * int larger = (5 > 3) ? 5 : 3 //Here as 5 is always greater than three Hence larger = 5.
         */
            //ex. 3.1
                System.out.println("3. Ternary Operator \n 3.1 Odd or Even :");
                int num = 4;
                String type = ((num % 2) == 0) ? "even" : "odd";
                System.out.println(type);

            //Ex. 3.2
            System.out.println("3.2 Pass or Fail :");
            int marks = 33;
            String Status = (marks>33) ? "Pass" : "Fail";
            System.out.println(Status);
        
        /*  Switch Statements
         * Syntax -
         *  switch(variable){
         * case 1:
         *      break;
         * case 2:
         *      break;
         * case 3:
         *      break;
         * default:
         * }
         */
            //ex. 4.1
            System.out.println("4. Switch Statements\n 4.1 Basic Example");
        int p = 2;
        switch (p) {
            case 1:
                System.out.println("Samosa");
                break;
            case 2:
                System.out.println("Burger");
                break;
            case 3:
                System.out.println("Mango Shake");
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }   //To write character as a variable always write it in single quaote ex. 'p'
            //ex. 4.2 Calculator
            // Scanner sc = new Scanner(System.in);
            System.out.println("4.2 Calculator \n Input Two No : ");
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            System.out.println("1.Addition\n2.Substraction\n3.Multiplication\n4.Division");
            int res = sc.nextInt();
            switch(res){
                case 1 : System.out.println("Add : " +(p1+q1));
                    break;
                case 2 : System.out.println("SUb : "+ (p1-q1));
                    break;
                case 3 : System.out.println("Mul : "+(p1*q1));
                    break;
                case 4 : System.out.println("Div : "+(p1/q1));
                    break;
                default: System.out.println("invalid input");
            }
    }
}
