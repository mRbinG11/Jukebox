package com.example.demo.entities;

import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private List<Long> songIds;

    public Playlist(Long id, String name, List<Long> songIds) {
        this.id = id;
        this.name = name;
        this.songIds = songIds;
    }

    public Playlist(String name, List<Long> songIds) {
        this(null, name, songIds);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Long> getSongIds() {
        return this.songIds;
    }

    public void setSongIds(List<Long> songIds) {
        this.songIds = songIds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + this.id + "]";
    }
}
