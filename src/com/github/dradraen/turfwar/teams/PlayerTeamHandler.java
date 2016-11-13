package com.github.dradraen.turfwar.teams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.DyeColor;

public class PlayerTeamHandler {
		private ArrayList<UUID> redTeam;
		private ArrayList<UUID> blueTeam;
		public HashMap<String,ArrayList<UUID>> teamList;
		public PlayerTeamHandler(){
			init();
		}
		public void init(){
			redTeam = new ArrayList<>();
			blueTeam = new ArrayList<>();
			teamList = new HashMap<>();
			teamList.put("Red", redTeam);
			teamList.put("Blue", blueTeam);
		}
		public ArrayList<UUID> getTeam(int teamIndex) {
			if(teamIndex == 0)
				return teamList.get("Red");
			return teamList.get("Blue");
		}
		public enum teamColor{
			RED,BLUE
		}
		public DyeColor determineColor(UUID playerID){
			if(redTeam.contains(playerID)){
				return DyeColor.RED;
			}
			return DyeColor.BLUE;
		}
}