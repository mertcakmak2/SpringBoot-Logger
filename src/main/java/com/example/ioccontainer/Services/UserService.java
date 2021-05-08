package com.example.ioccontainer.Services;

import com.example.ioccontainer.Entities.Log;
import com.example.ioccontainer.Entities.User;
import com.example.ioccontainer.Loggers.ILogger;
import com.example.ioccontainer.Repositories.ILogRepository;
import com.example.ioccontainer.Repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    @Qualifier("PostgreLogger")
    private final ILogger postgreLogger;
    @Qualifier("ConsoleLogger")
    private final ILogger consoleLogger;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        postgreLogger.log(savedUser.getName()+" user saved from PostgreLogger");
        //consoleLogger.log(savedUser.getName()+" user saved from PostgreLogger");
        return savedUser;
    }

    @Override
    public User deleteUser(User user) throws Exception {
        userRepository.delete(user);
        boolean isDeleted = !userRepository.existsById(user.getId());
        if(isDeleted){
            postgreLogger.log(user.getName()+" user deleted from PostgreLogger");
            //consoleLogger.log(user.getName()+" user deleted from PostgreLogger");
            return user;
        }
        throw new Exception("Silinme işlemi başarısız");
    }
}
