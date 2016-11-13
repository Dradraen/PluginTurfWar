package com.github.dradraen.turfwar.scorekeeper;

import org.bukkit.DyeColor;

public enum ETeam {
	BLUE(DyeColor.BLUE),
	RED(DyeColor.RED);
	
	private DyeColor d;
	
	ETeam(DyeColor d) {
		this.d = d;
	}
	
	public DyeColor getDyeColor() {
		return this.d;
	}
	
}
