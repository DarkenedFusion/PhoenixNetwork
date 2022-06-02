package io.github.DarkenedFusion;

import org.bukkit.ChatColor;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import io.github.DarkenedFusion.CooldownManager.CustomEffects;

public class SpawnBoss implements Listener {
	
	private FireKnight fKnight = new FireKnight();
	
	
	
	
	
	
	
	//SPAWNS THE FIRE KNIGHT
	
/*	
	@EventHandler
	public void onNetherDeath(EntityDeathEvent event) {
		if(event.getEntity() instanceof MagmaCube){
			if(event.getEntity().getCustomName().contains("Fire Knight")) {
				return;
			}
		}
			
		if(event.getEntity().getWorld().getName().equals("world_nether") ||
				event.getEntity().getWorld().getName().equals("SMP_nether")) {
			if(event.getEntity().getKiller() instanceof Player) {
				Player player = event.getEntity().getKiller();
				double random = Math.random();
				if(random <= 0.15D) {
					 if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FIREKNIGHTSPAWN)) {
					player.sendMessage(ChatColor.DARK_RED + "The " + ChatColor.GOLD + "Fire Knight " + ChatColor.DARK_RED + "has risen!");
					fKnight.createFireKnight(player.getLocation());
					
						CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.FIREKNIGHTSPAWN, 1800);
					 }
				}
				
				
			}
		}
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
