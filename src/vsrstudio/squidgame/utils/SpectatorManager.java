package com.vsrstudio.squidgame.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class SpectatorManager {
    private final Set<Player> spectators = new HashSet<>();

    public void addSpectator(Player player) {
        if (!spectators.contains(player)) {
            spectators.add(player);
            player.setGameMode(org.bukkit.GameMode.SPECTATOR);
            player.sendMessage("You are now spectating the game.");
        }
    }

    public void removeSpectator(Player player) {
        if (spectators.contains(player)) {
            spectators.remove(player);
            player.setGameMode(org.bukkit.GameMode.SURVIVAL);
            player.sendMessage("You are no longer spectating.");
        }
    }

    public Set<Player> getSpectators() {
        return spectators;
    }

    public void resetSpectators() {
        for (Player player : spectators) {
            player.setGameMode(org.bukkit.GameMode.SURVIVAL);
            player.sendMessage("Spectating ended.");
        }
        spectators.clear();
    }
}
