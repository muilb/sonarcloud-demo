package com.demo.config;

/**
 * Database configuration - INTENTIONALLY INSECURE
 * 
 * 🎯 DEMO SCENARIO: "Copilot viết nhanh nhưng sai"
 * 
 * This is EXACTLY what Copilot generates when you prompt:
 * "// Generate method to connect to database with password"
 * 
 * Copilot doesn't know your security requirements!
 */
public class DatabaseConfig {

    // ❌ VULNERABILITY: S2068 - Hardcoded credentials
    // This is what Copilot typically generates
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "production_db";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "admin123"; // ❌ SECURITY ISSUE

    /**
     * Get database URL - Copilot-generated style
     * 
     * ❌ Hardcoded credentials exposed in URL
     */
    public static String getUrl() {
        return String.format("jdbc:mysql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);
    }

    /**
     * Get database password - INSECURE
     * 
     * ❌ Returns hardcoded password directly
     * 
     * ✅ FIX: Use environment variable
     * return System.getenv("DB_PASSWORD");
     */
    public static String getPassword() {
        return DB_PASSWORD; // ❌ Sonar will catch this
    }

    /**
     * Validate connection - INSECURE
     * 
     * ❌ Multiple security issues:
     * 1. Hardcoded credentials
     * 2. Password in plain text comparison
     */
    public static boolean validateCredentials(String user, String password) {
        return DB_USER.equals(user) && DB_PASSWORD.equals(password);
    }
}


// ═══════════════════════════════════════════════════════════════════════════
// ✅ FIXED VERSION (shown in slide demo)
// ═══════════════════════════════════════════════════════════════════════════
//
// public class DatabaseConfig {
//     
//     public static String getPassword() {
//         // ✅ Read from environment variable
//         String password = System.getenv("DB_PASSWORD");
//         if (password == null || password.isEmpty()) {
//             throw new IllegalStateException("DB_PASSWORD environment variable not set");
//         }
//         return password;
//     }
//     
//     public static boolean validateCredentials(String user, String password) {
//         String expectedUser = System.getenv("DB_USER");
//         String expectedPassword = System.getenv("DB_PASSWORD");
//         return expectedUser != null && expectedUser.equals(user)
//             && expectedPassword != null && expectedPassword.equals(password);
//     }
// }
