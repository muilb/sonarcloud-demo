package com.demo.util;

/**
 * Password utility class - INTENTIONALLY INSECURE for demo
 * 
 * This file demonstrates what happens when:
 * 1. Developer asks Copilot to "generate password check method"
 * 2. Copilot generates code with hardcoded credentials
 * 3. Sonar catches the security vulnerability
 * 
 * ❌ VULNERABILITY: S2068 - Credentials should not be hard-coded
 */
public class PasswordUtil {

    // ❌ SECURITY ISSUE: Hardcoded password
    // Sonar Rule: S2068 - Credentials should not be hard-coded
    public static final String DB_PASSWORD = "xxxxx";
    
    // ❌ SECURITY ISSUE: Another hardcoded credential
    private static final String API_KEY = "sk-1234567890abcdef444";
    
    // ❌ SECURITY ISSUE: Hardcoded in variable name
    private static final String SECRET_TOKEN = "mySecretToken20242025";

    /**
     * Validate password - INSECURE implementation
     * 
     * ❌ Multiple issues:
     * 1. Hardcoded password comparison
     * 2. No hashing
     * 3. Potential NPE if input is null
     */
    public static boolean validate(String input) {
        return DB_PASSWORD.equals(input); // ❌ Hardcoded credential usage
    }

    /**
     * Check API key - INSECURE
     * 
     * ❌ This is exactly what Copilot might generate
     * when asked to "create API key validation"
     */
    public static boolean validateApiKey(String key) {
        return API_KEY.equals(key); // ❌ Hardcoded credential
    }

    /**
     * Get database connection string - INSECURE
     * 
     * ❌ Hardcoded credentials in connection string
     * Sonar Rule: S2068
     */
    public static String getConnectionString() {
        // ❌ SECURITY: Hardcoded username and password
        return "jdbc:mysql://localhost:3306/mydb?user=root&password=admin123";
    }
}
