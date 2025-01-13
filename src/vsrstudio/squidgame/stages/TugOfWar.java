package com.vsrstudio.squidgame.stages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class TugOfWar {
    private final List<Player> team1;
    private final List<Player> team2;

    public TugOfWar(List<Player> team1, List<Player> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void startGame() {
        Bukkit.broadcastMessage("Tug of War game is starting!");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (team1.isEmpty() || team2.isEmpty()) {
                    cancel();
                    Bukkit.broadcastMessage("One or more teams have no players left!");
                    return;
                }

                if (Math.random() < 0.5) {
                    Bukkit.broadcastMessage("Team 1 wins the Tug of War!");
                    team2.forEach(player -> Bukkit.broadcastMessage(player.getName() + " has been eliminated!"));
                    team2.clear();
                } else {
                    Bukkit.broadcastMessage("Team 2 wins the Tug of War!");
                    team1.forEach(player -> Bukkit.broadcastMessage(player.getName() + " has been eliminated!"));
                    team1.clear();
                }
            }
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("SquidGame"), 60 * 20); // 60 seconds for tug of war
    }
}
