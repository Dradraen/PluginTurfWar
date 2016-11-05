package com.github.dradraen.turfwar;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.dradraen.turfwar.commands.TurfWarCommand;
import com.github.dradraen.turfwar.listeners.PlayerIsMoving;

public class Main extends JavaPlugin {
	
	private Listener[] listenerList = {
		new PlayerIsMoving()
		//new PlayerJoinedGame	
	};
	
	@Override
	public void onEnable() {
		registerCommands();
		registerListeners();
	}
	
	private void registerCommands() {
		getCommand("turfwar").setExecutor(new TurfWarCommand(this));
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		for (Listener l : listenerList) {
			pm.registerEvents(l, this);
		}
	}
	
}
