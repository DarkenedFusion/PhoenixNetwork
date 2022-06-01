package io.github.DarkenedFusion;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import io.github.DarkenedFusion.CooldownManager.CustomEffects;

public class WeaponAbilities implements Listener {

	
	@EventHandler
	public void onFireDagger(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		
		if(player.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Fire Knights Dagger")) {
				if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					 if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FIRECHARGE)) {
					Location loc = player.getLocation();
					
					int points = 5; // the amount of points the polygon should have.
		  			for (int iteration = 0; iteration < points; iteration++) {
		  			  double angle = 360.0 / points * iteration;
		  			  double nextAngle = 360.0 / points * (iteration + 1); // the angle for the next point.
		  			  angle = Math.toRadians(angle);
		  			  nextAngle = Math.toRadians(nextAngle); // convert to radians.
		  			  double x = Math.cos(angle);
		  			  double z = Math.sin(angle);
		  			  double x2 = Math.cos(nextAngle);
		  			  double z2 = Math.sin(nextAngle);
		  			  double deltaX = x2 - x; // get the x-difference between the points.
		  			  double deltaZ = z2 - z; // get the z-difference between the points.
		  			  double distance = Math.sqrt((deltaX - x) * (deltaX - x) + (deltaZ - z) * (deltaZ - z));
		  			  for (double d = 0; d < distance - .1; d += .1) { // we subtract .1 from the distance because otherwise it would make 1 step too many.
		  			    loc.add(x + deltaX * d, 0, z + deltaZ * d);
		  			    player.getWorld().spawnParticle(Particle.FLAME, loc, 5);
		  			    loc.subtract(x + deltaX * d, 0, z + deltaZ * d);
					
		  			ArrayList<LivingEntity> nearby = new ArrayList<LivingEntity>();
		  			double range = 5;
		  			for(Entity e : player.getNearbyEntities(range, range, range)) {
		  				if(e instanceof LivingEntity) {
		  					
		  					nearby.add((LivingEntity) e);
		  					
		  					e.setFireTicks(20*3);
		  					((LivingEntity) e).damage(3);
		  					
		  					
		  				}
		  	        
		  	        }
					
				  
					
					
				}
			}
		  			CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.FIRECHARGE, 5);
					 }
		}
	}
	
		}
	}
}
	
	
	
	

