package com.demo.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * Order service - demonstrates SAME bug pattern appearing in different files
 * 
 * This shows how Sonar groups issues by pattern, not by file
 */
@Service
public class OrderService {

    /**
     * Get customer name length for order processing
     * 
     * ❌ BUG: Same NullPointerException pattern as UserService
     * 
     * Sonar will detect this is the SAME pattern and group them together
     */
    public int getCustomerNameLength(User customer) {
        return customer.getName().length(); // ❌ NPE risk - SAME PATTERN
    }

    /**
     * Get order recipient name
     * 
     * ❌ BUG: Same pattern - duplicated across services
     */
    public String getRecipientName(User recipient) {
        return recipient.getName().trim(); // ❌ NPE risk - SAME PATTERN
    }

    /**
     * Validate order customer
     * 
     * ❌ BUG: No null check before accessing properties
     */
    public boolean isValidCustomer(User customer) {
        return customer.getName().length() > 0 
            && customer.getEmail().contains("@"); // ❌ Multiple NPE risks
    }
}
