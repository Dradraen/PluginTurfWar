package com.github.dradraen.turfwar;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;

public class PlayerHandler {
	
	Player p;
	
	public PlayerHandler(Player p) {
		this.p = p;
	}
	
	public DyeColor getPlayerColor() {
		return DyeColor.BLACK;
	}
}
