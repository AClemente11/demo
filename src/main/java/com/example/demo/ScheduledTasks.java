package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    @Autowired
    private MemoryLogsRepository repository;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
    long usedMem;
    long freeMem;
    @Scheduled(fixedRate = 300000)
    public void reportCurrentTimeLogs() {
        usedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        freeMem = Runtime.getRuntime().freeMemory();
        String date = dateFormat.format(new Date());

        repository.save(new MemoryLogs4j(date,freeMem,usedMem));

    }
}
