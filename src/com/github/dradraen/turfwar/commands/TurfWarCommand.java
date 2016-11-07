package com.github.dradraen.turfwar.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.github.dradraen.turfwar.Main;

public class TurfWarCommand implements CommandExecutor {

	Main plugin;
	
	public TurfWarCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		
		if (args.length == 6) {
			// Create Command
			
			plugin.getConfig().set("arenacords.height", Integer.valueOf(args[1]));
			plugin.getConfig().set("arenacords.topleft.x", Integer.valueOf(args[2]));
			plugin.getConfig().set("arenacords.topleft.z", Integer.valueOf(args[3]));
			plugin.getConfig().set("arenacords.bottomright.x", Integer.valueOf(args[4]));
			plugin.getConfig().set("arenacords.bottomright.z", Integer.valueOf(args[5]));
			plugin.saveConfig();
		}
		
		Bukkit.broadcastMessage("Inside TurfWarCommand.java");
		return false;
	}

}
