package chap2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A2_김시혁 {

    static int n, W;
    static int[] w, p;
    static String[] include;
    static String[] bestSet;
    static int maxProfit = 0;
    static int numBest = -1;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("instance.txt"));

            n = sc.nextInt();
            W = sc.nextInt();

            w = new int[n];
            p = new int[n];
            include = new String[n];
            bestSet = new String[n];

            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            sc.close();

            knapsack(-1, 0, 0);

            System.out.print("Optimal solution: ");
            for (int i = 0; i < n; i++) {
                System.out.print((bestSet[i] != null && bestSet[i].equals("yes") ? 1 : 0) + " ");
            }
            System.out.println("\nMaximum profit: " + maxProfit);

        } catch (FileNotFoundException e) {
            System.out.println("Error: instance.txt file not found.");
        }
    }

    public static void knapsack(int i, int profit, int weight) {
        if (weight <= W && profit > maxProfit) {
            maxProfit = profit;
            numBest = i;
            bestSet = include.clone();
        }

        if (promising(i, profit, weight)) {
            if (i + 1 < n) {
                include[i + 1] = "yes";
                knapsack(i + 1, profit + p[i + 1], weight + w[i + 1]);
                include[i + 1] = "no";
                knapsack(i + 1, profit, weight);
            }
        }
    }

    public static boolean promising(int i, int profit, int weight) {
        if (weight >= W) return false;

        int j = i + 1;
        int totWeight = weight;
        float bound = profit;

        while (j < n && totWeight + w[j] <= W) {
            totWeight += w[j];
            bound += p[j];
            j++;
        }

        if (j < n) {
            bound += (float)(W - totWeight) * p[j] / w[j];
        }

        return bound > maxProfit;
    }
}
