package io.github.DarkenedFusion;

import java.awt.List;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemAtlas {
	
	
	public ItemStack flameDagger() {
		
		ItemStack dagger = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta = dagger.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Fire Knights Dagger");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RED + "Ability: " + ChatColor.DARK_RED + "Flame Flare");
		lore.add(ChatColor.GOLD + "Sends a circle of flames to nearby enemies");
		meta.setLore(lore);
		dagger.setItemMeta(meta);
		
		return dagger;
	}

}
