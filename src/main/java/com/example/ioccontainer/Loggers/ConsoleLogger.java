package com.example.ioccontainer.Loggers;

import com.example.ioccontainer.Entities.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ConsoleLogger")
public class ConsoleLogger implements ILogger{

    @Override
    public void log(String logMessage) {
        Log log = new Log();
        log.setLogMessage(logMessage);
        System.out.println("Console logger: "+log);
    }

}
