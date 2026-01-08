package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoidCmd {
    private final AdvancedKill plugin;

    public VoidCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        Location loc = new Location(
                target.getWorld(),
                0,
                -100,
                0
        );
        target.teleport(loc);
        sender.sendMessage("§aSuccess!");
    }
}
