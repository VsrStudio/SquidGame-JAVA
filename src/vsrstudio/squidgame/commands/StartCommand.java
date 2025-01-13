package com.vsrstudio.squidgame.commands;

import com.vsrstudio.squidgame.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class StartCommand extends BaseCommand {
    private final GameManager gameManager;

    public StartCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        gameManager.startGame();
        return true;
    }
}
