package com.iesam.library.features.loan.domain;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.user.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    public final String code;
    public final User user;
    public final DigitalCollection digitalCollection;
    public final String loanStartDate;
    public final String loanEndDate;
    public final String loanStatus;

    public Loan(String code, User user, DigitalCollection digitalCollection) {
        this.code = code;
        this.user = user;
        this.digitalCollection = digitalCollection;
        this.loanStartDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.loanEndDate = LocalDate.now().plusDays(21).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.loanStatus = "Activo";
    }

    public String getCode() {
        return code;
    }

    public User getUser() {
        return user;
    }

    public DigitalCollection getDigitalCollection() {
        return digitalCollection;
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