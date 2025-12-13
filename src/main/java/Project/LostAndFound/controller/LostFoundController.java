// src/main/java/Project/LostAndFound/controller/LostFoundController.java
package Project.LostAndFound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Project.LostAndFound.model.LostItem;
import Project.LostAndFound.model.FoundItem;
import Project.LostAndFound.repository.LostItemRepository;
import Project.LostAndFound.repository.FoundItemRepository;

@Controller
@RequestMapping("/report")
public class LostFoundController {

    private final LostItemRepository lostItemRepository;
    private final FoundItemRepository foundItemRepository;

    public LostFoundController(LostItemRepository lostItemRepository,
                               FoundItemRepository foundItemRepository) {
        this.lostItemRepository = lostItemRepository;
        this.foundItemRepository = foundItemRepository;
    }

    @GetMapping("/lost")
    public String showLostReportForm(Model model) {
        model.addAttribute("lostItem", new LostItem());
        return "report-lost";
    }

    @PostMapping("/lost")
    public String submitLostReport(@ModelAttribute LostItem lostItem) {
        lostItemRepository.save(lostItem);
        return "redirect:/?success=lost";
    }

    @GetMapping("/found")
    public String showFoundReportForm(Model model) {
        model.addAttribute("foundItem", new FoundItem());
        return "report-found";
    }

    @PostMapping("/found")
    public String submitFoundReport(@ModelAttribute FoundItem foundItem) {
        foundItemRepository.save(foundItem);
        return "redirect:/?success=found";
    }
}