package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public AddSongToPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        Long id = Long.parseLong(tokens.get(2));
        List<Long> songIds = this.playlistService.addSong(name, id);
        System.out.print("Playlist " + name + " is revised with ");
        for (int i = 0; i < songIds.size(); i++) {
            if (i == 0)
                System.out.print("[");
            else
                System.out.print(" ");
            System.out.print("Song [id=" + songIds.get(i) + "]");
            if (i != songIds.size() - 1)
                System.out.print(",");
            else
                System.out.print("]");
        }
        System.out.println();
    }
}
