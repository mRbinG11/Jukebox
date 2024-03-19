package com.example.demo.commands;

import java.util.List;
import com.example.demo.Player;

public class StopSongCommand implements ICommand {
    private final Player player;

    public StopSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        String result = this.player.onStop();
        System.out.println(result);
    }
}
