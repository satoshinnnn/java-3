import java.util.Scanner;

public class bt6 {
    public static int[] merge(int a[], int b[]) {
        if(a == null) {
            a = new int[0];
        }
        if (b == null) {
            b = new int[0];
        }

        int c[] = new int[a.length+b.length];

        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        sort(c);
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i+1]) {
                deleteSame(c);
            }
        }
        return c;
    }
    public static void deleteSame(int c[]) {
        for (int i =0; i < c.length - 1; i++) {
            if(c[i]==c[i+1]) {
                for (int j = i; j < c.length - 1; j++) {
                    c[j] = c[j+1];
                    c[j+1] = 0;
                }
            }
        }
        c[c.length-1] = 0;
    }
    public static void display(int[] c) {
        for (int x: c) {
            if (x != 0) {
                System.out.print(x + " ");
            }
        }
    }
    public static void sort(int[] c) {
        for (int i = 0; i < c.length -1; i++) {
            for (int j = 0; j < c.length -1 - i; j++) {
                if (c[j] > c[j+1]) {
                    int temp = c[j];
                    c[j] = c[j+1];
                    c[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {3,1,3,2,2,1,1,7,7,1,1};
        int[] b = {4,5,6,6,8,7,7,8,9,9};
        int[] c = merge(a,b);
        System.out.print("Mang a: ");
        display(a);
        System.out.println();
        System.out.print("Mang b: ");
        display(b);
        System.out.println();
        System.out.print("Mang gop: ");
        display(c);
    }
}