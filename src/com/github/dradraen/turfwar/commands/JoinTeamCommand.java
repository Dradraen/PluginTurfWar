package com.github.dradraen.turfwar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.dradraen.turfwar.Main;
import com.github.dradraen.turfwar.teams.PlayerTeamHandler;

public class JoinTeamCommand implements CommandExecutor{

	Main plugin;
	PlayerTeamHandler teamHandler = new PlayerTeamHandler();
	public JoinTeamCommand(Main plugin, PlayerTeamHandler TeamHandler){
		this.plugin = plugin;
		this.teamHandler = TeamHandler;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		int red = 0;
		int blue = 1;
		if(sender instanceof Player){
			if(args.length > 0){
				sender.sendMessage("You have too many arguments!");
				return true;
			}
			else{
					if(teamHandler.getTeam(red).contains(((Player) sender).getPlayer().getUniqueId())){
						sender.sendMessage("You are already on Team " + teamHandler.teamList.keySet().toArray()[red]);
						return true;
					}
					if(teamHandler.getTeam(blue).contains(((Player) sender).getPlayer().getUniqueId())){
						sender.sendMessage("You are already on Team " + teamHandler.teamList.keySet().toArray()[blue]);
						return true;
					}
					if(teamHandler.getTeam(red).size() <= teamHandler.getTeam(blue).size()){
						
						teamHandler.getTeam(red).add(((Player) sender).getPlayer().getUniqueId());
						sender.sendMessage("You have joined " + teamHandler.teamList.keySet().toArray()[red]);
					}
					else if(teamHandler.getTeam(blue).size() < teamHandler.getTeam(red).size()){
						
						teamHandler.getTeam(blue).add(((Player) sender).getPlayer().getUniqueId());
						sender.sendMessage("You have joined " + teamHandler.teamList.keySet().toArray()[blue]);
					}
				
				return true;
			}
		}
		else {
	        sender.sendMessage("You must be a player!");
	        return true;
	    }
	}
}