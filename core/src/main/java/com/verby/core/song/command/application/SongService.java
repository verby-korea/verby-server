package com.verby.core.song.command.application;

import com.verby.core.song.command.domain.Song;
import com.verby.core.song.command.domain.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public Song create(CreateSongRequest createSongRequest) {

        Song song = new Song(
                createSongRequest.getArtistId(),
                createSongRequest.getName(),
                createSongRequest.getImage());

        return songRepository.save(song);
    }

}