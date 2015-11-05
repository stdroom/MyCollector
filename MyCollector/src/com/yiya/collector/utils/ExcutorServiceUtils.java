package com.yiya.collector.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/11/1.
 */
public class ExcutorServiceUtils {
    private static ExcutorServiceUtils instance;

    private ExecutorService executorService;

    private ExcutorServiceUtils(){
        executorService = Executors.newFixedThreadPool(20);
    }

    public static ExcutorServiceUtils getInstance(){
        if(instance == null){
            synchronized (ExcutorServiceUtils.class) {
                if(instance == null){
                    instance = new ExcutorServiceUtils();
                }
            }
        }
        return instance;
    }

    public ExecutorService getThreadPool(){
        return executorService;
    }
}
