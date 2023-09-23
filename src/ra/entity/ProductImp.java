package ra.entity;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] productList = new Product[100];
//       Đặt sẵn 2 sản phẩm trong danh sách để dễ kiểm tra.
        productList[0] = new Product("S0", "Kẹo", 100, 202, 10, "Hot", true);
        productList[1] = new Product("S1", "Kẹo1", 100, 206, 10, "Hot", true);
        int indexProduct = 2;
        do {
            System.out.println("******Menu*******");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    System.out.println("Số lượng sản phẩm thêm vào: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Product productNew = new Product();
                        productNew.inputData(scanner);
                        productList[indexProduct] = productNew;
                        indexProduct++;
                    }
                    break;
                case 2:
                    System.out.println("Hiển thị thông tin sản phẩm: ");
                    for (int i = 0; i < indexProduct; i++) {
                        productList[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Lợi nhuận sản phẩm: ");
                    for (int i = 0; i < indexProduct; i++) {
                        System.out.printf("Phần tử có ID: %s - Lợi nhuận: %f\n", productList[i].getProductId(), productList[i].calProfit());
                    }
                    break;
                case 4:
                    Float[] priceSort = new Float[indexProduct];
                    for (int i = 0; i < indexProduct; i++) {
                        priceSort[i] = productList[i].calProfit();
                    }
                    Product temp = null;
                    for (int i = 0; i < indexProduct - 1; i++) {
                        for (int j = i + 1; j < indexProduct; j++) {
                            if (priceSort[i] < priceSort[j]) {
                                temp = productList[i];
                                productList[i] = productList[j];
                                productList[j]= temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong, nhấn số 2 để xem hiển thị");
                    break;
                case 5:
                    System.out.println("Nhập vào khoảng giá muốn xem thống kê:");
                    System.out.println("Giá từ: ");
                    float fromPrice = Float.parseFloat(scanner.nextLine());
                    System.out.println("Tới giá: ");
                    float toPrice = Float.parseFloat(scanner.nextLine());
                    boolean findRange = false;
                    System.out.printf("Các sản phẩm có giá từ %f tới %f là:\n", fromPrice, toPrice);
                    for (int i = 0; i < indexProduct; i++) {
                        if (productList[i].getExportPrice() >= fromPrice && productList[i].getExportPrice() <= toPrice) {
                            productList[i].displayData();
                            findRange = true;
                        }
                    }
                    if (!findRange) {
                        System.out.println("Không có sản phẩm nào trong khoảng giá đã chọn");
                    }
                    break;
                case 6:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String nameSearch = scanner.nextLine();
                    System.out.println("Đây là sản phẩm cần tìm: ");
                    for (int i = 0; i < indexProduct; i++) {
                        if (productList[i].getProductName().equals(nameSearch)) {
                            productList[i].displayData();
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Nhập vào mã sản phẩm cần Nhập:");
                    String newId = scanner.nextLine();
                    System.out.println("Nhập vào số lượng cần nhập thêm: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < indexProduct; i++) {
                        if (productList[i].getProductId().equals(newId)) {
                            productList[i].setQuantity(productList[i].getQuantity() + newQuantity);
                        }
                    }
                    System.out.println("Đã cập nhật xong, nhấn 2 để xem");
                    break;
                case 8:
                    System.out.println("Nhập vào mã sản phẩm cần Bán:");
                    String newId2 = scanner.nextLine();
                    System.out.println("Nhập vào số lượng cần bán: ");
                    int newQuantity2 = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < indexProduct; i++) {
                        if (productList[i].getProductId().equals(newId2)) {
                            productList[i].setQuantity(productList[i].getQuantity() - newQuantity2);
                        }
                    }
                    System.out.println("Đã cập nhật xong, nhấn 2 để xem");
                    break;
                case 9:
                    System.out.println("Nhập mã sản phẩm cần cập nhật trạng thái:");
                    String statusEditId = scanner.nextLine();
                    for (int i = 0; i < indexProduct; i++) {
                        if (productList[i].getProductId().equals(statusEditId)) {
                            productList[i].setStatus(!productList[i].getStatus());
                        }
                    }
                    System.out.println("Đã cập nhật xong, nhấn 2 để xem");
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        }
        while (true);
    }
}
