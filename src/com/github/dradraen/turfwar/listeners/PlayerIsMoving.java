package com.github.dradraen.turfwar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerIsMoving implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Bukkit.broadcastMessage("Player is Moving!");
	}
}
