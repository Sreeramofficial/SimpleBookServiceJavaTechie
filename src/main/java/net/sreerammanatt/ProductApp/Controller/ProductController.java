package net.sreerammanatt.ProductApp.Controller;


import net.sreerammanatt.ProductApp.Entity.Product;
import net.sreerammanatt.ProductApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);


    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveAllProduct(products);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.DeleteProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);

    }


}
