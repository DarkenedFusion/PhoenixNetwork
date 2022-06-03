package io.github.darkenedfusion.phoenixnetwork;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.jeff_media.jefflib.JeffLib;
import de.jeff_media.jefflib.SkullUtils;

public class ItemAtlas {
	

	private String FIRECORE_ID = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc1YmNhMWFmNWNiMTU1N2MxNzk0ZDIzZDkwN2RmMTE1OTMyMGUxNGViYTA1ODFjMjUxODdkYmViMjJiYTJjYyJ9fX0=";
	private String FLAMEGEM_ID = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjgyZWUyODliOTFmZjM5YTk3ZDM5YjlhYzVmYjlhOGU0MzQ4NDA0ZjI3NjQzYWYyNDk1ODU5MDI3YjM0NDUwMyJ9fX0=";
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
		
		ItemStack fCore = SkullUtils.getHead(FIRECORE_ID);
		ItemMeta meta = fCore.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "Fire Core");

		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "The core is hot to the touch.");
		meta.setLore(lore);
		fCore.setItemMeta(meta);
		
		return fCore;
	}

	public ItemStack flameGem() {

		ItemStack fGem = SkullUtils.getHead(FLAMEGEM_ID);
		ItemMeta meta = fGem.getItemMeta();

		meta.setDisplayName(ChatColor.DARK_RED + "Flame Gem");



		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "An incredibly rare gemstone.");



		meta.setLore(lore);
		fGem.setItemMeta(meta);

		return fGem;
	}


	public ItemStack flamePillarScroll() {

		ItemStack fScroll = new ItemStack(Material.PAPER);
		ItemMeta meta = fScroll.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Flame Pillar Scroll");


		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.RED + "Ability: " + ChatColor.DARK_RED + "Flame Pillar");
		lore.add(ChatColor.GOLD + "Release a giant pillar of flames.");



		meta.setLore(lore);
		fScroll.setItemMeta(meta);

		return fScroll;
	}


	public ItemStack fireKnightEgg(){
		ItemStack fireEgg = new ItemStack(Material.FIREWORK_STAR);
		ItemMeta meta = fireEgg.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Fire Knight Egg");


		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Contains the Fire Knight Boss");
		meta.setLore(lore);
		fireEgg.setItemMeta(meta);

		return fireEgg;

	}
}
