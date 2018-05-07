package com.iqmsoft.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iqmsoft.audit.util.AuditActionType;
import com.iqmsoft.audit.util.Auditable;

@Service
public class MainService {

    private Logger LOGGER = LoggerFactory.getLogger(MainService.class);

    
    @Auditable(auditActionType = AuditActionType.ACTION_TYPE_ONE)
    public String myService1(String arg1) {
        LOGGER.info("Normal log statement");
        if ("THROW".equalsIgnoreCase(arg1)) {
            throw new RuntimeException("thrown exception message");
        }
        return arg1;
    }
    
        
    @Auditable(auditActionType = AuditActionType.ACTION_TYPE_TWO)
    public String myService2(String arg1, String arg2) {
        LOGGER.info("Normal log statement");
        if ("THROW".equalsIgnoreCase(arg1)) {
            throw new RuntimeException("thrown exception message");
        }
        return arg1 + " " + arg2;
    }
    
 
    
}
