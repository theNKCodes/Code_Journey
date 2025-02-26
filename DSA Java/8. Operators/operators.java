public class operators {

  public static void main(String[] args) {
    /* Operators are symbols that tell compiler to perform some operation.
        ex. sum = a + b , Here a,b are operand and + is a operators.
        Types of Opearators
            1. Arithmetic , 2. Relational, 3. Logical, 4. Bitwise , 5. Assignment */

    /* 1. Arithmetic Operators
         * Binary ->   + - * / %
         * Unary ->  ++ --
     */
    int a = 10;
    int b = 5;
    // 1.1 Binary
    System.out.println("\nArithmetic Binary Operators :");
    System.out.println("Add = " + (a + b));
    System.out.println("Sub = " + (a - b));
    System.out.println("Mul = " + (a * b));
    System.out.println("Div = " + (a / b));
    System.out.println("Rem = " + (a % b));
    // 1.2 Unary
        // When we have to write a = a + 1 we can write a++ or ++a same for decrement
        // Two Types | 1) Pre Increment(++a) | 2) Post Increment (a++)
            // 1) In Pre Increment(++a), first Value changes then use.
            // 2) In Post Increment(a++), first Value used then increment.
        System.out.println("\nArithmetic Unary Operators :");
        int A = 10;
        int B = ++A;
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        int C = 10;
        int D = C++;
        System.out.println("C = " + C);
        System.out.println("D = " + D);
        //Same for Decrement Operator

    /* 2. Relational Operators
     * ex. == , != , > , < , >= , <=
     */
      System.out.println("\nRelational Operators :");
      int a2 = 10;
      int b2 = 10;
      System.out.println(a2 == b2);
      System.out.println(a2 != b2);
      System.out.println(a2 > b2 );
      System.out.println(a2 < b2);
      System.out.println(a2 >= b2);
      System.out.println(a2 <= b2);

    /* 3. Logical Operators
     * ex. && (Logical AND) , || (Logical OR) , ! (Logical NOT) 
     * 3.1 Logical AND (&&) -> Only Returns TRUE when both statements are true.
     * 3.2 Logical OR (||) -> Returns True when any one of the two statements is true.
     * 3.3 Logicla NOT (!) -> To convert true to false and false to true
     */
      System.out.println("\nLogical Oprators :");
      System.out.println("1 . Logical AND (&&)");
      System.out.println((10 > 5) && (10 > 9));
      System.out.println((10 > 5) && (10 > 11));
      System.out.println("2 . Logical OR (||)");
      System.out.println((10 > 5) || (10 > 9));
      System.out.println((10 > 5) || (10 > 11));
      System.out.println((10 > 11) || (10 > 9));
      System.out.println((10 > 11) || (10 > 15)); // Logical OR (||) only returns false when both statements are false.
      System.out.println("3 . Logical NOT (!)");
      System.out.println(!(3 > 2));

    /* 4. Assignment Operator
     * ex.  = , += , -= , *= , /=
     * A = B
     * If want to write A = A + 10 write it as A += 10. Here oprand has to be same like here is A. 
     */
    System.out.println("\n4 . Assignment Oprators");
      int A4 = 10;
      // A4 = A4 + 10;
      A4 += 10;
      System.out.println(A4);
      int B4 = 20;
      // B4 = B4 + 10;
      B4 -= 10;
      System.out.println(B4);
      int C4 = 10;
      // C4 = C4 * 10;
      C4 *= 10;
      System.out.println(C4);
      int D4 = 10;
      // D4 = D4 / 10;
      D4 /= 10;
      System.out.println(D4);

        int x, y, z;
        x = y = z = 2;
        x += y;
        y -= z;
        z /= (x + y);
        System.out.println(x + " " + y + " " + z);

        
  }
}
