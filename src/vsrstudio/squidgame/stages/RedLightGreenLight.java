package com.vsrstudio.squidgame.stages;

import com.vsrstudio.squidgame.utils.GameScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class RedLightGreenLight {
    private final List<Player> players;
    private final GameScoreboard scoreboard = new GameScoreboard();
    private boolean isRedLight = false;

    public RedLightGreenLight(List<Player> players) {
        this.players = players;
    }

    public void startGame() {
        Bukkit.broadcastMessage("Red Light, Green Light game is starting!");
        new BukkitRunnable() {
            @Override
            public void run() {
                if (players.isEmpty()) {
                    Bukkit.broadcastMessage("No players left!");
                    cancel();
                    return;
                }

                isRedLight = new Random().nextBoolean();
                Bukkit.broadcastMessage(isRedLight ? "Red Light!" : "Green Light!");

                if (isRedLight) {
                    for (Player player : players) {
                        if (player.isSprinting() || player.isMoving()) {
                            Bukkit.broadcastMessage(player.getName() + " has been eliminated!");
                            players.remove(player);

                            scoreboard.updatePlayersLeft(players.size());
                        }
                    }
                }

                if (players.size() == 1) {
                    Player winner = players.get(0);
                    Bukkit.broadcastMessage(winner.getName() + " wins this round!");
                    scoreboard.updateWinner(winner.getName());
                    cancel();
                }
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("SquidGame"), 0, 20 * 5);
    }
}
