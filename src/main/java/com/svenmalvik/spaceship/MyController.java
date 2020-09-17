package com.svenmalvik.spaceship;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// Azure /////////////////////////////////////////////////
import com.microsoft.azure.spring.cloud.feature.manager.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@ConfigurationProperties
public class MyController {

    @Autowired
    private MessageProperties properties;
    private FeatureManager featureManager;

    public MyController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @GetMapping(value = {"", "/", "/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/beta")
    public String beta() {
        return "beta";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("beta", featureManager.isEnabledAsync("featureManagement.beta").block());
        model.addAttribute("message", properties.getMessage());
    }
}