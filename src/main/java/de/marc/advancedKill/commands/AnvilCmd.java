package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnvilCmd {
    private final AdvancedKill plugin;

    public AnvilCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        Location anvil_loc = new Location(
                target.getWorld(),
                target.getLocation().getX(),
                target.getLocation().getY() + 2,
                target.getLocation().getZ()
        );
        anvil_loc.getBlock().setType(Material.ANVIL);
        sender.sendMessage("§aSuccess!");
    }
}
