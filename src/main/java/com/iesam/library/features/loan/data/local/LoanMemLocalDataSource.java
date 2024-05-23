package com.iesam.library.features.loan.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.library.features.loan.domain.Loan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class LoanMemLocalDataSource implements LoanLocalDataSource {

    private final Map<String, Loan> loanMap = new HashMap<>();
    private final Gson gson = new Gson();
    private final Type typeList = new TypeToken<Map<String, Loan>>() {}.getType();
    private final File file;

    private static LoanMemLocalDataSource instance;

    private LoanMemLocalDataSource(File file) {
        this.file = file;
    }

    public static LoanMemLocalDataSource getInstance(File file) {
        if (instance == null) {
            instance = new LoanMemLocalDataSource(file);
        }
        return instance;
    }

    public void save(Loan model) {
        loanMap.put(model.code, model);
    }

    public Loan findByCode(String code) {
        return loanMap.get(code);
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loanMap.values());
    }

    public void delete(String modelCode) {
        loanMap.remove(modelCode);
    }

    @Override
    public List<Loan> unfinishedLoans() {
        return loanMap.values().stream()
                .filter(loan -> "Activo".equals(loan.loanStatus))
                .collect(Collectors.toList());
    }

    @Override
    public List<Loan> finalizedLoans() {
        return loanMap.values().stream()
                .filter(loan -> "Finalizado".equals(loan.loanStatus))
                .collect(Collectors.toList());
    }

    @Override
    public void finalizeLoan(Loan loan) {
        loanMap.put(loan.code, loan);
    }

    public void loadFromFile() {
        try {
            if (file.exists()) {
                Scanner myReader = new Scanner(file);
                StringBuilder data = new StringBuilder();
                while (myReader.hasNextLine()) {
                    data.append(myReader.nextLine());
                }
                myReader.close();
                Map<String, Loan> loans = gson.fromJson(data.toString(), typeList);
                if (loans != null) {
                    loanMap.putAll(loans);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(gson.toJson(loanMap));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
