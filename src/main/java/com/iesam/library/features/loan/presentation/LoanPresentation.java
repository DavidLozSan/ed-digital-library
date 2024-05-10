package com.iesam.library.features.loan.presentation;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.data.local.DigitalFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.book.data.BookDataRepository;
import com.iesam.library.features.digitalCollection.domain.book.data.local.BookFileLocalDataSource;
import com.iesam.library.features.loan.data.LoanDataRepository;
import com.iesam.library.features.loan.data.local.LoanFileLocalDataSource;
import com.iesam.library.features.loan.domain.*;
import com.iesam.library.features.user.data.UserDataRepository;
import com.iesam.library.features.user.data.local.UserFileLocalDataSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LoanPresentation {
    public static void loanMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------------------------------");
        System.out.println("\nMenú préstamos:\n");
        System.out.println("1. Solicitar préstamo");
        System.out.println("2. Eliminar préstamo");
        System.out.println("3. Consultar préstamos sin finalizar");
        System.out.println("4. Consultar préstamos finalizados");
        System.out.println("5. Finalizar préstamo");
        System.out.println("0. Salir");
        System.out.println("\n---------------------------------");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                save();
                break;
            case 2:
                delete();
                break;
            case 3:
                unfinishedLoans();
                break;
            case 4:
                finalizedLoans();
                break;
            case 5:
                finalizeLoan();
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
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        DigitalDataRepository digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        BookDataRepository bookDataRepository = new BookDataRepository(new BookFileLocalDataSource());
        SaveLoanUseCase saveLoanUseCase = new SaveLoanUseCase(loanDataRepository, userDataRepository,
                digitalDataRepository, bookDataRepository);
        saveLoanUseCase.execute(code, userCode, digitalResourceCode);
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de préstamo a eliminar");
        String code = sc.nextLine();
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(loanDataRepository);
        deleteLoanUseCase.execute(code);
    }

    public static void unfinishedLoans() {
        System.out.println("El listado de préstamos sin finalizar: ");
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        GetUnfinishedLoansUseCase getUnfinishedLoansUseCase = new GetUnfinishedLoansUseCase(loanDataRepository);
        List<Loan> loans = getUnfinishedLoansUseCase.execute();
        System.out.println(loans);
    }

    public static void finalizedLoans() {
        System.out.println("El listado de préstamos finalizados: ");
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        GetFinalizedLoansUseCase getFinalizedLoansUseCase = new GetFinalizedLoansUseCase(loanDataRepository);
        List<Loan> loans = getFinalizedLoansUseCase.execute();
        System.out.println(loans);
    }

    public static void finalizeLoan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el código de préstamo para finalizar");
        String code = sc.nextLine();
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        FinalizeLoanUseCase finalizeLoanUseCase = new FinalizeLoanUseCase(loanDataRepository);
        finalizeLoanUseCase.execute(code);
    }
}
