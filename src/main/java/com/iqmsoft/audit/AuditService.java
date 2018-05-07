package com.iqmsoft.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iqmsoft.audit.util.AuditActionType;

@Service
public class AuditService {

    private Logger log = LoggerFactory.getLogger(AuditService.class);

    public void auditEvent(AuditActionType auditActionType) {
        log.info("AUDIT: action occurred: {}", auditActionType);
    }

    public void auditErrorEvent(AuditActionType auditActionType) {
        log.error("AUDIT: error occurred: {}", auditActionType);
    }
}
