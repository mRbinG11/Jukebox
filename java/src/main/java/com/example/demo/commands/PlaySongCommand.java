package com.example.demo.commands;

import java.util.List;
import com.example.demo.Player;

public class PlaySongCommand implements ICommand {
    private final Player player;

    public PlaySongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        String result = this.player.onPlay();
        System.out.println(result);
    }
}
