package com.vsrstudio.squidgame.stages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class GlassBridge {
    private final List<Player> players;
    private final int totalGlassTiles = 10;

    public GlassBridge(List<Player> players) {
        this.players = players;
    }

    public void startGame() {
        Bukkit.broadcastMessage("Glass Bridge game is starting!");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (players.isEmpty()) {
                    cancel();
                    Bukkit.broadcastMessage("No players left!");
                    return;
                }

                Random random = new Random();
                int correctTile = random.nextInt(totalGlassTiles);

                for (int i = 0; i < totalGlassTiles; i++) {
                    if (players.isEmpty()) {
                        cancel();
                        return;
                    }

                    Player player = players.get(i);

                    if (i == correctTile) {
                        player.sendMessage("Safe! You are on the correct glass tile.");
                    } else {
                        player.sendMessage("You stepped on a wrong tile! You have been eliminated!");
                        players.remove(player);
                    }
                }

                if (players.size() == 1) {
                    Player winner = players.get(0);
                    Bukkit.broadcastMessage(winner.getName() + " wins the Glass Bridge round!");
                    cancel();
                }
            }
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("SquidGame"), 30 * 20); // 30 seconds for Glass Bridge
    }
}
