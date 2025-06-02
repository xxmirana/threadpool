package com.test;

import org.junit.jupiter.api.*;
import com.threadpool.*;
import com.threadfactory.*;

class ThreadPoolTest {
    @Test
    void testInitialization() {
        DynamicThreadPool pool = new DynamicThreadPool(
            2, 4, 1, TimeUnit.SECONDS,
            5, 1, TaskRejectionPolicy.TERMINATE,
            new DynamicThreadCreator("TestPool")
        );
        
        Assertions.assertEquals(2, pool.getCurrentWorkerCount());
    }
}