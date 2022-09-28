package my.assignment.lottery.utils;

import java.security.SecureRandom;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class NumberGeneratorUtil {
    
    private SecureRandom random;
    private final static int NUMBER_LENGTH = 15;
    public NumberGeneratorUtil(){
        this.random = new SecureRandom();
    }
    /**
     * Generates a random 15 digit number
     * @return
     */
    public long generateRandNumber(){
        return Long.valueOf(
                String.valueOf(Math.abs(random.nextLong())).substring(0, NUMBER_LENGTH)
            );
    }
    
}
