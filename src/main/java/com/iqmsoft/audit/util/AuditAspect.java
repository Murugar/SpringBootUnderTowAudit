package com.iqmsoft.audit.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqmsoft.audit.AuditService;

@Aspect
@Component
public class AuditAspect {
	
	private Logger log = LoggerFactory.getLogger(AuditAspect.class);

    private final AuditService auditService;

    @Autowired
    public AuditAspect(AuditService auditService) {
        this.auditService = auditService;
    }
    
    
    @Before("execution(* com.iqmsoft.audit.MainController.getResource(..))")
	public void logBefore(JoinPoint joinPoint) {

    	log.info("Before AUDIT: action occurred: {}");
	

	}
    
    @After("execution(* com.iqmsoft.audit.MainController.getResource(..))")
	public void logAfter(JoinPoint joinPoint) {

    	log.info("After AUDIT: action occurred: {}");
	

	}

    @Around("@annotation(auditableAnnotation)")
    public Object audit(ProceedingJoinPoint joinPoint, Auditable auditableAnnotation) throws Throwable {
        boolean ok = false;
        try {
            Object o = joinPoint.proceed();
            ok = true;
            return o;
        } finally {
          
            if (ok) {
                auditService.auditEvent(auditableAnnotation.auditActionType());
            } else {
                auditService.auditErrorEvent(auditableAnnotation.auditActionType());
            }
        }
    }
    
  
    
    
}
