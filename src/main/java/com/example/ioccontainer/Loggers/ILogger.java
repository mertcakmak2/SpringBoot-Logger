package com.example.ioccontainer.Loggers;

import com.example.ioccontainer.Entities.Log;
import org.springframework.stereotype.Component;

@Component
public interface ILogger {

    void log(String logMessage);
}
