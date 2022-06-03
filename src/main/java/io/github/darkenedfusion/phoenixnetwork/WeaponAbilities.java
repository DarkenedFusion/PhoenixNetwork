package io.github.darkenedfusion.phoenixnetwork;

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
import org.bukkit.scheduler.BukkitRunnable;

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
		  			CooldownManager.setCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FIRECHARGE, 5);
					 }
		}
	}
	
		}
	}


	@EventHandler
	public void onFlamePillarScroll(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();

		if (player.getInventory().getItemInMainHand().getType().equals(Material.PAPER)) {
			if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Flame Pillar Scroll")) {
				if (a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
					if (!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FLAMEPILLAR)) {
						Location loc = player.getLocation();


						Location location1 = player.getEyeLocation();
						Location location2 = player.getEyeLocation();
						Location location3 = player.getEyeLocation();
						Location location4 = player.getEyeLocation();
						Location location5 = player.getEyeLocation();
						Location location6 = player.getEyeLocation();
						Location location7 = player.getEyeLocation();


						int particles = 50;
						float radius = 2.0f;
						for (int i = 0; i < particles; i++) {
							double angle, x, z;
							angle = 2 * Math.PI * i / particles;
							x = Math.cos(angle) * radius;
							z = Math.sin(angle) * radius;
							location1.add(x, 5, z);
							location2.add(x, 4, z);
							location3.add(x, 3, z);
							location4.add(x, 2, z);
							location5.add(x, 1, z);
							location6.add(x, 0, z);
							location7.add(x, -1, z);

							player.getWorld().spawnParticle(Particle.FLAME, location1, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location2, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location3, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location4, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location5, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location6, 0, 0, 0, 0, 1);
							player.getWorld().spawnParticle(Particle.FLAME, location7, 0, 0, 0, 0, 1);


							location1.subtract(x, 5, z);
							location2.subtract(x, 4, z);
							location3.subtract(x, 3, z);
							location4.subtract(x, 2, z);
							location5.subtract(x, 1, z);
							location6.subtract(x, 0, z);
							location7.subtract(x, -1, z);

							ArrayList<LivingEntity> nearby = new ArrayList<LivingEntity>();
							double range = 5;
							for(Entity e : player.getNearbyEntities(range, range, range)) {
								if(e instanceof LivingEntity) {

									nearby.add((LivingEntity) e);

									e.setFireTicks(20*5);
									((LivingEntity) e).damage(10);

								//Enemy explosion effect
									Location eLoc = e.getLocation();

									if(!e.isDead()){
									int points = 1; // the amount of points the polygon should have.
									for (int iteration = 0; iteration < points; iteration++) {
										double angle1 = 360.0 / points * iteration;
										double nextAngle = 360.0 / points * (iteration + 1); // the angle for the next point.
										angle1 = Math.toRadians(angle1);
										nextAngle = Math.toRadians(nextAngle); // convert to radians.
										double x1 = Math.cos(angle1);
										double z1 = Math.sin(angle1);
										double x2 = Math.cos(nextAngle);
										double z2 = Math.sin(nextAngle);
										double deltaX = x2 - x1; // get the x1-difference between the points.
										double deltaZ = z2 - z1; // get the z1-difference between the points.
										double distance = Math.sqrt((deltaX - x1) * (deltaX - x1) + (deltaZ - z1) * (deltaZ - z1));
										for (double d = 0; d < distance - .1; d += .1) { // we subtract .1 from the distance because otherwise it would make 1 step too many.
											eLoc.add(x1 + deltaX * d, 0, z1 + deltaZ * d);
											e.getWorld().spawnParticle(Particle.FLAME, eLoc, 1);
											eLoc.subtract(x1 + deltaX * d, 0, z1 + deltaZ * d);



										}
									 }
									}
								}
							}
						}
						CooldownManager.setCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FLAMEPILLAR, 5);
					}
				}
			}
		}
	}









}
	
	
	
	

