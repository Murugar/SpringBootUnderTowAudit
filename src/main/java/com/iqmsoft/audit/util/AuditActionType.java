package com.iqmsoft.audit.util;

public enum AuditActionType {
    ACTION_TYPE_ONE("Action type ONE"),
    ACTION_TYPE_TWO("Action type ONE");

    private String auditActionDescription;

    public String getAuditActionDescription() {
        return auditActionDescription;
    }

    public void setAuditActionDescription(String auditActionDescription) {
        this.auditActionDescription = auditActionDescription;
    }

    AuditActionType(String auditActionDescription) {
        this.auditActionDescription = auditActionDescription;
    }

}
