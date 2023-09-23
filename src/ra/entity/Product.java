package ra.entity;

import java.util.Scanner;

public class Product {
//    a - Thuộc tính
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private String descriptions;
    private Boolean status;
//    b- Các constructor
    public Product() {
    }
    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, String descriptions, Boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }
//    c- Các phương thức get/set
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getImportPrice() {
        return importPrice;
    }
    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }
    public float getExportPrice() {
        return exportPrice;
    }
    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
//    d- inputData, displayData, calProfit
//    inputData
    public void inputData(Scanner scanner){
        System.out.println("Nhập thông tin sản phẩm, mã sản phẩm:");
        this.productId = scanner.nextLine();
        System.out.println("Tên sản phẩm:");
        this.productName = scanner.nextLine();
        System.out.println("Giá nhập của sản phẩm:");
        this.importPrice = Float.parseFloat((scanner.nextLine()));
        System.out.println("Giá bán của sản phẩm:");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Số lượng sản phẩm:");
        this.quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Mô tả sản phẩm:");
        this.descriptions = scanner.nextLine();
        System.out.println("Trang thái sản phẩm:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
//    calProfit
    public float calProfit(){
        return this.exportPrice - this.importPrice;
    }
//    displayData
    public void displayData(){
        System.out.printf("ID là: %s - Tên: %s - Giá Nhập: %f - Giá bán: %f - Lợi nhuận: %f \n",this.productId,this.productName,this.importPrice,this.exportPrice,calProfit());
        System.out.printf("Số lượng: %d - Mô tả: %s - Trạng thái: %b\n",this.quantity,this.descriptions,this.status);
    }

}
