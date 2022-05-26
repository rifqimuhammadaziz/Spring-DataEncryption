package rifqimuhammadaziz.springdataencryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springdataencryption.entity.UserDetail;
import rifqimuhammadaziz.springdataencryption.repository.UserDetailRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDetailController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @PostMapping
    public UserDetail create(@RequestBody UserDetail user) {
        return userDetailRepository.save(user);
    }

    @GetMapping
    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }
}
