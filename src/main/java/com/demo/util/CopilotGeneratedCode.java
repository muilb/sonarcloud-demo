package com.demo.util;

import com.demo.model.User;

/**
 * 🎯 DEMO FILE: Code that Copilot might generate
 * 
 * This file shows REALISTIC examples of code that GitHub Copilot
 * generates when given common prompts. Each method demonstrates
 * how Sonar catches issues that Copilot misses.
 * 
 * ═══════════════════════════════════════════════════════════════
 * SCENARIO: Developer types comment, Copilot auto-completes
 * ═══════════════════════════════════════════════════════════════
 */
public class CopilotGeneratedCode {

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate method to check user password"
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// check if password is correct"
     * 
     * ❌ VULNERABILITY: S2068 - Hardcoded password
     * ❌ BUG: S2259 - Null pointer dereference (input could be null)
     */
    public boolean checkPassword(String input) {
        String correctPassword = "admin123"; // ❌ Hardcoded!
        return input.equals(correctPassword); // ❌ NPE if input is null
    }

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate method to validate email"
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// validate email address"
     * 
     * ❌ BUG: S2259 - No null check
     * ❌ CODE SMELL: Weak validation logic
     */
    public boolean validateEmail(String email) {
        return email.contains("@") && email.contains("."); // ❌ NPE risk
    }

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate method to get user info string"
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// format user info as string"
     * 
     * ❌ BUG: S2259 - Multiple null pointer risks
     */
    public String getUserInfo(User user) {
        return user.getName() + " - " + user.getEmail(); // ❌ NPE risks
    }

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate method to connect to database"
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// create database connection"
     * 
     * ❌ VULNERABILITY: S2068 - Hardcoded credentials
     * ❌ VULNERABILITY: Credentials in code
     */
    public String createConnection() {
        String host = "localhost";
        String user = "root";
        String password = "password123"; // ❌ Hardcoded!
        return "jdbc:mysql://" + host + "?user=" + user + "&password=" + password;
    }

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate method to process user list"
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// process list of users"
     * 
     * ❌ BUG: S2259 - No null checks
     * ❌ CODE SMELL: Could throw NPE in loop
     */
    public void processUsers(java.util.List<User> users) {
        for (User user : users) { // ❌ NPE if users is null
            System.out.println(user.getName().toUpperCase()); // ❌ NPE if name is null
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // PROMPT: "// Generate admin check method"  
    // ═══════════════════════════════════════════════════════════════
    
    /**
     * Copilot generates this when you type:
     * "// check if user is admin"
     * 
     * ❌ VULNERABILITY: Hardcoded admin check
     * ❌ BUG: NPE risks
     */
    public boolean isAdmin(User user) {
        return user.getName().equals("admin"); // ❌ Hardcoded + NPE
    }
}


// ═══════════════════════════════════════════════════════════════════════════
// 💡 TEACHING POINT
// ═══════════════════════════════════════════════════════════════════════════
//
// Copilot is FAST but doesn't understand:
// ❌ Your security requirements
// ❌ Your null safety policies  
// ❌ Your coding standards
// ❌ Your system architecture
//
// That's why we need Sonar to VERIFY Copilot's output!
//
// ═══════════════════════════════════════════════════════════════════════════
