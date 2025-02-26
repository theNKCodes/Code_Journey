4//12. Funtions and Method.
// The functions which are written inside the classes are called Methods.

// Main having return type void. void is a valid return type in Java.
// Also main is a reserved keyword in java. Here input of Strings of args name
// which is a array.
// Funtions is a block of code which can we recall many times

import java.util.Scanner;

public class fun {
    // 12.1
    // public static is a access modifier
    /*
     * Syntax :
     * returnType name(){
     * //body
     * return statement;
     * }
     */
    public static void Hello() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        return; // Here return; is not important as returntype is void.
                // If returntype is int, string or except void we must have to specify a return;
    }

    public static void sum() {
        System.out.println("Addition of No. \nEnter 2 no. :");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum is : " + a + b);
    }

    // 12.2
    /*
     * Syntax with Parameters :
     * returnType name(type param1, type param2){
     * //body
     * return statement;
     * }
     */
    public static int addition(int num1, int num2) {
        // num1 and num2 ---> Parameters or Formal Parameters. While receiving a values
        // from main or other funtions
        // public static int addition(int num1, int num2)----> Funtion Definition.
        int sum = num1 + num2;
        return sum;
    }

    // 12.4
    public static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        // Value for the variable n1 = 10 and n2 = 5 only exists inside swap while it
        // did not affect actual values inside main.
    }

    // 12.5
    public static int multiply(int p1, int p2) {
        return p1 * p2;
    }

    // 12.6
    public static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return (n * fact(n - 1));
    }

    // 12.7
    public static int binomial(int n, int r) {
        int nmr = fact(n - r);
        n = fact(n);
        r = fact(r);
        return (n / (r * nmr));
    }

    // 12.10
    public static int multi(int a, int b) {
        
        return a * b;
    }

    public static int multi(int a, int b, int c) {
        return a * b * c;
    }

    // 12.11
    public static int mul(int a, int b) {
        return a * b;
    }

    public static float mul(float a, float b) {
        return a * b;
    }

    // 12.12
    // Only for n>=2
    public static boolean isPrime(int n) {
        // corner cases :
        if (n == 2)
            return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 12.13
    // Optimized Method to find Prime no.
    public static boolean isPrime_Optimized(int n) {
        // corner cases :
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 12.14
    public static void PrimeInRange(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime_Optimized(i) == true)
                System.out.print(i + " ");
        }
    }

    // 12.15
    public static int binToDec(int no) {
        int ct = 0;
        double sum = 0;
        while (no > 0) {
            int last = no % 10;
            sum = sum + (last * Math.pow(2, ct));
            no /= 10;
            ct++;
        }
        return (int) sum;
    }

    // 12.16
    public static int decToBin(int no) {
        int binNum = 0, rem = 0, ct = 0;
        while (no > 0) {
            rem = no % 2;
            binNum = binNum + (int) (rem * Math.pow(10, ct));
            no /= 2;
            ct++;
        }
        return binNum;
    }

    public static void main(String[] args) {
        // 12.1
        Hello(); // Calling
        sum();

        // 12.2
        System.out.println("Addition of No. \nEnter 2 no. :");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Calling addition funtion :
        int sum = addition(a, b); // here a,b ---> Arguments or Actual Parameters.
        // While calling a funtion or
        // passing actual values to a funtion.
        System.out.println("Addition is : " + sum);

        // 12.3
        // What Happens in Memory ?
        // Alpha-Course\12. Funtions\Memory.png

        // 12.4 --> Call by Value
        // Swap - Values Exchange
        System.out.println("*** Java Always Calls By Value ***");
        int n1 = 5;
        int n2 = 8;
        swap(n1, n2);
        System.out.println("Original values inside main of n1 and n2 are : \nn1 = " +
        n1 + "\nn2 = " + n2);
        System.out.println("Hence it is call by value");

        // 12.5 --> Find Product of numbers.
        int product = multiply(n1, n2);
        System.out.println("Product is : " + product);

        // 12.6 --> Calculate Factorial of a numbers
        System.out.print("Factorial of num : \n Enter the number : ");
        int number = sc.nextInt();
        System.out.println(" Factorial of " + number + " is : " + fact(number));

        // 12.7 --> Binomial Coefficient (nCr) = n!/r!(n-r)!
        System.out.print("Enter n = ");
        int n = sc.nextInt();
        System.out.print("Enter r = ");
        int r = sc.nextInt();
        System.out.println("Binomial Coefficient : " + binomial(n, r));

        // 12.8 --> User Defined AND Inbuilt Methods
        // Alpha-Course\12. Funtions\User Defined vs Inbuilt Functions.jpg

        // 12.9 --> Function Overloading
        // Multiple Funtion with the same name but different parameters.
        // Alpha-Course\12. Funtions\Funtion Overloading.jpg

        // 12.10 --> Function Overloading using Paramaters
        // F1 : Multiplication of 2 no.
        // F2 : Multiplication of 3 no.
        int s1 = 3, s2 = 4, s3 = 5;
        System.out.println("Multiply of 2 no. using funtion Overloading with parameters : " + multi(s1, s2));
        System.out.println("Multiply of 3 no. using funtion Overloading with parameters: " + multi(s1, s2, s3));
        // IMP : Funtion Overloading does not depend upon return type.
        // Alpha-Course\12. Funtions\Funtion Overloading using Parameters.jpg

        // 12.11 --> Funtion Overloading using Data Types
        // F1 : Multiply 2 int values.
        // F2 : Multiply 2 float values.
        System.out.println("Multiply of 2 no. using funtion Overloading with int data type : " + mul(13, 15));
        System.out.println("Multiply of 2 no. using funtion Overloading with float type : " + mul(13.5f, 15.2f));

        // 12.12 -->Check if a number is prime or not
        if (isPrime(5) == true)
        System.out.println(n+"No is Prime");
        else
        System.out.println(n+"Not a Prime no.");

        // 12.13 --> Optimized Prime no.
        // Alpha-Course\12. Funtions\Prime or not [Brute vs Optimized].jpg
        if (isPrime_Optimized(8) == true)
        System.out.println(n+"No is Prime");
        else
        System.out.println(n+"Not a Prime no.");

        // 12.14 --> Print all Primes in a Range
        // If n=10 Print all primes from 2 to 10
        PrimeInRange(20);

        // 12.15 --> Convert from Binary to Decimal
        // Alpha-Course\12. Funtions\No. System.jpg
        // Alpha-Course\12. Funtions\Binary to Decimal Approach.jpg
        System.out.print("\nEnter a binary no. : ");
        int binNum = sc.nextInt();
        System.out.println("Decimal of " + binNum + " : " + binToDec(binNum));

        // 12.16 --> Convert from Decimal to Binary
        System.out.print("Enter Decimal no. : ");
        int decNum = sc.nextInt();
        System.out.println("Binary of " + decNum + " : " + decToBin(decNum));

        // 12.17 --> Scope
        /*
         * Method Scope : A variable in the Method/Function is only applicable till that function only.
         *                 that variable will not get influenced by another function.
         */
        //System.out.println(s); // This will give error as s is not defined yet as compiler checks line by line and s is not defined yet.
        int s = 15;
        System.out.println(s); //There is no any error.

        //12.18 --> Block Scope
        /*
         * {
         *  //Block of Code as it is between two curly braces{}.
         * }
         */
        {
            int p = 45;
            System.out.println(p);
        }
        // System.out.println(p); // This will give error as p is between block above while we are printing outside that block.

        //12.18 --> Class Scope. ---> for which we use access modifiers. ---> ex. access modifier(public, private, protected)
    }
}