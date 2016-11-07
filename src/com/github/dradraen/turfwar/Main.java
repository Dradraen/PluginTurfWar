package com.github.dradraen.turfwar;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.dradraen.turfwar.commands.TurfWarCommand;
import com.github.dradraen.turfwar.listeners.PlayerIsMoving;

public class Main extends JavaPlugin {
	int rangeX;
	int rangeZ;
	byte[][] woolBlocks;
	
	private Listener[] listenerList = {
		new PlayerIsMoving(this)
		//new PlayerJoinedGame	
	};
	
	@Override
	public void onEnable() {
		loadConfig();
		registerCommands();
		registerListeners();
	}
	
	private void loadConfig() {
		this.saveDefaultConfig();
		
		rangeX = Math.abs(this.getConfig().getInt("arenacords.bottomright.x") - this.getConfig().getInt("arenacords.topleft.x"));
		rangeZ = Math.abs(this.getConfig().getInt("arenacords.bottomright.z") - this.getConfig().getInt("arenacords.topleft.z"));
		woolBlocks = new byte[rangeX][rangeZ];

	}
	
	private void registerCommands() {
		getCommand("turfwar").setExecutor(new TurfWarCommand(this));
		getCommand("turfwar create").setExecutor(new TurfWarCommand(this));
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();
		for (Listener l : listenerList) {
			pm.registerEvents(l, this);
		}
	}
	
	public List<Integer> getRanges() {
		List<Integer> ourlist = new ArrayList<>();
		ourlist.add(rangeX);
		ourlist.add(rangeZ);
		return ourlist;
	}
	
}
