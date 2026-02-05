import java.util.Scanner;
public class bt3 {

    public static int deleteBook(int arr[], int n, int id) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == id) {
                for (int j = i; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[n - 1] = 0;
                return n - 1;
            }
        }
        // nếu không tìm thấy thì không thay đổi độ dài
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = {123, 456, 789};
        int lenO = books.length;

        while (lenO != 0) {
            System.out.print("kho sach hien tai (" + lenO + " cuon): ");
            for (int i = 0; i < lenO; i++) {
                if (books[i] != 0) {
                    System.out.print(books[i] + " ");
                }
            }
            System.out.println();

            System.out.print("Nhap ma sach can xoa (0 de thoat): ");
            int id = sc.nextInt();

            if (id == 0) {
                break;
            }
            int newLen = deleteBook(books, lenO, id);
            if (newLen == lenO) {
                System.out.println("Không tìm thấy id " + id + ".");
            } else {
                lenO = newLen;
                System.out.println("Đã xóa bookId " + id + ".");
                if (lenO == 0) {
                    System.out.println("Mảng rỗng!");
                    break;
                }
            }
        }
    }
}
