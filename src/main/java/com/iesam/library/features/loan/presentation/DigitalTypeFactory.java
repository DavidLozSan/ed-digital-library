package com.iesam.library.features.loan.presentation;

import com.iesam.library.features.digitalCollection.book.data.BookDataRepository;
import com.iesam.library.features.digitalCollection.book.data.local.BookFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
import com.iesam.library.features.digitalCollection.music.data.MusicDataRepository;
import com.iesam.library.features.digitalCollection.music.data.local.MusicFileLocalDataSource;

public class DigitalTypeFactory {

    public static DigitalRepository getRepository(String typeResource) {
        switch (typeResource) {
            case "1":
                return new BookDataRepository(new BookFileLocalDataSource());
            case "2":
                return new MusicDataRepository(new MusicFileLocalDataSource());
        }
        return null;
    }
}
