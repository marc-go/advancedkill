package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LavaCmd {
    private final AdvancedKill plugin;

    public LavaCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        Location lava_loc = target.getLocation();

        Block block = lava_loc.getBlock();
        Material old_block = block.getType();

        block.setType(Material.LAVA);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            block.setType(old_block);
        }, 60L);

        sender.sendMessage("§aSuccess!");
    }
}
