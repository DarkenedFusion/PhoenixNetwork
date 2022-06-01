package io.github.DarkenedFusion;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener  {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		this.getCommand("grant").setExecutor(new Commands());
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new FireKnight(), this);
		this.getServer().getPluginManager().registerEvents(new WeaponAbilities(), this);
		
	}
	

	
	public static BossBar createBossBar(LivingEntity livingEntity, String title, BarColor color, BarStyle style) {
		  BossBar bb = Bukkit.getServer().createBossBar(title, color, style);
		  
		  new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				  if(!livingEntity.isDead()) {
					  for(Player player : Bukkit.getOnlinePlayers()) {
						  bb.addPlayer(player);
					  }
					  bb.setProgress(livingEntity.getHealth() / livingEntity.getMaxHealth());
				  }
				  
				  
				  
				  
				  else {
					  List<Player> players = bb.getPlayers();
			           for (Player player : players) {
			               bb.removePlayer(player);
			           }
			           bb.setVisible(false);
			           cancel();
				  }
				  
				
				
			}
			  
		  }.runTaskTimer(Main.getInstance(), 0, 1);
		return bb;
	}

	
	public static Main getInstance() {
		return instance;
	}
	
	

}
