package com.github.dradraen.turfwar.teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerTeamHandler {
		private ScoreboardManager manager = Bukkit.getScoreboardManager();
		private Scoreboard board = manager.getNewScoreboard();
		public Team redTeam = board.registerNewTeam("RED");
		public Team blueTeam = board.registerNewTeam("BLUE");
		private Objective objective = board.registerNewObjective("Turf", "level");
		public int[] teamScore = new int[2];
		public void init()
		{
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName("Turf Claimed");
			for(Player p: Bukkit.getServer().getOnlinePlayers())
			{
				redTeam.addEntry(p.getName());
				@SuppressWarnings("deprecation")
				Score score = objective.getScore(p);
				score.setScore(0);
			}
		}
		public void setTeamScore(Team team)
		{
			
		}
		
}
