package io.github.darkenedfusion.phoenixnetwork;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class GameManager implements Listener {

    @EventHandler
    public void preventPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(event.getBlock().getType() == Material.PLAYER_HEAD) {

            event.setCancelled(true);
        }


    }


}
