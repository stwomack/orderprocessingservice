package com.womack.orderprocessingservice.controllers;

import com.womack.orderprocessingservice.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class OrderProcessingServiceController {
    private static final Random random = new Random();
    private final Logger LOG = LoggerFactory.getLogger(OrderProcessingServiceController.class);

    @PostMapping("/processPayment")
    public String processPayment(@RequestBody Payment payment) throws Exception {
        LOG.info("Processing Payment");
        if (shouldSucceed()) {
            return "Payment Successful";
        } else {
            throw new Exception("Customer is too broke");
        }
    }

    @PostMapping("/checkInventory")
    public String checkInventory(@RequestBody List<OrderItem> orderItems) throws Exception {
        LOG.info("Checking Inventory");
        if (shouldSucceed()) {
            return "Inventory Check Passed";
        } else {
            throw new Exception("We don't got no more of them");
        }
    }

    @PostMapping("/shipPackage")
    public String shipPackage(@RequestBody List<OrderPackage> orderPackages) throws Exception {
        LOG.info("Shipping Package");
        if (shouldSucceed()) {
            return "Package Shipped Successfully";
        } else {
            throw new Exception("Package fell off truck");
        }
    }

    @PostMapping("/notifyCustomer")
    public String notifyCustomer(@RequestBody Customer customer) throws Exception {
        LOG.info("Notifying Customer");
        if (shouldSucceed()) {
            return "Customer Successfully Notified";
        } else {
            throw new Exception("Customer blocked our notifications");
        }
    }

    private boolean shouldSucceed() {
        int randomNumber = random.nextInt(100);
        return randomNumber < 30;
    }
}