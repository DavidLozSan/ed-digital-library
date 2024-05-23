package com.iesam.library.features.digitalCollection.domain.music.domain;

import com.iesam.library.features.digitalCollection.data.DigitalDataRepository;
import com.iesam.library.features.digitalCollection.data.local.DigitalFileLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;
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
    @Mock
    DigitalRepository digitalRepository;
    SaveMusicUseCase saveMusicUseCase;

    @BeforeEach
    void setUp() {
        saveMusicUseCase = new SaveMusicUseCase(musicRepository, digitalRepository);
    }

    @AfterEach
    void tearDown() {
        saveMusicUseCase = null;
    }

    @Test
    public void theUseCaseCalledAndThenExecuted() {
        Music music = new Music("001", "aaa", "aaa", "aaa", "aaa",
                "aaa", "aaa");

        saveMusicUseCase.execute(music);

        Mockito.verify(musicRepository, Mockito.times(1)).saveMusic(music);
        Mockito.verify(digitalRepository, Mockito.times(1)).save(Mockito.any(DigitalCollection.class));
    }
}