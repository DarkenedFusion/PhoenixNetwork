package io.github.darkenedfusion.phoenixnetwork;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.jeff_media.jefflib.JeffLib;
import de.jeff_media.jefflib.SkullUtils;

public class ItemAtlas {
	

	private String FIRECORE_ITEM = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc1YmNhMWFmNWNiMTU1N2MxNzk0ZDIzZDkwN2RmMTE1OTMyMGUxNGViYTA1ODFjMjUxODdkYmViMjJiYTJjYyJ9fX0=";
	
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
	
	public ItemStack fireCore() {
		
		ItemStack fCore = SkullUtils.getHead(FIRECORE_ITEM);
		ItemMeta meta = fCore.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Fire Core");
		meta.setUnbreakable(true);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "The core is hot to the touch.");
		meta.setLore(lore);
		fCore.setItemMeta(meta);
		
		return fCore;
	}

}
