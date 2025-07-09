package july9th;

import java.util.Scanner;

public class BOJ1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long ans = 2;

        for (int i = 2; i <= n; i++) {
            ans *= 3; // 점화식: an = 3 * an-1
        }

        System.out.println(ans);
    }
}
