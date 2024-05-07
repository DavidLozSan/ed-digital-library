package com.iesam.library.features.loan.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    public final String code;
    public final String userCode;
    public final String digitalResourceCode;
    public final String loanStartDate;
    public final String loanEndDate;
    public final String loanStatus;

    public Loan(String code, String userCode, String digitalResourceCode, String loanStartDate, String loanEndDate, String loanStatus) {
        this.code = code;
        this.userCode = userCode;
        this.digitalResourceCode = digitalResourceCode;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanStatus = loanStatus;
    }

    public String getCode() {
        return code;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getDigitalResourceCode() {
        return digitalResourceCode;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public String getLoanEndDate() {
        return loanEndDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }
}