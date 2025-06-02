package com.custompool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.*;

public class CustomThreadPoolTest {
    @Test
    public void testPoolInitialization() {
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(
                2, 4, 5, TimeUnit.SECONDS,
                5, 1,
                new CustomRejectionPolicies.AbortPolicy(),
                new CustomThreadFactory("TestPool")
        );

        assertNotNull(executor);
        assertEquals(2, executor.getCurrentPoolSize());
    }

    // Дополнительные тесты
}