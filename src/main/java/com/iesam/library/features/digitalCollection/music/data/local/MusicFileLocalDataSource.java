package com.iesam.library.features.digitalCollection.music.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.library.features.digitalCollection.music.domain.Music;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MusicFileLocalDataSource implements MusicLocalDataSource {
    private String nameFile = "music.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Music>>() {
    }.getType();

    public void save(Music model) {
        List<Music> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Music> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Music> models) {
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

    public Music findByCode(String code) {
        List<Music> models = findAll();
        for (Music model : models) {
            if (Objects.equals(model.getCode(), code)) {
                return model;
            }
        }
        return null;
    }

    public List<Music> findAll() {
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
        List<Music> newList = new ArrayList<>();
        List<Music> models = findAll();
        for (Music model : models) {
            if (!model.getCode().equals(modelCode)) {
                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void update(Music music) {
        delete(music.getCode());
        save(music);
    }
}
