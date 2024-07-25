package net.sreerammanatt.ProductApp.Repository;

import net.sreerammanatt.ProductApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
