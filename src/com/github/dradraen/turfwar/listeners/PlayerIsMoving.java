package com.github.dradraen.turfwar.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.github.dradraen.turfwar.Main;
import com.github.dradraen.turfwar.blocks.BlockHandler;
import com.github.dradraen.turfwar.scorekeeper.ETeam;
import com.github.dradraen.turfwar.scorekeeper.ScoreKeeperHandler;

public class PlayerIsMoving implements Listener {
	private Main plugin;
	private ScoreKeeperHandler scoreTracker;
	public PlayerIsMoving(Main plugin) {
		this.plugin = plugin;
		scoreTracker = new ScoreKeeperHandler(plugin);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		// If the player is one that we are currently watching for.
		if(plugin.getPlayers().containsKey(e.getPlayer())) {
			// If the player is moving onto a new block
			if ((int)e.getFrom().getX() != (int) e.getTo().getX() ||
					(int) e.getFrom().getY() != (int) e.getTo().getY() ||
					(int) e.getFrom().getZ() != (int) e.getTo().getZ()) {
				
				// Get the block beneath the player
				Block blockBeneathPlayer = e.getTo().clone().subtract(0, 1, 0).getBlock();
				BlockHandler bh = new BlockHandler(plugin);
				// check if it is wool
				if (bh.blockBeneathIsWool(blockBeneathPlayer)) {
					
					// Set the color of the wool dye color for that team
					if (plugin.getPlayers().get(e.getPlayer()).equals(ETeam.BLUE)) {
						bh.setBlockWoolColor(blockBeneathPlayer, ETeam.BLUE.getDyeColor());
					} else {
						bh.setBlockWoolColor(blockBeneathPlayer, ETeam.RED.getDyeColor());
					}
				}
				
			}
		}
	}
}