package Project.LostAndFound.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Login - UEP Lost & Found Hub");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "Register - UEP Lost & Found Hub");
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        model.addAttribute("pageTitle", "Dashboard - UEP Lost & Found Hub");
        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin);
        return "dashboard";
    }

    @GetMapping("/my-items")
    public String myItems(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        model.addAttribute("pageTitle", "My Items - UEP Lost & Found Hub");
        model.addAttribute("username", username);
        return "my-items";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        model.addAttribute("pageTitle", "My Profile - UEP Lost & Found Hub");
        model.addAttribute("username", username);
        return "profile";
    }
}