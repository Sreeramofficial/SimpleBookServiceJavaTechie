package net.sreerammanatt.ProductApp.Service;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Entity.User;
import net.sreerammanatt.ProductApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void saveUser(User user) {

        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("sorry error occurred!!");

        }

    }
}
