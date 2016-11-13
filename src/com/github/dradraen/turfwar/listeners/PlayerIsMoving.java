package com.github.dradraen.turfwar.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.github.dradraen.turfwar.Main;
import com.github.dradraen.turfwar.blocks.BlockHandler;
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
		if(plugin.TeamHandler.teamList.get("Red").contains(e.getPlayer().getUniqueId()) ||plugin.TeamHandler.teamList.get("Blue").contains(e.getPlayer().getUniqueId()) ){
			if ((int)e.getFrom().getX() != (int) e.getTo().getX() ||
					(int) e.getFrom().getY() != (int) e.getTo().getY() ||
					(int) e.getFrom().getZ() != (int) e.getTo().getZ()) {
				Block blockBeneathPlayer = e.getTo().clone().subtract(0, 1, 0).getBlock();
				BlockHandler bh = new BlockHandler(plugin);
				if (bh.blockBeneathIsWool(blockBeneathPlayer)) {
					bh.setBlockWoolColor(blockBeneathPlayer, plugin.TeamHandler.determineColor(e.getPlayer().getUniqueId()));
					scoreTracker.calcScore(e.getPlayer().getUniqueId());
				}
			}
		}
	}
}