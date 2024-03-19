package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        Integer n = tokens.size();
        List<Long> ids = new ArrayList<Long>();
        for (int i = 2; i < n; i++)
            ids.add(Long.parseLong(tokens.get(i)));
        Playlist createPlaylist = playlistService.create(name, ids);
        System.out.println(createPlaylist);
    }
}
