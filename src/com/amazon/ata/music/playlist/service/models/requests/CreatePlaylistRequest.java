package com.amazon.ata.music.playlist.service.models.requests;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeValueException;
import com.amazon.ata.music.playlist.service.util.MusicPlaylistServiceUtils;

import java.util.List;
import java.util.Objects;

public class CreatePlaylistRequest {
    private String id;
    private String name;
    private String customerId;
    private int songCount;
    private List<String> tags;
    private List<AlbumTrack> songList;

    public CreatePlaylistRequest(String id, String name, String customerId,
                                 int songCount, List<String> tags, List<AlbumTrack> songList) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.songCount = songCount;
        this.tags = tags;
        this.songList = songList;
    }

    public CreatePlaylistRequest() {
    }

    public CreatePlaylistRequest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.customerId = builder.customerId;
        this.songCount = builder.songCount;
        this.tags = builder.tags;
        this.songList = builder.songList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<AlbumTrack> getSongList() {
        return songList;
    }

    public void setSongList(List<AlbumTrack> songList) {
        this.songList = songList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePlaylistRequest that = (CreatePlaylistRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(songCount, that.songCount) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(songList, that.songList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, customerId, songCount, tags, songList);
    }

    @Override
    public String toString() {
        return "CreatePlaylistRequest{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", songCount='" + songCount + '\'' +
                ", tags=" + tags +
                ", songList=" + songList +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String id;
        private String name;
        private String customerId;
        private int songCount;
        private List<String> tags;
        private List<AlbumTrack> songList;

        private Builder() {
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public Builder withCustomerId(String customerIdToUse) {
            this.customerId = customerIdToUse;
            return this;
        }

        public Builder withSongCount(int songCount) {
            this.songCount = songCount;
            return this;
        }

        public Builder withTags(List<String> tagsToUse) {
            this.tags = tagsToUse;
            return this;
        }

        public Builder withSongList(List<AlbumTrack> songList) {
            this.songList = songList;
            return this;
        }

        public CreatePlaylistRequest build() { return new CreatePlaylistRequest(this); }
    }
}
