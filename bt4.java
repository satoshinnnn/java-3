import java.util.Scanner;
public class bt4 {
    public static void bubleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length -1) {
                System.out.print(", ");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,9,8,5,3,4,1};

        System.out.print("Mang truoc khi sap xep: ");
        display(arr);

        System.out.println();

        bubleSort(arr);
        System.out.print("Mang sau khi sap xep: ");
        display(arr);
    }
}
