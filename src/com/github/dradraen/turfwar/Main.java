package com.github.dradraen.turfwar;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.dradraen.turfwar.commands.JoinTeamCommand;
import com.github.dradraen.turfwar.commands.TurfWarCommand;
import com.github.dradraen.turfwar.listeners.PlayerIsMoving;
import com.github.dradraen.turfwar.scorekeeper.ETeam;
import com.github.dradraen.turfwar.teams.PlayerTeamHandler;

public class Main extends JavaPlugin {
	
	private Map<Player, ETeam> players;
	
	public PlayerTeamHandler TeamHandler = new PlayerTeamHandler();
	
	public Listener[] listenerList = {
		new PlayerIsMoving(this)
		//TODO Player leaves and joins the game. 
	};
	
	@Override
	public void onEnable() {
		players = new HashMap<>();
		
		registerCommands();
		registerListeners();
		
	}
	
	private void registerCommands() {
		getCommand("turfwar").setExecutor(new TurfWarCommand(this));
		getCommand("twjoin").setExecutor(new JoinTeamCommand(this));
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		for (Listener l : listenerList) {
			pm.registerEvents(l, this);
		}
	}
	
	public Map<Player, ETeam> getPlayers() {
		return players;
	}
}