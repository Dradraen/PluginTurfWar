package com.github.dradraen.turfwar.scorekeeper;

import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.io.output.ThresholdingOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.github.dradraen.turfwar.Main;

public class ScoreKeeperHandler{
	private Scoreboard board;
	private Objective obj;
	private Score redScore;
	private Score blueScore;
	private HashMap<> scores;
	private Main plugin;
	public ScoreKeeperHandler(Main plugin){
		this.plugin = plugin;
		scores = new HashMap<plugin.TeamHandler, Score>();
	}
	@SuppressWarnings("deprecation")
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(plugin.listenerList[0], plugin);
		board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
		
		obj = board.registerNewObjective("turf", "dummy");
		obj.setDisplayName("Turf Obtained");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		 
	}
	@EventHandler
	public void onPlayerTJoin(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		p.setScoreboard(board);
		if(plugin.TeamHandler.teamList.get("Red").contains(p.getPlayer().getUniqueId())scores.get("Red")){
			
		}
	}
	public void calcScore(UUID userID)
	{
		if(plugin.TeamHandler.teamList.get("Red").contains(userID)){
			
		}
		else{
			
		}
		
	}
}
