package com.example.ioccontainer.Loggers;

import com.example.ioccontainer.Entities.Log;
import com.example.ioccontainer.Repositories.ILogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Component
@Qualifier("PostgreLogger")
public class PostgreLogger implements ILogger{

    private final ILogRepository logRepository;

    @Override
    public void log(String logMessage) {
        Log log = new Log();
        log.setLogMessage(logMessage);
        System.out.println("Postgre log: "+log);
        logRepository.save(log);
    }
}
