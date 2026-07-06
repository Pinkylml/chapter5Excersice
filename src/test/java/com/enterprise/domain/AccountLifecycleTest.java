package com.enterprise.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountLifecycleTest extends AbstractJPATest {
    @Test
    public void shouldAssignTimestampOnPersist() {
        Account account = new Account("Alice", 250.0);

        Assertions.assertNull(account.getId());
        Assertions.assertNull(account.getCreatedAt());

        em.persist(account);

        Assertions.assertNotNull(account.getId());
        Assertions.assertNotNull(account.getCreatedAt());

        System.out.println("Saved Account Lifecycle State: " + account);
        System.out.println("Automatic Generation Timestamp: " + account.getCreatedAt());
    }

    @Test
    public void shouldPreventDeletionWhenBalanceIsPositive() {
        // 1. Create and persist an account with a balance
        Account account = new Account("Bob", 100.0);
        em.persist(account);

        // Flush to ensure it is written to the database context
        em.flush();

        // 2. Verify that calling em.remove() triggers our exception
        Assertions.assertThrows(IllegalStateException.class, () -> {
            em.remove(account);
        });
    }
}
