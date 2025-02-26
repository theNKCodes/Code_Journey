import java.util.Scanner;

public class practicequesolve {
    // Q1 :
    public static int avg(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    // Q2 :
    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        return false;
    }

    // Q3:
    /* Recursive Approach for string - Fails in Runtime Error if String is too Large 
     * class Solution {
        int isPalindrome(String S) {
        return helper(S, 0, S.length() - 1);
        }

        int helper(String s, int start, int end) {
            if (start >= end) return 1;
        
            if (s.charAt(start) != s.charAt(end)) return 0;

            // Tail recursion
            return helper(s, start + 1, end - 1);
        }
    }
    */

    /* Best Approach for String -->  Iterative Approach for String 
     * 
    class Solution {
        int isPalindrome(String S) {
            int start = 0, end = S.length()-1;
            while(start < end){
                if(S.charAt(start) != S.charAt(end)) {return 0;}
                start++;
                end--;
            }
            return 1;
        }
    };
    */
        /*//Approach 1 for Integer
        int rev = 0;
        int original =x;
        while(x > 0){
            int lastdigit = x % 10;
            rev = lastdigit + (rev * 10);
            x = x / 10;
        }
        if(rev == original) return true;
        return false;
        */
        //Approach 2 - For Integer 
    public static boolean palind(int x){
        if(x < 0 || (x!=0 && x % 10 == 0)) return false;
        int reversed =0 , temp = x;
        while(x > reversed){
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        return (x== reversed) || (x == reversed / 10);
    }

    public static void sum(int no){
        int sum = 0;
        while(no>0){
            sum = sum + (no%10);
            no /= 10;
        }
        System.out.println("Sum of the digits of integer = "+ sum);
    }


    public static void main(String[] args) {
        // Question 1 : Write a Java method to compute the average of three numbers.
        System.out.println("Write a Java method to compute the average of three numbers.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three no. ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Average : " + avg(a, b, c));

        /*
         * Question 2 : Write a method named isEven that accepts an int argument. The
         * method should return true if the argument is even, or false otherwise. Also
         * write a program to test your method.
         */
        System.out.println("Question 2 : Write a method named isEven that accepts an int argument. The method\r\n" + //
                "should return true if the argument is even, or false otherwise. Also write a program to test your\r\n" + //
                "method.");
        System.out.println(isEven(5) == true ? "No is Even" : "No is Odd");

        /*
         * Question 3 : Write a Java program to check if a number is a palindrome in
         * Java? ( 121 is a palindrome, 321 is not) A number is called a palindrome if
         * the number is equal to the reverse of a number e.g., 121 is a palindrome
         * because the reverse of 121 is 121 itself. On the other hand, 321 is not a
         * palindrome because the reverse of 321 is 123, which is not equal to 321.
         */
        System.out.println("Question 3 : Write a Java program to check if a number is a palindrome in Java? ( 121 is a\r\n" + //
                "palindrome, 321 is not)\r\n" + //
                "A number is called a palindrome if the number is equal to the reverse of a number e.g., 121 is a\r\n" + //
                "palindrome because the reverse of 121 is 121 itself. On the other hand, 321 is not a\r\n" + //
                "palindrome because the reverse of 321 is 123, which is not equal to 321.");
        System.out.println("Q3 : Enter no. for palindrome check : ");
        int st = sc.nextInt();
        System.out.println(palind(st) == true ? "It is Palindrome" : "Not a Palindrome");


        System.out.println("Question 4 : READ & CODE EXERCISE\r\n" + //
                "Search about(Google) & use the following methods of the Math class in Java:\r\n" + //
                "a. Math.min( )\r\n" + //
                "b. Math.max( )\r\n" + //
                "c. Math.sqrt( )\r\n" + //
                "d. Math.pow( )\r\n" + //
                "e. Math.avg( )\r\n" + //
                "f. Math.abs( )");

                double x = 28;    
                double y = 4;    
                  
                // return the maximum of two numbers  
                System.out.println("Maximum number of x and y is: " +Math.max(x, y));   
                  
                // return the square root of y   
                System.out.println("Square root of y is: " + Math.sqrt(y));   
                  
                //returns 28 power of 4 i.e. 28*28*28*28    
                System.out.println("Power of x and y is: " + Math.pow(x, y));      
          
                // return the logarithm of given value       
                System.out.println("Logarithm of x is: " + Math.log(x));   
                System.out.println("Logarithm of y is: " + Math.log(y));  
                  
                // return the logarithm of given value when base is 10      
                System.out.println("log10 of x is: " + Math.log10(x));   
                System.out.println("log10 of y is: " + Math.log10(y));    
                  
                // return the log of x + 1  
                System.out.println("log1p of x is: " +Math.log1p(x));    
          
                // return a power of 2    
                System.out.println("return e^x ---> exp of a is : " +Math.exp(x));    
                  
                // return (a power of 2)-1  
                System.out.println("expm1 of a is: " +Math.expm1(x)); 
        System.out.println("Question 5 :\r\n" + //
                "Write a Java method to compute the sum of the digits in an integer.\r\n" + //
                "(Hint : Approach this question in the following way :\r\n" + //
                "a. Take a variable sum = 0\r\n" + //
                "b. Find the last digit of the number\r\n" + //
                "c. Add it to the sum\r\n" + //
                "d. Repeat a & b until the number becomes 0 )");
        System.out.println("\n Enter a no.");
        int no = sc.nextInt();
        sum(no);
    }
}
