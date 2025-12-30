package com.demo.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * User service with intentional bugs for demo
 */
@Service
public class UserService {

    /**
     * Get the length of user's name
     * 
     * ❌ BUG: NullPointerException risk
     * - user could be null
     * - user.getName() could return null
     * 
     * Sonar Rule: S2259 - Null pointers should not be dereferenced
     */
    public int getUserNameLength(User user) {
        return user.getName().length(); // ❌ NPE risk - PATTERN #1
    }

    /**
     * Get user display name
     * 
     * ❌ BUG: Same pattern - no null check
     */
    public String getDisplayName(User user) {
        return user.getName().toUpperCase(); // ❌ NPE risk - same pattern
    }

    /**
     * Check if user name starts with prefix
     * 
     * ❌ BUG: Same pattern again
     */
    public boolean nameStartsWith(User user, String prefix) {
        return user.getName().startsWith(prefix); // ❌ NPE risk - same pattern
    }
}
