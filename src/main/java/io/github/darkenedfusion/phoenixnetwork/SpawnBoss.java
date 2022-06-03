package io.github.darkenedfusion.phoenixnetwork;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnBoss implements Listener {
	
	private FireKnight fKnight = new FireKnight();
	
	
	
	
	
	
	
	//SPAWNS THE FIRE KNIGHT
	

	@EventHandler
	public void spawnFireBoss(PlayerInteractEvent event){
		Player player = event.getPlayer();
		Action a = event.getAction();

		if(player.getInventory().getItemInMainHand().getType().equals(Material.FIREWORK_STAR)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Fire Knight Egg")) {
				if (a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					fKnight.createFireKnight(player.getLocation());
					player.getInventory().remove(player.getInventory().getItemInMainHand());

				}
			}
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
