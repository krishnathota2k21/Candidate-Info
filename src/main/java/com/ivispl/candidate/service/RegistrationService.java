package com.ivispl.candidate.service;

import com.ivispl.candidate.dto.UserDto;
import com.ivispl.candidate.entity.user.Role;
import com.ivispl.candidate.entity.user.User;
import com.ivispl.candidate.reposiroty.RoleRepository;
import com.ivispl.candidate.reposiroty.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ivispl.candidate.constants.Constants.ROLE_ADMIN;

/**
 * Registration service.
 */
@Service
@Slf4j
public class RegistrationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailService mailService;

    public RegistrationService(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, MailService mailService) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    /**
     * this method creates an admin user.
     * @param userDto user registration request details
     * @return true if saves successfully, false if failed.
     */
    public boolean createAdminUser(UserDto userDto) {
        List<Role> roles = roleRepository.findAllByName(ROLE_ADMIN);
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
        log.debug("successfully created admin user, by email: {}",  user.getEmail());
        mailService.sendEmail(user.getEmail());
        return user.getId()!=0;
    }

    /**
     * this method checks whether the email is already registered or not.
     * @param email mail which user wants to register with.
     * @return true if no one registered with this email else false.
     */
    public boolean isEmailAvailable(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.isEmpty();
    }
}
