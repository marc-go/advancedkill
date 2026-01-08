package de.marc.advancedKill;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class AdvancedKillFilter implements CommandExecutor {
    private AdvancedKill plugin;

    public AdvancedKillFilter(AdvancedKill plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("akill.admin")) {
            sender.sendMessage("§cPermission denied!");
            return true;
        }

        if (!(plugin.getConfig().getBoolean("filter-player"))) {
            sender.sendMessage("§cThe filter is not aktive.");
            return true;
        }

        List<String> players = plugin.getConfig().getStringList("bypass-players");

        if (!(args.length == 1)) {
            sender.sendMessage("No Player defined");
            return true;
        }

        String msg = "";

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            sender.sendMessage("§cPlayer not found!");
            return true;
        }

        String uuid = target.getUniqueId().toString();

        if (players.contains(uuid)) {
            players.remove(uuid);
            msg = "§aPlayer was removed successfully!";
        }else{
            players.add(uuid);
            msg = "§aPlayer was added successfully!";
        }

        plugin.getConfig().set("bypass-players", players);
        plugin.saveConfig();

        sender.sendMessage(msg);

        return true;
    }
}
