package com.custompool.rejection;

import java.util.concurrent.RejectedExecutionHandler;

public interface RejectedExecutionHandler extends java.util.concurrent.RejectedExecutionHandler {
    // Интерфейс-маркер для кастомных политик отказа
}