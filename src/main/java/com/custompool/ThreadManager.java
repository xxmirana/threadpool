package com.customexecutor;

import java.util.concurrent.*;

public interface ThreadManager extends Executor {
    <T> ScheduledTask<T> schedule(Callable<T> job);
    void stop();
    void forceStop();
}