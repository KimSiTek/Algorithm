package july9th;
import java.util.Scanner;

public class BOJ11382 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 3개를 공백을 사이에 두고 입력하시오");

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int sum = num1 + num2 + num3;

        System.out.println("입력한 값 3개의 합은: " + sum);
    }
}
