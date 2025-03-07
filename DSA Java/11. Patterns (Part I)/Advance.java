import java.util.Scanner;

public class Advance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter n : ");
        // int n = sc.nextInt();
        int n = 4;
        System.out.println("1. Hollow Rectangle Pattern");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("2. Inverted and Rotated Half Pyramid");
        for (int i = 1; i <= n; i++) {
            for (int spaces = 1; spaces < (n - i + 1); spaces++) {
                System.out.print("  ");
            }
            for (int stars = (n - i + 1); stars <= n; stars++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("3. Inverted Half-Pyramid with Number Pattern");
        for (int i = 1; i <= n; i++) {
            int no = 1;
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(no + " ");
                no++;
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("4. Floyd's Triangle Pattern");
        int no = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(no + " ");
                no++;
            }
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("5. 0-1 Traingle Pattern");
        int num = 1;
        for (int i = 1; i <= n; i++) {
            int temp = num;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num = (num == 1) ? 0 : 1;
            }
            num = (temp == 1) ? 0 : 1;
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("6. Butterfly Pattern");
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j < ((n * 2) - (i * 2)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= (n * 2) - 1; i++)
            System.out.print("* ");
        System.out.println();
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j < ((n * 2) - (i * 2)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("7. Solid Rhombus Pattern");
        for(int i=1; i<=n; i++){
            for(int spaces =1; spaces <= (n-i); spaces++){
                System.out.print("  ");
            }
            for(int star=1; star<=n;star++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("8. Hollow Rhombus Pattern");
        for(int i=1; i<=n ; i++){
            for (int spaces=1 ; spaces<=n-i; spaces++){
                System.out.print("  ");
            }
            for(int star=1; star<=n;star++){
                if(i==1 || i==n || star==n || star==1 ) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("9. Diamond Pattern");
        for(int i=1; i<=n; i++){
            for(int spaces=1 ;spaces <=n-i; spaces++) System.out.print(" ");
            for(int star=1; star<=i; star ++) System.out.print("* ");
            System.out.println();
        }
        for(int i=n-1; i>=1 ; i--){
            for(int spaces=1 ;spaces <=n-i; spaces++) System.out.print(" ");
            for(int star=1; star<=i; star ++) System.out.print("* ");
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("Number Pyramid Pattern");
        for(int i=1; i<=n ; i++){
            for(int spaces=1; spaces <=n-i; spaces++) System.out.print(" ");
            for(int star=1; star<=i; star++) System.out.print(i+" ");
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("Palindromic Pattern with Numbers Pattern");
        
        for(int i=1; i<=n ; i++){
            for(int spaces=1; spaces<=n-i; spaces++){
                System.out.print(" ");
            }
            boolean trigger = false;
            no = (i*2)/2;
            for(int star =1; star <= (i*2)-1; star ++){
                System.out.print(no);
                if(no==1) trigger =true ;
                if (trigger == true ) no+=2;
                no--;
            }
            System.out.println();
        }
    }
}
