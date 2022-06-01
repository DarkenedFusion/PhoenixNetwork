package io.github.DarkenedFusion;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	
	private FireKnight fKnight = new FireKnight();
	private ItemAtlas atlas = new ItemAtlas();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

			
	if(label.equalsIgnoreCase("grant")) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Console can't do this!");
			return true;
		}
	}
	Player player = (Player) sender;
	if(args[0].length() == 0) {
		player.sendMessage("Please insert the correct parameters!");
	}
	
	if(player.isOp() && args[0].equalsIgnoreCase("fKnight")) {
		fKnight.createFireKnight(player.getLocation());
		
	}
	if(player.isOp() && args[0].equalsIgnoreCase("fDagger")) {
		player.getInventory().addItem(atlas.flameDagger());
		
	}
	return false;
	
	}

}
