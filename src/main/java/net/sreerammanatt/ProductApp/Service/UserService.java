package net.sreerammanatt.ProductApp.Service;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Entity.User;
import net.sreerammanatt.ProductApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //pagination method for user added
    public List<User> getUserWithSorting() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by("name").
                ascending()
                .and(Sort.by("id")
                        .ascending()));
        return userRepository.findAll(pageable). getContent();
    }

}
