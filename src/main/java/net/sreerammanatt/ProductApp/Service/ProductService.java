package net.sreerammanatt.ProductApp.Service;


import net.sreerammanatt.ProductApp.Entity.Product;
import net.sreerammanatt.ProductApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> saveAllProduct(List<Product> product) {
        return productRepo.saveAll(product);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    public String   DeleteProductById(int id) {
        productRepo.deleteById(id);
        return "product removed " + id;
    }

    public Product updateProduct(Product product) {
        Optional<Product> existingProduct = productRepo.findById(product.getId());
        if (existingProduct.isPresent()) {
            existingProduct.get().setName(product.getName());
            existingProduct.get().setStockAvailable(product.getStockAvailable());
            existingProduct.get().setPrice(product.getPrice());


        }
        return productRepo.save(existingProduct.get());

    }
}
