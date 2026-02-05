import java.util.Scanner;
public class bt5 {
    public static void main(String[] args) {
        String[] books = {"Doremon", "Shin", "Nhin cai gi", "Harry Potter", "Doremon"};
        int[] quanti = {3, 7, 7, 1, 3};

        maxQuanti(books, quanti);
        minQuanti(books, quanti);
    }
    public static void maxQuanti(String[] books, int[] quanti) {
        if (books == null || quanti == null || books.length != quanti.length || books.length == 0) {
            System.out.println("Invalid input or empty arrays.");
            return;
        }

        int max = quanti[0];
        for (int i = 1; i < quanti.length; i++) {
            if (quanti[i] > max) {
                max = quanti[i];
            }
        }
        System.out.println("Sach co so luong nhieu nhat (" + max + "): ");
        for (int i = 0; i < quanti.length; i++) {
            if (quanti[i] == max) {
                System.out.println("- " + books[i]);
            }
        }
    }
    public static void minQuanti(String[] books, int[] quanti) {
        if (books == null || quanti == null || books.length != quanti.length || books.length == 0) {
            System.out.println("Invalid input or empty arrays.");
            return;
        }

        int min = quanti[0];
        for (int i = 1; i < quanti.length; i++) {
            if (quanti[i] < min) {
                min = quanti[i];
            }
        }

        System.out.println("Sach co so luong it nhat (" + min + "): ");
        for (int i = 0; i < quanti.length; i++) {
            if (quanti[i] == min) {
                System.out.println("- " + books[i]);
            }
        }
    }

}
