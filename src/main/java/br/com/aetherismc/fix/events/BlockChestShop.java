package br.com.aetherismc.fix.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Acrobot.Breeze.Utils.MaterialUtil;
import com.Acrobot.ChestShop.Events.PreShopCreationEvent;
import com.Acrobot.ChestShop.Events.PreShopCreationEvent.CreationOutcome;

import br.com.aetherismc.fix.Core;

public class BlockChestShop implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(
		priority = EventPriority.LOWEST
	)
	public void onShop(PreShopCreationEvent e) {
		String itemCode = e.getSignLine((byte) 3);
		if ( !itemCode.equalsIgnoreCase("§l?") ) {
			ItemStack item = MaterialUtil.getItem(itemCode);
			
			if ( Core.blockChestShop.contains(String.valueOf(item.getTypeId())) || Core.blockChestShop.contains(item.getTypeId() + ":" + item.getData().getData()) ) {
				e.setOutcome(CreationOutcome.NO_PERMISSION);
			}
		}
	}
}
