package com.github.dradraen.turfwar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerIsMoving implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		
		if ((int)e.getFrom().getX() != (int) e.getTo().getX() ||
				(int) e.getFrom().getY() != (int) e.getTo().getY() ||
				(int) e.getFrom().getZ() != (int) e.getTo().getZ()) {
		// Player is Moving coords
			Bukkit.broadcastMessage(e.getPlayer().getLocation().toString());
		}
	}
}
