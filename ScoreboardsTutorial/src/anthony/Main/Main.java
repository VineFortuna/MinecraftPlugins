package anthony.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getLogger().info("[ScoreboardsTutorial] has been enabled!");
	}
	
	@Override 
	public void onDisable() {
		getLogger().info("[ScoreboardsTutorial] has been disabled!");
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer(); //Do whatever with this method
	}
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer(); //Also do whatever with this method
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("sb")) { //A command to enable a player's scoreboard
				if (args.length == 0) {
					player.sendMessage("Wrong usage! Try doing: " + ChatColor.YELLOW + "/sb enable");
				}
				else if (args[0].equalsIgnoreCase("enable")) {
					ScoreboardManager m = Bukkit.getScoreboardManager();
					Scoreboard b = m.getNewScoreboard();
					Objective o = b.registerNewObjective("Test", "");
					
					o.setDisplaySlot(DisplaySlot.SIDEBAR);
					o.setDisplayName("" + ChatColor.BOLD + "MyBoard");
					
					Score line2 = o.getScore("" + ChatColor.YELLOW + ChatColor.BOLD + "News:");
					line2.setScore(2);
					Score line1 = o.getScore("" + ChatColor.RESET + "My first scoreboard!");
					line1.setScore(1);
					
					player.setScoreboard(b);
					player.sendMessage("" + ChatColor.YELLOW + "Scoreboard Enabled!");
				} 
			}
		} else {
			sender.sendMessage("You are not a player!");
		}
		
		return false;
	}
	
}
