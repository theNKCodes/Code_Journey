import java.util.Scanner;

public class PracticeQue {

  public static void main(String[] args) {
    /*Question 1 : In a program, input 3 numbers : A, B and C. You have to output the average of
    these 3 numbers.
    (Hint : Average of N numbers is sum of those numbers divided by N)*/
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int avg = (a + b + c) / 3;
    System.out.println("Average is " + avg);

    /*Question 2: In a program, input the side of a square. You have to output the area of the
    square.
    (Hint : area of a square is (side x side))*/
    int side = sc.nextInt();
    int area = side * side;
    System.out.println("Area of square is " + area);

    /*Question 3: Enter cost of 3 items from the user (using float data type) - a pencil, a pen and
    an eraser. You have to output the total cost of the items back to the user as their bill.
    (Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)*/
    float pencil = sc.nextFloat();
    float pen = sc.nextFloat();
    float eraser = sc.nextFloat();
    float total = pen + pencil + eraser;
    float grand = (float) (total + (total * 0.18));
    System.out.println(grand);

    /*Question 5: (Advanced) Will the following statement give any error in Java?
        int $ = 24;*/
    int $ = 24;
    //Ans : No any error.
  }
}
