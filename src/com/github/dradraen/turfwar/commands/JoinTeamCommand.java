package com.github.dradraen.turfwar.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.dradraen.turfwar.Main;
import com.github.dradraen.turfwar.scorekeeper.ETeam;

public class JoinTeamCommand implements CommandExecutor{

	private Main plugin;
	private String cUsage = ChatColor.GOLD + "REPLACE - <red/blue>";
	
	
	public JoinTeamCommand(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		// If the server sends the command then cancel
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.GOLD + "TW - Only players can join a team. ");
			return true;
		}
		
		// If the player sends wrong amount of parameters
		if (args.length != 1) {
			sender.sendMessage(cUsage.replace("REPLACE", commandLabel));
			return true;
		}
		
		// If the user sends the wrong color?
		if (!args[0].equalsIgnoreCase("blue") && !args[0].equalsIgnoreCase("red"))  {
			sender.sendMessage(cUsage.replace("REPLACE", commandLabel));
			return true;
		}
		
		
		// Add / Remove player from the teams.
		Player p = (Player) sender;
		
		if (args[0].equalsIgnoreCase("blue")) {
			p.sendMessage(ChatColor.GOLD + "TW - You joined " + ChatColor.BLUE + "blue " + ChatColor.GOLD + "team!");
			putPlayerOnTeam(p, ETeam.BLUE);
		} else {
			// If the player is already on blue team, remove them from the team.
			p.sendMessage(ChatColor.GOLD + "TW - You joined " + ChatColor.RED + "red " + ChatColor.GOLD + "team!");
			putPlayerOnTeam(p, ETeam.RED);
		}
		
		return true;
	}
	
	public void putPlayerOnTeam(Player p, ETeam team) {
		plugin.getPlayers().put(p, team);
	}
}