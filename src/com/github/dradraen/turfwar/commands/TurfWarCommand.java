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
		Bukkit.broadcastMessage("Inside TurfWarCommand.java");
		return false;
	}
}
