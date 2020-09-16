package com.svenmalvik.spaceship;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.microsoft.azure.spring.cloud.feature.manager.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ConfigurationProperties
public class FeatureFlagController {

    private FeatureManager featureManager;

    public FeatureFlagController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @GetMapping(value = {"", "/", "/welcome"})
    public String mainWithParam(Model model) {
        model.addAttribute("Beta", featureManager.isEnabledAsync("featureManagement.beta").block());
        return "welcome";
    }

    @GetMapping("/beta")
    public String mainWithParam2(Model model) {
        model.addAttribute("Beta", featureManager.isEnabledAsync("featureManagement.beta").block());
        return "beta";
    }
}