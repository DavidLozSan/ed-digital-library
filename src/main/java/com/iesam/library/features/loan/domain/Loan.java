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

    public Loan(String code, User user, DigitalCollection digitalCollection, String loanStartDate, String loanEndDate) {
        this.code = code;
        this.user = user;
        this.digitalCollection = digitalCollection;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanStatus = "Finalizado";
    }

    @Override
    public String toString() {
        return "Loan{" +
                "code='" + code + '\'' +
                ", user=" + user +
                ", digitalCollection=" + digitalCollection +
                ", loanStartDate='" + loanStartDate + '\'' +
                ", loanEndDate='" + loanEndDate + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                '}';
    }
}