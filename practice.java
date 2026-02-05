import java.util.Scanner;

public class practice {
    static int CAPACITY = 100;
    static int[] ids = new int[CAPACITY];
    static String[] titles = new String[CAPACITY];
    static int[] quantities = new int[CAPACITY];
    static int size = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleData();
        while (true) {
            showMenu();
            int choice = readInt("Lua chon (1-7): ");
            switch (choice) {
                case 1: displayList(); break;
                case 2: addBook();break;
                case 3: updateQty(); break;
                case 4: delete();
                case 5: searchByKeyword(); break;
                case 6: sortQty(); break;
                case 7:
                    System.out.println("Ket thuc truong tinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, chon lai");
            }
        }
    }
    static void sortQty() {
        for (int i = 0; i < size - 1; i ++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (quantities[j] > quantities[j+1]) {
                    int tempQty = quantities[j];
                    quantities[j] = quantities[j+1];
                    quantities[j+1] = tempQty;

                    String tempTitle = titles[j];
                    titles[j] = titles[j+1];
                    titles[j+1] = tempTitle;

                    int tempId = ids[j];
                    ids[j] = ids[j+1];
                    ids[j+1] = tempId;
                }
            }
        }
    }
    static void searchByKeyword() {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.print("Nhập từ khóa tìm kiếm (tên sách): ");
        String kw = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        System.out.printf("%-6s | %-40s | %-8s%n", "Mã", "Tên sách", "Số lượng");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < size; i++) {
            if (titles[i] != null && titles[i].toLowerCase().contains(kw)) {
                System.out.printf("%-6d | %-40s | %-8d%n", ids[i], titles[i], quantities[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy kết quả nào phù hợp.");
    }

    static void delete() {
        int id = readInt("Nhap id cua sach can xoa: ");
        if (finIndexById(id) == -1) {
            System.out.println("Id khong ton tai. Cap nhat that bai!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (ids[i] == id) {
                for (int j = i; j < size - 1; j++) {
                    ids[j] = ids[j + 1];
                    titles[j] = titles[j+1];
                    quantities[j] = quantities[j+1];
                }
            }
        }
        size --;
    }
    static void updateQty() {
        int id = readInt("Nhap id sach can update so luong");
        if(finIndexById(id) != -1) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (ids[i] == id) {
                    index = i;
                    break;
                }
            }
            System.out.print("Nhap ten sach cap nhat: ");
            String title= sc.nextLine().trim();
            int qty = readInt("Nhap so luong can cap nhat:" );
            ids[index] = id;
            titles[index] = title;
            quantities[index] = qty;
        } else {
            System.out.println("Ma da ton tai, cap nhat that bai!");
        }
    }

    static void displayList() {
        if (size == 0) {
            System.out.println("Sang sach rong");
            return;
        }
        System.out.printf("%-6s | %-40s | %-8s%n", "Mã", "Tên sách", "Số lượng");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < size; i++) {
            System.out.printf("%-6d | %-40s | %-8d%n", ids[i], titles[i], quantities[i]);
        }
    }
    static void addBook() {
        if (size >= CAPACITY) {
            System.out.println("Không thể thêm: mảng đã đầy.");
            return;
        }
        int id = readInt("Nhập mã sách (số nguyên): ");
        if (finIndexById(id) != -1) {
            System.out.println("Ma da ton tai, them that bai!");
        } else {
            System.out.println("Nhap ten sach: ");
            String name = sc.nextLine().trim();
            int qty = readInt("Nhập số lượng: ");
            ids[size] = id;
            titles[size] = name;
            quantities[size] = qty;
            size ++;
        }
    }
    static int finIndexById(int id) {
        for(int i = 0; i < size; i ++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }
//
    static void showMenu() {
        System.out.println("==== QUẢN LÝ THƯ VIỆN (MẢNG SONG SONG) ====");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm sách mới");
        System.out.println("3. Cập nhật số lượng (theo mã sách)");
        System.out.println("4. Xóa sách (theo mã sách)");
        System.out.println("5. Tìm kiếm theo từ khóa tên sách");
        System.out.println("6. Sắp xếp theo số lượng (giảm dần)");
        System.out.println("7. Thoát");
    }
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
    }
    static void addSampleData() {
        // ví dụ ban đầu
        ids[0] = 101; titles[0] = "Lập trình Java cơ bản"; quantities[0] = 5;
        ids[1] = 102; titles[1] = "Cấu trúc dữ liệu và giải thuật"; quantities[1] = 3;
        ids[2] = 103; titles[2] = "Cơ sở dữ liệu"; quantities[2] = 7;
        size = 3;
    }

}
