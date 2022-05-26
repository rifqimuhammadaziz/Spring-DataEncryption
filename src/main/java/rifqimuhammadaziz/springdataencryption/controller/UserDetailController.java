package rifqimuhammadaziz.springdataencryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springdataencryption.entity.UserDetail;
import rifqimuhammadaziz.springdataencryption.repository.UserDetailRepository;

@RestController
@RequestMapping("/api/users")
public class UserDetailController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @PostMapping
    public UserDetail create(@RequestBody UserDetail user) {
        return userDetailRepository.save(user);
    }
}
