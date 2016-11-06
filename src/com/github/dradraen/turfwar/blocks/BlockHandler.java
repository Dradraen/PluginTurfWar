package com.github.dradraen.turfwar.blocks;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.github.dradraen.turfwar.Main;

public class BlockHandler {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public BlockHandler(Main plugin) {
		this.plugin = plugin;
	}

	public boolean blockBeneathIsWool(Block blockBeneathPlayer) {
		return blockBeneathPlayer.getType().equals(Material.WOOL);
	}
	
	@SuppressWarnings("deprecation")
	public void setBlockWoolColor(Block b, DyeColor d) {
		b.setData(d.getData());
	}
	
}
