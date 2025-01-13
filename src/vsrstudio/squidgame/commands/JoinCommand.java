package com.vsrstudio.squidgame.commands;

import com.vsrstudio.squidgame.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand extends BaseCommand {
    private final GameManager gameManager;

    public JoinCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            gameManager.addPlayer(player);
        }
        return true;
    }
}
