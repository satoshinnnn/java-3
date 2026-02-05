import java.util.Scanner;

public class bt1 {

    public static int[] addBook(int n) {
        Scanner sc = new Scanner(System.in);

        int[] codes = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ma sach so " + (i+1) +": ");
            codes[i] = sc.nextInt();
        }
        return codes;
    }

    public static void displayBook(int[] codes) {
        for (int i = 0; i < codes.length; i++) {
            System.out.print(codes[i]);
            if (i < codes.length - 1) {
                System.out.print(", ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sach can quan ly: ");
        int quanti = sc.nextInt();
        System.out.println("Nhap ma so cho " + quanti + " cuon sach: ");

        int [] books = addBook(quanti);

        System.out.println("--- KET QUA ---");
        System.out.print("Danh sach ma sach: ");
        displayBook(books);
    }
}