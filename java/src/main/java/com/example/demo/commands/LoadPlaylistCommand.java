package com.example.demo.commands;

import java.util.List;
import com.example.demo.Player;

public class LoadPlaylistCommand implements ICommand {
    private final Player player;

    public LoadPlaylistCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        String result = this.player.loadPlaylist(name);
        System.out.println(result);
    }
}
