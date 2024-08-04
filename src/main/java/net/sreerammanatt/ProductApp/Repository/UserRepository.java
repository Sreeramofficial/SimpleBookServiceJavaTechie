package net.sreerammanatt.ProductApp.Repository;

import net.sreerammanatt.ProductApp.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
