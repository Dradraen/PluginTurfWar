package com.github.dradraen.turfwar.scorekeeper;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.github.dradraen.turfwar.Main;

public class ScoreKeeperHandler{
	private Scoreboard board;
	private Objective obj;
	private Main plugin;
	public ScoreKeeperHandler(Main plugin){
		this.plugin = plugin;
	}
	
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
	}

}
