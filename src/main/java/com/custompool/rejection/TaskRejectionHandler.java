package com.rejection;

public interface TaskRejectionHandler {
    void onRejected(Runnable task, ThreadPool pool);
}