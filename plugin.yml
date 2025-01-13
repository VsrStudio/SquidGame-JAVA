package com.vsrstudio.squidgame;

import com.vsrstudio.squidgame.commands.JoinCommand;
import com.vsrstudio.squidgame.commands.LeaveCommand;
import com.vsrstudio.squidgame.commands.StartCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class SquidGame extends JavaPlugin {
    private GameManager gameManager;

    @Override
    public void onEnable() {
        getLogger().info("SquidGame plugin enabled!");
        saveDefaultConfig();
        gameManager = new GameManager();

        getCommand("join").setExecutor(new JoinCommand(gameManager));
        getCommand("leave").setExecutor(new LeaveCommand(gameManager));
        getCommand("start").setExecutor(new StartCommand(gameManager));
    }

    @Override
    public void onDisable() {
        getLogger().info("SquidGame plugin disabled!");
    }
}
