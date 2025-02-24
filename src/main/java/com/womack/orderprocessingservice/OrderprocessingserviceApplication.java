package com.womack.orderprocessingservice;

import com.womack.orderprocessingservice.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class OrderprocessingserviceApplication {
	private static final Random random = new Random();

	public static void main(String[] args) {
		SpringApplication.run(OrderprocessingserviceApplication.class, args);
	}

	@RestController
	class Orderprocessingserviceontroller {
		private final Logger LOG = LoggerFactory.getLogger(Orderprocessingserviceontroller.class);

		@PostMapping("/processPayment")
		public String processPayment(@RequestBody Payment payment) throws Exception {
			if (shouldSucceed()) {
				return "Payment Successful";
			} else {
				throw new Exception("Customer is too broke");
			}
		}

		@PostMapping("/checkInventory")
		public String checkInventory(@RequestBody List<OrderItem> orderItems) throws Exception {
			if (shouldSucceed()) {
				return "Inventory Check Passed";
			} else {
				throw new Exception("We don't got no more of them");
			}
		}

		@PostMapping("/shipPackage")
		public String shipPackage(@RequestBody List<OrderPackage> orderPackages) throws Exception {
			if (shouldSucceed()) {
				return "Package Shipped Successfully";
			} else {
				throw new Exception("Package fell off truck");
			}
		}

		@PostMapping("/notifyCustomer")
		public String notifyCustomer(@RequestBody Customer customer) throws Exception {
			if (shouldSucceed()) {
				return "Customer Successfully Notified";
			} else {
				throw new Exception("Customer blocked our notifications");
			}
		}

		@GetMapping("/")
		public String homePage() {
			return "Order processing service application";
		}
	}

	private boolean shouldSucceed() {
		int randomNumber = random.nextInt(100);
		return randomNumber < 80;
	}
}
