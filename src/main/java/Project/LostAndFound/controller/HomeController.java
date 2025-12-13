// src/main/java/Project/LostAndFound/controller/HomeController.java
package Project.LostAndFound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Project.LostAndFound.model.LostItem;
import Project.LostAndFound.model.FoundItem;
import Project.LostAndFound.repository.LostItemRepository;
import Project.LostAndFound.repository.FoundItemRepository;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private final LostItemRepository lostItemRepository;
    private final FoundItemRepository foundItemRepository;

    public HomeController(LostItemRepository lostItemRepository,
                          FoundItemRepository foundItemRepository) {
        this.lostItemRepository = lostItemRepository;
        this.foundItemRepository = foundItemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Sample data for demonstration (replace with database queries)
        List<LostItem> recentLostItems = Arrays.asList(
                new LostItem("Earrings", "Jewelry", "Gold earrings with floral design",
                        "Library", java.time.LocalDate.now().minusDays(1), "marcela@uep.edu"),
                new LostItem("Flower and gold...", "Jewelry", "Flower shaped gold accessory",
                        "Room 203", java.time.LocalDate.now().minusDays(2), "student@uep.edu")
        );

        List<FoundItem> recentFoundItems = Arrays.asList(
                new FoundItem("Wallet", "Personal", "Black leather wallet",
                        "Cafeteria", java.time.LocalDate.now().minusDays(1), "finder@uep.edu"),
                new FoundItem("Calculator", "Electronics", "Scientific calculator",
                        "Computer Lab", java.time.LocalDate.now(), "student2@uep.edu")
        );

        // Success stories
        List<String[]> successStories = Arrays.asList(
                new String[]{"earrings", "Successfully returned to owner", "marcela", "Nov 26, 2025"},
                new String[]{"wallet", "Successfully returned to owner", "marcela", "Nov 26, 2025"},
                new String[]{"CALCULATOR", "Successfully returned to owner", "marcela", "Nov 26, 2025"}
        );

        // Statistics
        long lostItemsCount = lostItemRepository.count();
        long foundItemsCount = foundItemRepository.count();
        long claimedItemsCount = lostItemRepository.countByStatus("CLAIMED");
        long communityMembers = 156L; // Sample data
        int recoveryRate = (int) ((claimedItemsCount * 100) / (lostItemsCount > 0 ? lostItemsCount : 1));

        model.addAttribute("recentLostItems", recentLostItems);
        model.addAttribute("recentFoundItems", recentFoundItems);
        model.addAttribute("successStories", successStories);
        model.addAttribute("lostItemsCount", lostItemsCount);
        model.addAttribute("foundItemsCount", foundItemsCount);
        model.addAttribute("claimedItemsCount", claimedItemsCount);
        model.addAttribute("communityMembers", communityMembers);
        model.addAttribute("recoveryRate", recoveryRate);

        return "index";
    }

    @GetMapping("/lost-items")
    public String lostItems(Model model) {
        List<LostItem> lostItems = lostItemRepository.findAll();
        model.addAttribute("lostItems", lostItems);
        return "lost-items";
    }

    @GetMapping("/found-items")
    public String foundItems(Model model) {
        List<FoundItem> foundItems = foundItemRepository.findAll();
        model.addAttribute("foundItems", foundItems);
        return "found-items";
    }

    @GetMapping("/statistics")
    public String statistics(Model model) {
        // Calculate statistics
        long lostItemsCount = lostItemRepository.count();
        long foundItemsCount = foundItemRepository.count();
        long claimedItemsCount = lostItemRepository.countByStatus("CLAIMED");
        int recoveryRate = (int) ((claimedItemsCount * 100) / (lostItemsCount > 0 ? lostItemsCount : 1));

        model.addAttribute("lostItemsCount", lostItemsCount);
        model.addAttribute("foundItemsCount", foundItemsCount);
        model.addAttribute("claimedItemsCount", claimedItemsCount);
        model.addAttribute("recoveryRate", recoveryRate);

        return "statistics";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}