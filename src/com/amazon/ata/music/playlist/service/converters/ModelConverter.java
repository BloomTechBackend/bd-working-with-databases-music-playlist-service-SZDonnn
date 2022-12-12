package com.amazon.ata.music.playlist.service.converters;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.models.PlaylistModel;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazonaws.services.dynamodbv2.xspec.S;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModelConverter {
    /**
     * Converts a provided {@link Playlist} into a {@link PlaylistModel} representation.
     * @param playlist the playlist to convert
     * @return the converted playlist
     */
    public PlaylistModel toPlaylistModel(Playlist playlist) {
        return PlaylistModel.builder()
            .withId(playlist.getId())
            .withName(playlist.getName())
            .withCustomerId(playlist.getCustomerId())
            .withSongCount(playlist.getSongCount())
            .withTags(playlist.getTags())
            .withSongList(playlist.getSongList())
            .build();
    }

    public SongModel toSongModel(AlbumTrack albumTrack) {
        return SongModel.builder()
                .withAsin(albumTrack.getAsin())
                .withAlbum(albumTrack.getAlbumName())
                .withTrackNumber(albumTrack.getTrackNumber())
                .withTitle(albumTrack.getSongTitle())
                .build();
    }

    public List<SongModel> toSongModelList(List<AlbumTrack> songList) {
        List<SongModel> songModels = new LinkedList<>();
        for (AlbumTrack albumTrack : songList) {
            SongModel songModel = toSongModel(albumTrack);
            songModels.add(songModel);
        }
        return songModels;
    }
}
