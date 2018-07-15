package me.ryandw11.test;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements CommandExecutor{
	
	@Override
	public void onEnable(){
		getCommand("testswitch").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if(!(sender instanceof Player)){
			getLogger().info("This command is for players only!");
			return true;
		}
		Player p = (Player) sender;
		if(p.getInventory().getItemInMainHand().getType() == null || p.getInventory().getItemInMainHand().getType() == Material.AIR){
			return true;
		}
		switch(p.getInventory().getItemInMainHand().getType()){
		case GOLD_INGOT:
			p.sendMessage("gold ingot");
			break;
		case DIRT:
			p.sendMessage("dirt");
			break;
		default:
			p.sendMessage("I don't know that item!");
			break;
		}
		return false;
	}
	
	

}
