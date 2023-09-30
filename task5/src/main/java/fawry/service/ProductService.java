package fawry.service;

import fawry.entity.Product;
import fawry.product.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    public ProductService(){
    }

    public void addProduct(String name , double price){
        if(name == null || name.isEmpty()){
            throw new RuntimeException("name can not be empty");
        }

        if(price < 0){
            throw new RuntimeException("price can not be less than zero");
        }
       ProductRepository.save(new Product(name , price));
    }

    public void deleteProduct(int id){
        if(id <= 0){
            throw new RuntimeException("id must be positive");
        }
        Product product = ProductRepository.get(id);
        ProductRepository.delete(product);
    }

    public Product getProduct(int id){
        if(id <= 0){
            throw new RuntimeException("id must be positive");
        }
        return ProductRepository.get(id);
    }

    public List<Product> getAllProduct(){
        return ProductRepository.getProducts();
    }
}
