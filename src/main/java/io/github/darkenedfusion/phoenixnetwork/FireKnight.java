package io.github.darkenedfusion.phoenixnetwork;

import org.bukkit.*;
import org.bukkit.attribute.Attributable;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class FireKnight implements Listener {
	
	private ItemAtlas atlas = new ItemAtlas();
	
	
	
	@SuppressWarnings("deprecation")
	public void createFireKnight(Location location) {
		MagmaCube fKnight = (MagmaCube) location.getWorld().spawnEntity(location, EntityType.MAGMA_CUBE);
		fKnight.setCustomName(ChatColor.GOLD + "Fire Knight");
		fKnight.setCustomNameVisible(true);
		Attributable knightAI = fKnight;
		Main.createBossBar(fKnight, ChatColor.GOLD + "Fire Knight", BarColor.RED, BarStyle.SOLID);
		fKnight.setSize(10);
		fKnight.setMaxHealth(300);
		fKnight.setHealth(300);
		
		
	}
	

	
	
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof MagmaCube) {
			MagmaCube boss = (MagmaCube) event.getEntity();
			if(boss.getCustomName().equals(ChatColor.GOLD + "Fire Knight")) {
				if(event.getDamager() instanceof Player) {
					Player player = (Player) event.getDamager();
					
					double randDouble = Math.random();
					double randDouble1 = Math.random();
					if(randDouble <= 0.25) {
						
						flamePillar(player);
					}
					
					if(randDouble1 <= 0.15) {
						fireDrop(boss);
					}
					
					
				}
				if(event.getDamager() instanceof Projectile){
					Projectile arrow = (Projectile) event.getDamager();
						Player player = (Player) arrow.getShooter();

						arrow.setVelocity(arrow.getLocation().getDirection().multiply(-2));

						event.setCancelled(true);
						arrow.remove();

				}
				
			}
		}
	}


	
	
	
	@EventHandler
	public void disableSplit(SlimeSplitEvent event) {
			if(event.getEntity() instanceof MagmaCube) {
				MagmaCube mc = (MagmaCube) event.getEntity();
				if(mc.getCustomName().equals(ChatColor.GOLD + "Fire Knight")) {
					event.setCancelled(true);
				}
			}
	}

	
	private void flamePillar(Player player) {
		
		   Location loc = player.getLocation();
           double radius = 1.5;
           for(double y = 0; y <= 100; y+=0.05) {
               double x = radius * Math.cos(y);
               double z = radius * Math.sin(y);
              loc.getWorld().spawnParticle(Particle.FLAME, (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0,0, 0, 1);
              player.getWorld().playSound(loc, Sound.ENTITY_BLAZE_BURN, 0.1f, 0.5f);
           }
           
           player.setVelocity(new Vector(0, 1, 0));
           player.setFireTicks(20*5);
		
	}
	
	private void fireDrop(final LivingEntity boss) {
		
		   boss.setVelocity(new Vector(0, 10, 0));
		   boss.setGravity(false);
		   boss.getWorld().playSound(boss.getLocation(), Sound.BLOCK_ANVIL_LAND, 5, 0.1f);
		   new BukkitRunnable() {
			   double t = 0;
			   public void run() {
				   t++;
				   
				   if(t >= 30) {
					   boss.setGravity(true);
					   
					   Location loc = boss.getLocation();

					   int points = 20; // the amount of points the polygon should have.
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
			  			    boss.getWorld().spawnParticle(Particle.FLAME, loc, 20);
			  			    loc.subtract(x + deltaX * d, 0, z + deltaZ * d);
			  			  }
			  			}
					   
					  
				   	
				   }
				   
				   if(t > 60) {
					   boss.setInvulnerable(true);
					   boss.getWorld().createExplosion(boss.getLocation(), 0, false);
					   ArrayList<LivingEntity> nearby = new ArrayList<LivingEntity>();
					   double range = 10;
					   for(Entity e : boss.getNearbyEntities(range, range, range)) {
						   if (e instanceof LivingEntity) {

							   nearby.add((LivingEntity) e);


							   ((LivingEntity) e).damage(6);
						   }
					   }

					   boss.setInvulnerable(false);
					   this.cancel();


				   }
			   }
		   }.runTaskTimer(Main.getInstance(), 0, 1);
			       

	}
	
	@EventHandler
	public void customDrop(EntityDeathEvent event) {
		if(event.getEntity() instanceof MagmaCube) {
			MagmaCube boss = (MagmaCube) event.getEntity();
			if(boss.getCustomName().equals(ChatColor.GOLD + "Fire Knight")) {
					Random random = new Random();

				if (random.nextInt(101) <= 50) {

					boss.getWorld().dropItem(boss.getLocation(), new ItemStack(Material.IRON_INGOT));
				}
				if (random.nextInt(101) <= 10) {

					boss.getWorld().dropItem(boss.getLocation(), atlas.flameDagger());
				}
				if (random.nextInt(101) <= 1) {

					boss.getWorld().dropItem(boss.getLocation(), atlas.fireCore());
				}
				if (random.nextInt(101) <= 0.5) {

					boss.getWorld().dropItem(boss.getLocation(), atlas.flameGem());

				}
			}
		}
	}
	

}
