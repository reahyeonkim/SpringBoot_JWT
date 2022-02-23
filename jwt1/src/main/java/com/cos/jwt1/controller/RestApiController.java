package com.cos.jwt1.controller;

import com.cos.jwt1.config.auth.PrincipalDetails;
import com.cos.jwt1.domain.User;
import com.cos.jwt1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class RestApiController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("home")
    public String home() {
        return "<h1>home</h1>";
    }

    @GetMapping("user")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principal:" + principal.getUser().getId());
        System.out.println("principal:" + principal.getUser().getUsername());
        System.out.println("principal:" + principal.getUser().getPassword());

        return "<h1>user</h1>";
    }

    @GetMapping("manager/reports")
    public String reports() {
        return "<h1>reports</h1>";
    }

    @GetMapping("admin/user")
    public List<User> user() {
        return userRepository.findAll();
    }
    @PostMapping("join")
    public String join(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "회원가입 완료";
    }
}
