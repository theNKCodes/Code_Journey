public class Palindrome {
    public static boolean solution(String inputString) {
        if (inputString.length() <= 1)
            return true;
        else {
            for (int i = 0; i < inputString.length() / 2; i++) {
                if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(solution(s));
    }
}
