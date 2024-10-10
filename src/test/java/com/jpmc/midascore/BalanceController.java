package com.jpmc.midascore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.repository.UserRepository;

@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Autowired 
    private UserRepository userRepository; 

    @GetMapping
    public Balance getBalance(@RequestParam long userId) {
        UserRecord user = userRepository.findById(userId); 
        if (user != null) {
            return new Balance(user.getBalance());
        }
        else {
            return new Balance(0);
        }
    }
}
