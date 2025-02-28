package com.womack.orderprocessingservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderSubmissionController {
    private final Logger LOG = LoggerFactory.getLogger(OrderSubmissionController.class);

    @Value("${ordersworkflow-url}")
    private String serviceUrl;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/submitOrder")
    public String submitOrder() {
        LOG.error("URL: {}", serviceUrl);
        try {
            restTemplate.postForEntity(serviceUrl + "submitOrder", null, String.class);
        } catch (Exception e) {
            //DO Nothing
        }
        return "redirect:/";
    }
}