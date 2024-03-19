package com.example.demo.commands;

import java.util.List;
import com.example.demo.Player;

public class NextSongCommand implements ICommand {
    private final Player player;

    public NextSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        String result = this.player.onNext();
        System.out.println(result);
    }
}
