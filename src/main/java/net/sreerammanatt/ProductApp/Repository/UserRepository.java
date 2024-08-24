package net.sreerammanatt.ProductApp.Repository;

import net.sreerammanatt.ProductApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> , JpaRepository<User,Long> {
}
