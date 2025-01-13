package com.vsrstudio.squidgame.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class GameScoreboard {
    private final ScoreboardManager manager;
    private final Scoreboard scoreboard;
    private final Objective objective;

    public GameScoreboard() {
        manager = Bukkit.getScoreboardManager();
        scoreboard = manager.getNewScoreboard();
        objective = scoreboard.registerNewObjective("SquidGame", "dummy", ChatColor.AQUA + "Squid Game");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public void updateStage(String stage) {
        Score stageScore = objective.getScore(ChatColor.YELLOW + "Stage: " + ChatColor.WHITE + stage);
        stageScore.setScore(3);
    }

    public void updatePlayersLeft(int count) {
        Score playersLeftScore = objective.getScore(ChatColor.GREEN + "Players Left: " + ChatColor.WHITE + count);
        playersLeftScore.setScore(2);
    }

    public void updateWinner(String winnerName) {
        Score winnerScore = objective.getScore(ChatColor.GOLD + "Winner: " + ChatColor.WHITE + winnerName);
        winnerScore.setScore(1);
    }

    public void clearWinner() {
        scoreboard.resetScores(ChatColor.GOLD + "Winner: ");
    }

    public void assignToPlayer(Player player) {
        player.setScoreboard(scoreboard);
    }

    public void clear(Player player) {
        player.setScoreboard(manager.getNewScoreboard());
    }
}
