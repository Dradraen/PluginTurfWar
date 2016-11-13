package com.github.dradraen.turfwar;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.dradraen.turfwar.commands.JoinTeamCommand;
import com.github.dradraen.turfwar.commands.TurfWarCommand;
import com.github.dradraen.turfwar.listeners.PlayerIsMoving;
import com.github.dradraen.turfwar.teams.PlayerTeamHandler;

public class Main extends JavaPlugin {
	public PlayerTeamHandler TeamHandler = new PlayerTeamHandler();
	public Listener[] listenerList = {
		new PlayerIsMoving(this)
		//new PlayerJoinedGame	
	};
	
	@Override
	public void onEnable() {
		registerCommands();
		registerListeners();
		
	}
	
	private void registerCommands() {
		getCommand("turfwar").setExecutor(new TurfWarCommand(this));
		getCommand("join").setExecutor(new JoinTeamCommand(this,TeamHandler));
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		for (Listener l : listenerList) {
			pm.registerEvents(l, this);
		}
	}
}