package com.rejection;

import java.util.concurrent.*;

public enum TaskRejectionPolicy {
    TERMINATE {
        public void handle(Runnable task, ThreadPoolExecutor pool) {
            throw new RejectedExecutionException("Task " + task + " rejected");
        }
    },
    EXECUTE_CALLER {
        public void handle(Runnable task, ThreadPoolExecutor pool) {
            System.out.println("[Overload] Executing in calling thread: " + task);
            task.run();
        }
    },
    DISCARD {
        public void handle(Runnable task, ThreadPoolExecutor pool) {
            // Silent discard
        }
    };
    
    public abstract void handle(Runnable task, ThreadPoolExecutor pool);
}

    public static class DiscardPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // Просто игнорируем задачу
        }
    }
}