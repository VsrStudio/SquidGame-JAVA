package com.vsrstudio.squidgame;

import com.vsrstudio.squidgame.stages.RedLightGreenLight;
import com.vsrstudio.squidgame.utils.GameScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<Player> players = new ArrayList<>();
    private boolean gameRunning = false;
    private final GameScoreboard scoreboard = new GameScoreboard();

    public void startGame() {
        if (gameRunning) {
            Bukkit.broadcastMessage("Game is already running!");
            return;
        }
        if (players.size() < 2) {
            Bukkit.broadcastMessage("Not enough players to start!");
            return;
        }

        gameRunning = true;

        players.forEach(scoreboard::assignToPlayer);
        scoreboard.updatePlayersLeft(players.size());
        scoreboard.updateStage("Red Light, Green Light");

        new RedLightGreenLight(players).startGame();
    }

    public void stopGame() {
        gameRunning = false;
        players.forEach(scoreboard::clear);
        players.clear();
        Bukkit.broadcastMessage("Game has been stopped.");
    }

    public void addPlayer(Player player) {
        if (players.contains(player)) {
            player.sendMessage("You are already in the game!");
            return;
        }
        players.add(player);
        player.sendMessage("You joined the Squid Game!");
    }

    public void removePlayer(Player player) {
        players.remove(player);
        scoreboard.updatePlayersLeft(players.size());
        player.sendMessage("You left the Squid Game!");
    }

    public void announceWinner(Player winner) {
        scoreboard.updateWinner(winner.getName());
        Bukkit.broadcastMessage("Winner: " + winner.getName());
    }
}
