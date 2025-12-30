package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * User REST controller - contains several code quality issues
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get user name length
     * 
     * ❌ CODE SMELL: No input validation
     * ❌ BUG: NPE propagated from service
     */
    @GetMapping("/{id}/name-length")
    public int getNameLength(@PathVariable Long id) {
        User user = findUserById(id); // Could return null
        return userService.getUserNameLength(user); // ❌ NPE risk
    }

    /**
     * Validate user password
     * 
     * ❌ SECURITY: Using insecure PasswordUtil
     * ❌ CODE SMELL: Password in GET request (should be POST)
     */
    @GetMapping("/validate")
    public boolean validatePassword(@RequestParam String password) {
        return PasswordUtil.validate(password); // ❌ Uses hardcoded password
    }

    /**
     * Find user by ID - simplified mock
     * 
     * ❌ BUG: Returns null without proper handling
     */
    private User findUserById(Long id) {
        // Simulated: In real app, this would query database
        if (id == null || id <= 0) {
            return null; // ❌ Returns null - callers don't handle this
        }
        return new User(id, "Test User", "test@example.com");
    }

    // ═══════════════════════════════════════════════════════════════════
    // DUPLICATE CODE - CODE SMELL
    // ═══════════════════════════════════════════════════════════════════

    /**
     * ❌ CODE SMELL: Duplicate method - same logic as getNameLength
     * Sonar Rule: S1192 - String literals should not be duplicated
     */
    @GetMapping("/{id}/display-name-length")
    public int getDisplayNameLength(@PathVariable Long id) {
        User user = findUserById(id); // ❌ Duplicated logic
        return userService.getUserNameLength(user); // ❌ Same call
    }
}
