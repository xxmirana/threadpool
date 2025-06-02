package com.demo;

import com.threadpool.*;
import com.rejection.*;
import com.threadfactory.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        DynamicThreadCreator creator = new DynamicThreadCreator("CustomPool");
        
        DynamicThreadPool pool = new DynamicThreadPool(
            2, 4, 5, TimeUnit.SECONDS,
            10, 1, TaskRejectionPolicy.EXECUTE_CALLER, creator
        );
        
        for (int i = 0; i < 15; i++) {
            int taskId = i;
            pool.schedule(() -> {
                System.out.println("Executing task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return null;
            });
        }
        
        pool.stop();
    }
}