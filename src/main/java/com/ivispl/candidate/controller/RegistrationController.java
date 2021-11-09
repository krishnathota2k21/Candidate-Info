package com.ivispl.candidate.controller;

import com.ivispl.candidate.dto.UserDto;
import com.ivispl.candidate.entity.user.User;
import com.ivispl.candidate.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * this controller is used to register the user(Admin by default)
 */
@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    /**
     * this method creates a new admin, who can add sub user under their organization.
     * @param userDto Admin user details.
     * @param model model object to pass success message.
     * @return success/error message to the view.
     */
    @PostMapping
    public String registerNewUser(@ModelAttribute UserDto userDto, Model model ) {
        try{
            boolean success = registrationService.createAdminUser(userDto);
            if (success) model.addAttribute("successMessage", "New user created successfully.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            log.error("error occurred while creating a new user.", e);
        }
        return "registration";
    }

    /**
     * this method loads the user registration page.
     * @param model model
     * @return registration view.
     */
    @GetMapping
    public String loadRegistrationView(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    /**
     * this method search for the availability of the email, used for registration.
     * @param email email address used for registration
     * @return it's available or not.
     */
    @GetMapping("/search")
    @ResponseBody
    public boolean isEmailAvailable(@RequestParam("email") String email) {
        return registrationService.isEmailAvailable(email);
    }
}
