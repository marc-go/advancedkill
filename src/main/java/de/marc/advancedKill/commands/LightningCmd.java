package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningCmd {
    private final AdvancedKill plugin;

    public LightningCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        target.getWorld().strikeLightning(target.getLocation());
        sender.sendMessage("§aSuccess!");
    }
}
