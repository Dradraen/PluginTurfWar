package com.github.dradraen.turfwar.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.github.dradraen.turfwar.Main;
import com.github.dradraen.turfwar.PlayerHandler;
import com.github.dradraen.turfwar.blocks.BlockHandler;

public class PlayerIsMoving implements Listener {
	private Main plugin;
	
	public PlayerIsMoving(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public boolean onPlayerMove(PlayerMoveEvent e) {
		if(!changedBlocks(e)) {
			return false;
		}
		
		
		BlockHandler bh = new BlockHandler(plugin);
		PlayerHandler ph = new PlayerHandler(e.getPlayer());
		Block blockMovingTo = getBlockMovingTo(e);
		if (bh.blockBeneathIsWool(blockMovingTo)) {
			//bh.setBlockWoolColor(blockMovingTo, DyeColor.RED);
			bh.setBlockWoolColor(blockMovingTo, ph.getPlayerColor());
		}
		
		//Bukkit.broadcastMessage(plugin.getRanges().toString());
		return true;
	}
	
	private boolean changedBlocks(PlayerMoveEvent e) {
		if ((int) e.getFrom().getX() != (int) e.getTo().getX() ||
				(int) e.getFrom().getY() != (int) e.getTo().getY() ||
				(int) e.getFrom().getZ() != (int) e.getTo().getZ()) {
			return true;
		} else {
			return false;
		}
	}

	private Block getBlockMovingTo(PlayerMoveEvent e) {
		final Block forwardBlock = e.getTo().clone().subtract(0, 1, 0).getBlock();
		return forwardBlock;
	}
}
