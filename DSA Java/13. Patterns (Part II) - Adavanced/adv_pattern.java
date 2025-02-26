public class adv_pattern {
    public static void hollow_rectangle(int totRows, int totCols) {
        System.out.println("Hollow Rectangle :- ");
        for (int i = 1; i <= totRows; i++) {// outer loop
            for (int j = 1; j <= totCols; j++) {// inner loop
                if (i == 1 || i == totRows || j == 1 || j == totCols)
                    System.out.print("* ");// boundary condition
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    // MyLogic
    // public static void inverted_rotated_half_pyramid(int totRows, int totCols){
    // System.out.println("Inverted & Rotated Half Pyramid :-");
    // for(int i=1; i<=totRows;i++){
    // for(int j=1; j<=totCols;j++){
    // if(i>totCols-j) System.out.print("* ");
    // else System.out.print(" ");
    // }
    // System.out.println();
    // }
    // }

    // Shraddha Mam Logic
    public static void inverted_rotated_half_pyramid(int totRows, int totCols) {
        System.out.println("Inverted & Rotated Half Pyramid :-");
        for (int i = 1; i <= totRows; i++) {
            // Spaces Print
            for (int j = 1; j <= totRows - i; j++) {
                System.out.print("  ");
            }
            // Stars Print
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // MyLogic
    // public static void inverted_rotated_half_pyramid_with_no(int no_of_lines) {
    // System.out.println("Inverted Half Pyramid with no. :-");
    // for(int i=1;i<=no_of_lines;i++){
    // for(int j=1; j<=no_of_lines; j++){
    // if(i<=no_of_lines-j+1) System.out.print(j+" ");
    // else System.out.print(" ");
    // }
    // System.out.println();
    // }
    // }

    // Shraddha mam Logic
    public static void inverted_rotated_half_pyramid_with_no(int no_of_lines) {
        System.out.println("Inverted Half Pyramid with no. :-");
        for (int i = 1; i <= no_of_lines; i++) {
            for (int j = 1; j <= no_of_lines - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int no_of_lines) {
        System.out.println("Floyd's Triangle :-");
        int counter = 1;
        for (int i = 1; i <= no_of_lines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    // My Approach
    // public static void zero_one_triangle(int no_of_lines) {
    // System.out.println("0 - 1 Triangle :-");
    // int first = 1;
    // for (int i = 1; i <= no_of_lines; i++) {
    // int ct = first;
    // for (int j = 1; j <= i; j++) {
    // System.out.print(ct + " ");
    // if (ct == 1)
    // ct = 0;
    // else
    // ct = 1;
    // }
    // if (first == 1)
    // first = 0;
    // else
    // first = 1;
    // System.out.println();
    // }
    // }

    // Mam Approach
    public static void zero_one_triangle(int no_of_lines) {
        System.out.println("0 - 1 Triangles :-");
        for (int i = 1; i <= no_of_lines; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("1 "); // (row + column) is even -> print 1
                else
                    System.out.print("0 "); // is odd -> print 0
            }
            System.out.println();
        }
    }

    // Same Approach
    public static void butterfly_pattern(int n) {
        System.out.println("Butterfly_pattern :-");
        for (int i = 1; i <= n; i++) {
            // stars = i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces = 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars = i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            // stars = i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces = 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars = i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Alternate Second Half :

        // for (int i = 1; i <= n; i++) {
        // //stars = n-i+1
        // for (int j = 1; j <= n - i + 1; j++) {
        // System.out.print("* ");
        // }
        // //spaces = 2 * (i-1)
        // for (int j = 1; j <= 2 * (i - 1); j++) {
        // System.out.print(" ");
        // }
        // //stars = n-i+1
        // for (int j = 1; j <= n - i + 1; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
    }

    public static void solid_rhombus(int n) {
        System.out.println("Solid Rhombus :- ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= n; j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        System.out.println("Hollow Rhombus :- ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n)
                    System.out.print("* ");
                else {
                    if (j == 1 || j == n)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // My Logic

    // public static void diamond_pattern(int n) {
    // System.out.println("Diamond Pattern :-");
    // for (int i = 1; i <= n; i++) {
    // for (int j = 1; j <= n - i; j++)
    // System.out.print(" ");
    // for (int j = 1; j <= i; j++)
    // System.out.print("* ");
    // for (int j = 1; j < i; j++)
    // System.out.print("* ");
    // System.out.println();
    // }
    // for (int i = n; i >=1; i--) {
    // for (int j = 1; j <= n - i; j++)
    // System.out.print(" ");
    // for (int j = 1; j <= i; j++)
    // System.out.print("* ");
    // for (int j = 1; j < i; j++)
    // System.out.print("* ");
    // System.out.println();
    // }
    // }

    // Mam Logic
    public static void diamond_pattern(int n) {
        System.out.println("Diamond Pattern :-");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("* ");
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("  ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollow_rectangle(4, 5);
        System.out.println();

        inverted_rotated_half_pyramid(4, 4);
        System.out.println();

        inverted_rotated_half_pyramid_with_no(5);
        System.out.println();

        floyds_triangle(5);
        System.out.println();

        zero_one_triangle(5);
        System.out.println();

        butterfly_pattern(5);
        System.out.println();

        solid_rhombus(5);
        System.out.println();

        hollow_rhombus(5);
        System.out.println();

        diamond_pattern(4);
        System.out.println();
    }
}