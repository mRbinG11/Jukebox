package com.example.demo.commands;

import java.util.List;
import com.example.demo.Player;

public class PreviousSongCommand implements ICommand {
    private final Player player;

    public PreviousSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        String result = this.player.onPrevious();
        System.out.println(result);
    }
}
