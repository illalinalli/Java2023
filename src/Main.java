import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;
public class Main {
    private static Logger LOGGER = Logger.getLogger("aboba");

    public static int minutesToSeconds(String time){
        var strs = time.split(":");
        var minutes = Integer.parseInt(strs[0]);
        var seconds = Integer.parseInt(strs[1]);
        if (seconds < 60){
            return (minutes * 60) + seconds;
        }
        else{
            return -1;
        }
    }

    public static int countDigits(long num){
        if (num == 0) return 1;
        int count = 0;
        while(num != 0){
            num = num/10;
            count++;
        }
        return count;
    }

    public static Boolean isNestable(int[] a1, int[] a2){
        if (a1.length == 0 || a2.length == 0) return false;
        var min_a1 = Arrays.stream(a1).min().getAsInt();
        var max_a1 = Arrays.stream(a1).max().getAsInt();

        var min_a2 = Arrays.stream(a2).min().getAsInt();
        var max_a2 = Arrays.stream(a2).max().getAsInt();

        if (min_a1 > min_a2 && max_a1 < max_a2){
            return true;
        }
        return false;
    }
    public static String fixString(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }

    // Task 5 ----------------------------------------------------
    public static boolean isPalindromeDescendant(int num) {
        String str = Integer.toString(num);
        while (str.length() > 1) {
            if (isPalindrome(str)) {
                return true;
            }
            str = getNextDescendant(str);
        }
        return false;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String getNextDescendant(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = start; i < str.length() - 1; ) {
            int sum = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));

            sb.append(sum);
            start += 2;
            i = start;
        }
        return sb.toString();
    }
// -------------------------------

    public static int countK(int n) {
        if (n == 6174) {
            return 0;
        }
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = n % 10;
            n /= 10;
        }
        Arrays.sort(digits);
        int asc = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
        int desc = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];
        int diff = desc - asc;
        return 1 + countK(diff);
    }

    // Task 7
    public static int rotateLeft(int n, int shift){
        String binaryStr = Integer.toBinaryString(n);
        String shifted = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(shifted, 2);
    }

    public static int rotateRight(int n, int shift){
        String binaryStr = Integer.toBinaryString(n);
        String shifted = binaryStr.substring(binaryStr.length() - shift) + binaryStr.substring(0, binaryStr.length()-shift);
        return Integer.parseInt(shifted, 2);
    }
    // ---------------------------------------

    public static boolean knightBoardCapture(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = i + 1; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (board[k][l] == 1) {
                                int dx = Math.abs(k - i);
                                int dy = Math.abs(l - j);
                                if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Task 0
        LOGGER.info("Привет, мир!");

        // Task 1 - Длина видео
        var minutes = "10:60";
        System.out.println(minutesToSeconds(minutes));

        //Task 2 - Количество цифр
        long number = 123456;
        System.out.println(countDigits(number));

        // Task 3 - Вложенный массив
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{2, 3};
        System.out.println(isNestable(arr1, arr2));

        // Task 4 - Сломанная строка
        String str = "123456";
        System.out.println(fixString(str));

        // Task 5 - Особый палиндром
        System.out.println(isPalindromeDescendant(11211230));
        //System.out.println(isPalindromeDescendant(13001120));
        //System.out.println(isPalindromeDescendant(23336014));
        //System.out.println(isPalindromeDescendant(11));

        // Task 6 -  Постоянная Капрекара
        System.out.println(countK(3524));

        // Task 7 - Циклический битовый сдвиг
        System.out.println(rotateRight(8, 1));
        System.out.println(rotateLeft(16, 1));
        System.out.println(rotateLeft(17, 2));

        // Task 8
        int[][] array1 = {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
        };
        int[][] array2 = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
        };
        int[][] array3 = {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(knightBoardCapture(array3));
    }
}