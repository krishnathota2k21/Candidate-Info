package com.ivispl.candidate.controller;

import com.ivispl.candidate.dto.UserDto;
import com.ivispl.candidate.entity.Role;
import com.ivispl.candidate.entity.User;
import com.ivispl.candidate.reposiroty.RoleRepository;
import com.ivispl.candidate.reposiroty.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {
        log.info("loading home page:::::");
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> UserDto.builder().id(user.getId()).email(user.getEmail()).name(user.getName()).build()).collect(Collectors.toList());
        model.addAttribute("users", userDtos);
        return "view-users";
    }

    @GetMapping("/addUser")
    public String loadAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDto userDto) {
        userRepository.findByEmail(userDto.getEmail()).ifPresent(user1 -> new Exception(user1.getEmail()+" is already exist."));
        List<Role> roles = roleRepository.findAllByName("ROLE_USER");
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:viewUsers";
    }
}
