package com.demo.service;

import com.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for UserService
 * 
 * ❌ INTENTIONALLY LOW COVERAGE for demo
 * 
 * Sonar will report:
 * - Low test coverage (< 80%)
 * - Missing test cases
 * - Tests don't cover edge cases (null)
 */
class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("Test getUserNameLength with valid user")
    void testGetUserNameLength_ValidUser() {
        // Arrange
        User user = new User(1L, "John Doe", "john@example.com");
        
        // Act
        int length = userService.getUserNameLength(user);
        
        // Assert
        assertEquals(8, length); // "John Doe" = 8 chars
    }

    // ═══════════════════════════════════════════════════════════════
    // ❌ MISSING TESTS - Sonar will detect low coverage
    // ═══════════════════════════════════════════════════════════════
    
    // ❌ No test for null user
    // ❌ No test for user with null name
    // ❌ No test for empty name
    // ❌ No test for getDisplayName()
    // ❌ No test for nameStartsWith()

    // ═══════════════════════════════════════════════════════════════
    // Commented out: These tests SHOULD exist but don't
    // ═══════════════════════════════════════════════════════════════
    
    /*
    @Test
    @DisplayName("Test getUserNameLength with null user - SHOULD FAIL")
    void testGetUserNameLength_NullUser() {
        // This test would reveal the NPE bug!
        assertThrows(NullPointerException.class, () -> {
            userService.getUserNameLength(null);
        });
    }

    @Test  
    @DisplayName("Test getUserNameLength with null name - SHOULD FAIL")
    void testGetUserNameLength_NullName() {
        User user = new User(1L, null, "test@test.com");
        // This test would reveal the NPE bug!
        assertThrows(NullPointerException.class, () -> {
            userService.getUserNameLength(user);
        });
    }
    */
}


// ═══════════════════════════════════════════════════════════════════════════
// 💡 TEACHING POINT
// ═══════════════════════════════════════════════════════════════════════════
//
// Sonar Quality Gate includes coverage requirements:
// - Default: >= 80% coverage on new code
// - This test file only covers ~20% of UserService
//
// When Quality Gate fails:
// 1. Coverage too low
// 2. Missing edge case tests
// 3. Bugs not caught before production
//
// ═══════════════════════════════════════════════════════════════════════════
