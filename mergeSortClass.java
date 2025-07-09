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

       if(n<=1){
           return;
       }

       int h = n / 2;
       int m = n - h;

       int [] U = new int [h];
       int [] V = new int [m];

       for(int i = 0; i < h; i++) {
           U[i] = S[i];
       }

       for(int i = 0; i < m; i++) {
           V[i] = S[h+i];
       }

       mergeSort(U);
       mergeSort(V);
       merge(h,m,U,V,S);
    }

    public static void merge(int h, int m, int [] U, int [] V, int [] S)
    {
        int i = 0, k = 0, j = 0;

        while(i < h && j < m) {
            if (U[i] < V[j]) {
                S[k] = U[i];
                i++;
            } else {
                S[k] = V[j];
                j++;
            }
            k++;
        }

        while(i < h) {
            S[k++] = U[i++];
        }

        while(j < m) {
            S[k++] = V[j++];
        }
    }

    public static void printArray(int[] a) {
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
