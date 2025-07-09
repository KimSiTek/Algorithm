package chap2;

public class mergeSortClass {
    public static int[] src;
    public static int[] tmp;

    public static void main(String[] args) {

        src = new int[]{1, 9, 8, 5, 4, 2, 3, 7, 6};
        tmp = new int[src.length];

        System.out.println("정렬 전:");
        printArray(src);

        mergeSort(src);

        System.out.println("정렬 후:");
        printArray(src);
    }
    public static void mergeSort(int [] S) {

       int n = S.length;

       if(n <= 1) {
           return;
       }

       int h = n / 2;
       int m = n - h; // 오른쪽 배열 V의 길이 m.

       int [] U = new int [h]; // U가 왼쪽 배열임.
       int [] V = new int [m]; // V가 오른쪽 배열임.

       for(int i = 0; i < h; i++) {
           U[i] = S[i];
       }

       for(int i = 0; i < m; i++) {
           V[i] = S[h+i];
       }

       mergeSort(U);
       mergeSort(V);
       merge(h,m,U,V,S); // 이 두개의 나눠진 배열을 합치는 메서드임. combine 단계.
    }

    public static void merge(int h, int m, int [] U, int [] V, int [] S)
    {
        int i = 0, k = 0, j = 0;
        // 여기서 각각 i,j,k는 배열 U,V,S를 찍고 다니는 index임.

        while(i < h && j < m) // 배열 U,V를 아직 모두 다 못 돌았을 때.
        {
            if (U[i] < V[j]) { // 배열 돌며 비교하는데, U 요소가 더 작으면 U 요소 하나씩 증가시키면서 S배열에 저장하면 됨.
                S[k] = U[i];
                i++;
            } else { // 그게 아니면, V 요소를 배열에 저장.
                S[k] = V[j];
                j++;
            }
            k++;
        }

        while(i < h) // 배열 V는 다 돌고, 배열 U만 아직 다 못 돌았을 때
        {
            S[k++] = U[i++]; // S의 나머지는 U의 나머지들로 다 채운다.
        }

        while(j < m) // 배열 U는 다 돌고, 배열 V만 아직 다 못 돌았을 때
        {
            S[k++] = V[j++]; // S의 나머지는 V의 나머지들로 다 채운다.
        }
    }

    public static void printArray(int[] a) {
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
