package com.iesam.library.features.digitalCollection.domain;

import com.iesam.library.features.digitalCollection.book.domain.Book;
import com.iesam.library.features.digitalCollection.music.domain.Music;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveDigitalResourceUseCaseTest {
    @Mock
    DigitalRepository digitalRepository;
    SaveDigitalResourceUseCase saveDigitalResourceUseCase;

    @BeforeEach
    void setUp() {
        saveDigitalResourceUseCase = new SaveDigitalResourceUseCase(digitalRepository);
    }

    @AfterEach
    void tearDown() {
        saveDigitalResourceUseCase = null;
    }

    @Test
    public void receiveABookAndSave() {
        Book book = new Book("001", "libro", "autor", "editorial", "2010",
                "2010", "ISBN", "Comedia");

        saveDigitalResourceUseCase.execute(book);

        Mockito.verify(digitalRepository, Mockito.times(1)).save(book);
    }

    @Test
    public void receiveAMusicAndSave() {
        Music music = new Music("002","Musica","Artista","Album","2010","Pop","3:20");

        saveDigitalResourceUseCase.execute(music);

        Mockito.verify(digitalRepository, Mockito.times(1)).save(music);
    }
}