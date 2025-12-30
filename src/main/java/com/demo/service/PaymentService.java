package com.demo.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * Payment service - THIRD file with the same bug pattern
 * 
 * KEY LEARNING: When Sonar finds the same pattern in 3 files,
 * fixing the pattern ONCE teaches you how to fix ALL occurrences
 */
@Service
public class PaymentService {

    /**
     * Get payer name length for payment processing
     * 
     * ❌ BUG: Same NullPointerException pattern (3rd occurrence!)
     * 
     * Sonar Rule: S2259
     */
    public int getPayerNameLength(User payer) {
        return payer.getName().length(); // ❌ NPE risk - PATTERN REPEATED
    }

    /**
     * Format payer name for receipt
     * 
     * ❌ BUG: Same pattern - no null safety
     */
    public String formatPayerName(User payer) {
        return "Payment by: " + payer.getName().toUpperCase(); // ❌ NPE risk
    }

    /**
     * Process payment with payer info
     * 
     * ❌ BUG: Multiple null pointer risks in one method
     */
    public String processPayment(User payer, double amount) {
        String name = payer.getName().trim(); // ❌ NPE
        String email = payer.getEmail().toLowerCase(); // ❌ NPE
        return String.format("Processed $%.2f for %s (%s)", amount, name, email);
    }
}
