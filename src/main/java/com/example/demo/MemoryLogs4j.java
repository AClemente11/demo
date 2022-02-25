package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = "MemoryLogs4j")
public class MemoryLogs4j {
    @Id
    @GeneratedValue
    private Long id;

    private String date;

    private Long freeMem;
    private Long usedMem;

    MemoryLogs4j(){}

    public MemoryLogs4j(String date, Long freeMem, Long usedMem) {
        this.date = date;
        this.freeMem = freeMem;
        this.usedMem = usedMem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getFreeMem() {
        return freeMem;
    }

    public void setFreeMem(Long freeMem) {
        this.freeMem = freeMem;
    }

    public Long getUsedMem() {
        return usedMem;
    }

    public void setUsedMem(Long usedMem) {
        this.usedMem = usedMem;
    }





}
