package anthony.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import fr.mrmicky.fastboard.FastBoard;

public class Main extends JavaPlugin {
	
	//In this tutorial, I will be showing how to create Scoreboards using the FastBoard API
	
	@Override
	public void onEnable() {
		getLogger().info("[Scoreboards] has been successfully loaded!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("[Scoreboards] has been successfully disabled!");
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		FastBoard board = new FastBoard(player);
		
		board.updateTitle("" + ChatColor.BOLD + "Scoreboards");
		board.updateLines("", "" + ChatColor.YELLOW + "News", "" + ChatColor.RESET + "Scoreboard tutorial!");
	}

}
