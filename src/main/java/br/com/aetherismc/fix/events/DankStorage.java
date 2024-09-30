package br.com.aetherismc.fix.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class DankStorage implements Listener {

	private static final List<String> players = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	@EventHandler(
		priority = EventPriority.HIGHEST
	)
	public void onDrop(PlayerDropItemEvent e) {
		if ( players.contains(e.getPlayer().getName().toLowerCase()) ) {
			players.remove(e.getPlayer().getName().toLowerCase());
			if ( e.getItemDrop().getItemStack().getTypeId() >= 6412 && e.getItemDrop().getItemStack().getTypeId() <= 6418 ) {
				e.getPlayer().updateInventory();
				e.setCancelled(true);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(
		priority = EventPriority.HIGH
	)
	public void onClick(PlayerInteractEvent e) {
		if ( e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ) {
			Player p = e.getPlayer();
			if ( p.getInventory().getItemInMainHand().getTypeId() >= 6412 && p.getInventory().getItemInMainHand().getTypeId() <= 6418 ) {
				players.add(p.getName().toLowerCase());
			}
		}
	}
}
