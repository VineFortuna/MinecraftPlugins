package main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("[CommandsTutorial] was successfully loaded!"); //When server starts and there is no plugin issues
	}
	
	@Override
	public void onDisable() {
		getLogger().info("[CommandsTutorial] was successfully disabled!"); //When server stops
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player) { //Checks if the person using the command is a real Player
			
			if (cmd.getName().equalsIgnoreCase("testcmd")) {
				player.sendMessage("This is a test!");
			}
			
			if (cmd.getName().equalsIgnoreCase("info")) {
				player.sendMessage("This plugin is working!! :)");
			}
		} else {
			sender.sendMessage("You are not a player!");
		}
		
		return false;
	}

}
