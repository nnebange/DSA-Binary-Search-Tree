package com.neba.bst.controller;

import com.neba.bst.service.BSTService;
import com.neba.bst.util.BSTNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BSTController {

    private final BSTService service;

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        String json = service.getBalancedBSTAsJson(numbers);
        model.addAttribute("json", json);
        return "show-json";
    }
      

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", service.getAllTrees());
        return "previous-trees";
    }
}
