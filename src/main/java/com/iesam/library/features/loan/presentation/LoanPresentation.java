package com.iesam.library.features.loan.presentation;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.loan.data.LoanDataRepository;
import com.iesam.library.features.loan.data.local.LoanFileLocalDataSource;
import com.iesam.library.features.loan.domain.*;
import com.iesam.library.features.user.domain.User;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanPresentation {
    public static void loanMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú préstamos:\n");
        System.out.println("1. Solicitar préstamo");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                save();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Esa opción no es válida");
                break;
        }
    }

    public static void save() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de préstamo");
        String code = sc.nextLine();
        System.out.println("Dame el código de usuario");
        String userCode = sc.nextLine();
        System.out.println("Dame el código del recurso digital");
        String digitalResourceCode = sc.nextLine();
        Loan loan = new Loan(code, null, null);
        System.out.println("La fecha de inicio del préstamo: " + loan.loanStartDate);
        System.out.println("La fecha límite del préstamo: " + loan.loanEndDate);
        System.out.println("El estado del préstamo: " + loan.loanStatus);
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        SaveLoanUseCase saveLoanUseCase = new SaveLoanUseCase(loanDataRepository);
        saveLoanUseCase.execute(loan);
        //saveLoanUseCase.execute(loan, userCode, digitalResourceCode);
    }
}
