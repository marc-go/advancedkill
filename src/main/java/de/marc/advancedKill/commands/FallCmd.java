package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FallCmd {
    private final AdvancedKill plugin;

    public FallCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        Location fall_loc = new Location(
                target.getLocation().getWorld(),
                target.getLocation().getX(),
                300,
                target.getLocation().getZ()
        );

        target.teleport(fall_loc);

        sender.sendMessage("§aSuccess!");
    }
}
