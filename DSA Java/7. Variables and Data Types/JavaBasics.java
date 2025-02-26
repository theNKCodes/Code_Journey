public class JavaBasics {

  public static void main(String[] args) {
    System.out.println("Hello");

    // //Variables in Java
    // // a,b are variables
    // //2,1,4 are literals
    // //'a', 'b', 'c' are character literals. As 'a' is written inside single quote ('') it is chareacter.
    // int a = 10;
    // int b = 5; //Here a and b are identifiers
    // System.out.println("Area of rectangles is " + (a + b));

    // String name = "Tony Stark";
    // System.out.println(name);

    // byte c = 8; // 1 byte = 8 bits | Range[-128 to 127] | Total 256
    // System.out.println(c);
    // char ch = 'a'; // 2 bytes
    // System.out.println(ch);
    // boolean var = true; // 1 byte
    // int number = 23; // 4 bytes | -2 Billion to 2 Billion without decimal point
    // float price = 14; // 4 bytes | No. with floating points
    // //long // 8 bytes
    // //double // 8 bytes
    // //short // 2 bytes
    // //There are total 8 primitive datatypes.

    // // Input in Java
    // Scanner sc = new Scanner(System.in);
    // String input = sc.next(); //only capture till space ex. if input "Tony Stark" by user but sc.next() captures only "Tony"
    // System.out.println(input);
    // System.out.println("h");
    // String na = sc.nextLine(); //Captures all with spaces
    // System.out.println(na);
    // //For Int use nextInt(), float use nextFloat(), nextByte, nextDouble, nextBoolean, nextShort, nextLong.

    // //Sum of a & b
    // Scanner sc = new Scanner(System.in);
    // int a1 = sc.nextInt();
    // int b1 = sc.nextInt();
    // System.out.println("Sum is "+(a1+b1));

    // // Product of a & b
    // Scanner sc = new Scanner(System.in);
    // int a2 = sc.nextInt();
    // int b2 = sc.nextInt();
    // System.out.println("Product is "+(a2*b2));

    // // Area of a circle
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter Radius");
    // float rad = sc.nextInt();
    // float area = 3.14f * rad *  rad; //Here we get error if we write as 3.14 we have to write 3.14f. As compiler thinks 3.14 is double value and cannot be store in float
    // System.out.println("Area of circle is "+area);

    // // Type Conversion OR Widening Conversion OR Implicit Conversion - Converting from int to float. Type should be compatible
    // //byte -> short -> int -> float -> long -> double
    // //Destination size  >= Source size ex. Double (Destination) >= Float (Source)
    // Scanner sc = new Scanner(System.in);
    // float num = sc.nextInt();  //Here nextInt() can be used to for storing in float value but nextFloat() cannot be used t store it in integer.
    // System.out.println(num);

    // // Type Casting OR Narrowing Conversion - To store bigger size value into smaller datatype ex. Storing Float into integer.
    // // Java doesn't allow it but we can do it Hence it is also called explicit casting.
    // int marks = (int)99.34f;
    // System.out.println(marks);
    // float a3 = 24.54f;
    // int b = (int) a3;
    // System.out.println(b);
    // char ch = 'a';
    // char ch1 = 'b';
    // int num1 = ch;
    // int num2 = ch1;
    // System.out.println(num1+"\n"+num2);

    // //Type Promotion in Expressions - Automatically promote each byte, short, or char operand to int when evaluating an expression.
    // char p1 = 'a';
    // char p2 = 'b';
    // System.out.println(p2 - p1); //Here output is 1. As a = 97 and b =98.
    // int p3 = 10;
    // float p4 = 20.25f;
    // long p5 = 25;
    // double p6 = 30;
    // double ans = p3 + p4 + p5 + p6;
    // System.out.println(ans);
    // // int ans1 = p3 + p4 + p5 + p6; //Here we get error as lossy conversion from double to int.
    // // System.out.println(ans1);
    // //wrong
    // //byte b = 5;
    // //b=b*2;
    // //right
    // byte b = 5;
    // b = (byte) (b * 2);
  }
}
