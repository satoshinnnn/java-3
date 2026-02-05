import java.util.Scanner;
public class bt2 {

    public static int searchBooks(String[] arr, String search) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && arr[i].equalsIgnoreCase(search)) {
                    return i;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] books = {"Doremon", "Shin", "Nhin cai gi"};

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách cần tìm: ");
        String book = sc.nextLine().trim();

        int index = searchBooks(books, book);
        if(index != -1) {
            System.out.println("Tim thay sach '" + book + "' tai vi tri so: " + index);
        } else {
            System.out.println("Sach khong ton tai trong thu vien");
        }
    }
}
