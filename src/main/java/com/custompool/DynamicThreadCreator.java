package com.threadfactory;

import java.util.concurrent.*;

public class DynamicThreadCreator implements ThreadFactory {
    private final String poolIdentifier;
    private final AtomicInteger counter = new AtomicInteger(1);
    
    public DynamicThreadCreator(String poolName) {
        this.poolIdentifier = poolName + "-exec-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, poolIdentifier + counter.getAndIncrement());
        t.setUncaughtExceptionHandler(this::handleThreadError);
        System.out.printf("[Thread Creator] New execution unit: %s%n", t.getName());
        return t;
    }
    
    private void handleThreadError(Thread t, Throwable e) {
        System.err.printf("Thread %s failed: %s%n", t.getName(), e.getMessage());
    }
}