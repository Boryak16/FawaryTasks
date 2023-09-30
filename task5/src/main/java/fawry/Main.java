package fawry;

import fawry.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        service.addProduct("ProductF" , 60);
        service.addProduct("productL" , 10);

    }
}
