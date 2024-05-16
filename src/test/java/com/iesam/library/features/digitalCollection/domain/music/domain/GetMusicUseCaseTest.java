package com.iesam.library.features.digitalCollection.domain.music.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetMusicUseCaseTest {
    @Mock
    MusicRepository musicRepository;
    GetMusicUseCase getMusicUseCase;

    @BeforeEach
    void setUp() {
        getMusicUseCase = new GetMusicUseCase(musicRepository);
    }

    @AfterEach
    void tearDown() {
        musicRepository = null;
    }

    @Test
    public void getACodeValidThenReturnAMusic() {
        Music musicExpected = new Music("004", "musica4", "artita4", "album4",
                "2010", "Pop", "3min");
        Mockito.when(musicRepository.obtainMusic(musicExpected.code)).thenReturn(musicExpected);

        Music musicReceived = getMusicUseCase.execute(musicExpected.code);

        Mockito.verify(musicRepository, Mockito.times(1)).obtainMusic(musicExpected.code);
        Assertions.assertEquals(musicReceived.code, musicExpected.code);
        Assertions.assertEquals(musicReceived.digitalResourceType, musicExpected.digitalResourceType);
        Assertions.assertEquals(musicReceived.name, musicExpected.name);
        Assertions.assertEquals(musicReceived.artist, musicExpected.artist);
        Assertions.assertEquals(musicReceived.album, musicExpected.album);
        Assertions.assertEquals(musicReceived.releaseYear, musicExpected.releaseYear);
        Assertions.assertEquals(musicReceived.genre, musicExpected.genre);
        Assertions.assertEquals(musicReceived.duration, musicExpected.duration);
    }

    @Test
    public void getAnInvalidCodeAndThenReturnANull() {
        String invalidCode = "001";
        Mockito.when(musicRepository.obtainMusic(invalidCode)).thenReturn(null);

        Music musicReceived = getMusicUseCase.execute(invalidCode);

        Mockito.verify(musicRepository, Mockito.times(1)).obtainMusic(invalidCode);
        Assertions.assertNull(musicReceived);

    }
}