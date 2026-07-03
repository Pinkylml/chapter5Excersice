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
}
