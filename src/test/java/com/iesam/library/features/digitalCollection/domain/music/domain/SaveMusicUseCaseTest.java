package com.iesam.library.features.digitalCollection.domain.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.data.local.DigitalFileLocalDataSource;
import com.iesam.library.features.digitalCollection.music.domain.Music;
import com.iesam.library.features.digitalCollection.music.domain.MusicRepository;
import com.iesam.library.features.digitalCollection.music.domain.SaveMusicUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SaveMusicUseCaseTest {
    @Mock
    MusicRepository musicRepository;
    DigitalDataRepository digitalDataRepository;
    SaveMusicUseCase saveMusicUseCase;

    @BeforeEach
    void setUp() {
        digitalDataRepository = new DigitalDataRepository(new DigitalFileLocalDataSource());
        saveMusicUseCase = new SaveMusicUseCase(musicRepository, digitalDataRepository);
    }

    @AfterEach
    void tearDown() {
        saveMusicUseCase = null;
        digitalDataRepository = null;
    }

    @Test
    public void theUseCaseCalledAndThenExecuted() {
        Music music = new Music("001", "aaa", "aaa", "aaa", "aaa",
                "aaa", "aaa");

        saveMusicUseCase.execute(music);

        Mockito.verify(musicRepository, Mockito.times(1)).saveMusic(music);
    }
}