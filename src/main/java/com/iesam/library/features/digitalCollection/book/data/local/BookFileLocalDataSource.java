package com.iesam.library.features.digitalCollection.book.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.library.features.digitalCollection.book.domain.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookFileLocalDataSource implements BookLocalDataSource {

    private String nameFile = "book.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Book>>() {
    }.getType();

    public void save(Book model) {
        List<Book> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Book> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Book> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Book findByCode(String code) {
        List<Book> models = findAll();
        for (Book model : models) {
            if (Objects.equals(model.getCode(), code)) {
                return model;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void delete(String modelCode) {
        List<Book> newList = new ArrayList<>();
        List<Book> models = findAll();
        for (Book model : models) {
            if (!model.getCode().equals(modelCode)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void update(Book book) {
        delete(book.getCode());
        save(book);
    }
}
