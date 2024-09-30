package br.com.aetherismc.fix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.aetherismc.fix.events.BlockChestShop;
import br.com.aetherismc.fix.events.DankStorage;

public class Core extends JavaPlugin {
	
	public static List<String> blockChestShop = new ArrayList<String>(Arrays.asList(
			"5909", "5919", "5918", "5910", "5911", "5912", "5913", "5914", "5915", "5916", "5917", "5902", "5902", "6401", "8100", "7518", "7519", "4455"
	));
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new DankStorage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockChestShop(), this);
	}
}
