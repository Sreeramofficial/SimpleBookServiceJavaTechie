package net.sreerammanatt.ProductApp.Service;


import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Entity.User;
import net.sreerammanatt.ProductApp.Enums.Exceptions;
import net.sreerammanatt.ProductApp.Exception.UserException;
import net.sreerammanatt.ProductApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserException(Exceptions.USER_NOT_FOUND);

        }
        return user.get();
    }

    public String saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserException(Exceptions.DUPLICATE_MAIL);
        }

        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("sorry error occurred!!");

        }
        return user.getName() + " added!!!";


    }

    //pagination method for user added
    public List<User> getUserWithSorting() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by("name").
                ascending()
                .and(Sort.by("id")
                        .ascending()));
        return userRepository.findAll(pageable).getContent();
    }

}
