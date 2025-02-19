import java.util.Scanner;

public class ArrayCC {

    // 14.3
    public static void update(int scores[], int nonchagable) {
        nonchagable = 132;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + 1;
        }
    }

    // 14.5
    public static int linear_search(int no[], int key) {
        for (int i = 0; i < no.length; i++) {
            if (no[i] == key)
                return i;
        }
        return -1;
    }

    // 14.6
    public static void largest_find(int lar[]) {
        System.out.print("The array : ");
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < lar.length; i++) {
            System.out.print(lar[i] + " ");
            if (lar[i] > largest)
                largest = lar[i];
            if (lar[i] < smallest)
                smallest = lar[i];
        }
        System.out.println("\nThe largest among above array is : " + largest);
        System.out.println("\nThe smallest among above array is : " + smallest);
    }

    // 14.7 - Binary Search - TC = O(logn)
    public static int binary_search(int bin[], int keybin, int left, int right) {
        int mid = left + (right - left) / 2;
        if (bin[mid] == keybin)
            return mid;
        if (bin[mid] > keybin)
            return binary_search(bin, keybin, left, mid - 1);
        if (bin[mid] < keybin)
            return binary_search(bin, keybin, mid + 1, right);
        return -1;
    }
    // Mam Approach - Binary Search
    // public static int binary_search(int bin[], int keybin, int start, int end) {
    // while (start <= end) {
    // int mid = start + (end - start) / 2;
    // if (bin[mid] == keybin)
    // return mid;
    // if (bin[mid] > keybin)
    // end = mid-1;
    // if (bin[mid] < keybin)
    // start = mid+1;
    // }
    // return -1;
    // }

    // 14.9 - Reverse an array
    public static void reverse(int rev[]) {
        int start = 0, end = rev.length - 1;
        while (start < end) {
            int temp = rev[start];
            rev[start] = rev[end];
            rev[end] = temp;
            start++;
            end--;
        }
    }

    // 14.10 - Pairs in Arrays - O(n^2)
    public static void printpairs(int nums[]) {
        int tp = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("(" + nums[i] + "," + nums[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total pairs = " + tp);
    }

    // 14.11 - Print Subarrays - a continuous part of array
    public static void printsubarrays(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // H.W. 14.12 - Find sum of all subarray also print max and min sum of subarray
    // - O(n^3)
    public static void printsubarrayssum(int nums[]) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(nums[k] + " ");
                    sum += nums[k];
                    if (sum > max)
                        max = sum;
                    if (sum < min)
                        min = sum;
                }
                System.out.print(" |  Sum is : " + sum + " |  ");
            }
            System.out.println();
        }
        System.out.println("Maximum sum = " + max);
        System.out.println("Minimum sum = " + min);
    }

    // 14.13 - Max Subarray sum (Prefix Method)
    public static void maxsubarraysum(int nums[]) {
        System.out.println("\n14.13 Max Subarray sum - (Prefix Sum Approach)");
        int n = nums.length;
        int prefix_arr[] = new int[n];
        prefix_arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix_arr[i] = prefix_arr[i - 1] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            int start = i;
            for (int j = i; j < n; j++) {
                int end = j;
                currSum = start == 0 ? prefix_arr[end] : prefix_arr[end] - prefix_arr[start - 1];
                if (currSum > max)
                    max = currSum;
            }
        }
        System.out.println("Maximum sum is " + max);
    }

    // Another Approach
    // Special Case Included - When all array elements are negative and others
    public static int maxSubArray(int[] nums) {
        System.out.println("\n14.13 Max Subarray sum - (Prefix Sum Approach) | (Include all edge cases)");
        int n = nums.length;
        int prefix_arr[] = new int[n];
        prefix_arr[0] = nums[0];
        int maxSum = Integer.MIN_VALUE;
        int ct = nums[0] < 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                ct++;
                maxSum = Math.max(maxSum, nums[i]);
            }
            prefix_arr[i] = prefix_arr[i - 1] + nums[i];
        }
        if (ct == n)
            return n == 1 ? (maxSum = nums[0]) : (maxSum = Math.max(maxSum, nums[0]));
        int currSum = 0;
        maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                currSum = i == 0 ? prefix_arr[j] : prefix_arr[j] - prefix_arr[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    // Best Approach
    public static void maxsubarraysum_kadane_algo(int nums[]) {
        System.out.println("14.14 Max Subarray sum - (Kadane's Algorithm)");
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        int ct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                ct++;
            currSum += nums[i];
            currSum = currSum < 0 ? currSum = 0 : currSum;
            maxSum = Math.max(currSum, maxSum);
        }
        // Below Code - Special Case if all element of array are negative
        if (ct == nums.length) {
            maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                maxSum = maxSum < nums[i] ? maxSum = nums[i] : maxSum;
            }
        }
        System.out.println("Maximum of Subarray : " + maxSum);
    }

    // 14.15 Trapping Rainwater
    public static void trapping_rainwater(int height[]) {
        // My Approach --> Wrong Approach (Find Left(max) and right(max) then
        // calculate blocks of area in between and subtract it from blocks
        // given in array in between ledt(max) and right(max))
        // int big_index = 0, other_big_index = 0, trap = 0, sub = 0, water=0;
        // for (int i = 1; i < height.length; i++) {
        // if (height[i] > height[i - 1]) {
        // other_big_index = i;
        // water = (Math.abs(other_big_index - big_index) * Math.max(big_index,
        // other_big_index));
        // trap = trap + sub - (water < 0 ? 0 : water) ;
        // sub = 0;
        // big_index = i;
        // } else
        // sub += height[i];
        // }
        // System.out.println("Trapped Water : "+trap);

        // Mam Approach - Right Approach
        int n = height.length;
        // leftmost max array
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }
        // rightmost max array
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
        for (int i = n-2; i >=0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }
        int width =1;
        int trapped =0;
        for(int i=0; i<n;i++){
            int water_level = Math.min(leftmax[i] , rightmax[i]);
            trapped += (water_level - height[i])*width;
        }
        System.out.println(trapped);
    }

    public static void buy_sell(int prices[]){
        int buy_price = prices[0], max_profit =0 ;
        for(int sell_day=1; sell_day< prices.length; sell_day++){
            if(buy_price > prices[sell_day]){
                buy_price = prices[sell_day];
            }
            else{
                int profit = prices[sell_day]-buy_price;
                max_profit = Math.max(profit, max_profit);
            }
        }
        System.out.println("Max_profit : "+max_profit);
    }
    public static void main(String[] args) {
        // 14.1
        int score[] = new int[50];
        int numbers[] = { 1, 2, 3 };
        String fruits[] = { "apple", "mango", "orange" };

        // 14.2
        // Input
        int mark[] = new int[100];
        // Array Length
        System.out.println("Length of Array : " + mark.length);
        System.out.println("14.2 - Input values in Arrays");
        Scanner sc = new Scanner(System.in);
        // int phy;
        // phy =sc.nextInt();
        mark[0] = sc.nextInt(); // phy
        mark[1] = sc.nextInt(); // math
        mark[2] = sc.nextInt(); // che

        // Output
        System.out.println("phy : " + mark[0]);
        System.out.println("math : " + mark[1]);
        System.out.println("che : " + mark[2]);
        System.out.println("Not Input : " + mark[3]);

        // Updation
        mark[1] = mark[1] + 2;
        mark[2] = 100;
        System.out.println("math : " + mark[1]);
        System.out.println("che : " + mark[2]);

        // 14.3 - Array as Function Arguments
        System.out.println("\n14.3 - Array as Function Arguments");
        int scores[] = { 97, 98, 99 };
        int nonchagable = 5;
        System.out.print("Old Scores : ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        update(scores, nonchagable);
        System.out.print("\nNew Scores : ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println("\n\tArray Values Changes as Array always on Pass by Reference");
        System.out.println(
                "Nonchangable Integer : " + nonchagable + "\n\tAs Integer Does is passed by value it will not change");

        // 14.4 - Reading Material : Time and Space Complexity

        // 14.5 - Linear Search // TC - O(n)
        System.out.println("/n 14.5 - Linear Search");
        int key = 10;
        int no[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int index = linear_search(no, key);
        System.out.println((index == -1) ? "Key not Exist" : "Found key at index " + index);

        // 14.6 - Largest No
        int lar[] = new int[50];
        System.out.println("Enter Input in Array (-1 to stop)");
        for (int i = 0; i < lar.length; i++) {
            lar[i] = sc.nextInt();
            if (lar[i] == -1) {
                lar[i] = 0;
                break;
            }
        }
        largest_find(lar);

        // 14.7 - Binary Search
        int bin[] = { 2, 4, 6, 8, 10, 12, 14, 16 }; // Prerequisite- In Increasing/ Decreasing Order
        int keybin = 14, left = 0, right = bin.length - 1;
        int index1 = binary_search(bin, keybin, left, right);
        System.out.println(index1 == -1 ? "Key not Found" : "Key Found at index " + index1);

        // 14.9 - Reverse an Array
        int rev[] = { 2, 4, 6, 8, 10, 11, 14, 15, 16 };
        reverse(rev);
        for (int i = 0; i < rev.length; i++) {
            System.out.print(rev[i] + " ");
        }
        System.out.println();

        // 14.10 - Pairs in Array
        int nums[] = { 2, 4, 6, 8, 10 };
        printpairs(nums);

        // 14.11 - Print Subarray
        printsubarrays(nums);

        // H.W. 14.12 - Subarray sum and max / min sum print
        printsubarrayssum(nums);

        // 14.12 Max Subarray sum - (Brute Force)
        int max_subarr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        printsubarrayssum(max_subarr);

        // 14.13 Max Subarray sum - (Prefix Sum Approach)
        maxsubarraysum(max_subarr); // TC - O(n^2) and SC - O(n)
        maxSubArray(max_subarr);

        // 14.14 Max Subarray sum - (Kadane's Algorithm)
        maxsubarraysum_kadane_algo(max_subarr); // TC - O(n) and SC = O(1)

        // 14.15 Trapping Rainwater
        int height_block[] = {4,2,0,6,3,2,5};
        trapping_rainwater(height_block);

        // 14.16 Best Time to Buy and Sell Stocks
        int stock_price[] = {7,1,5,3,6,4};
        buy_sell(stock_price);
    }
}
