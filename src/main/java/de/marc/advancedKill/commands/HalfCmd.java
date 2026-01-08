package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HalfCmd {
    private final AdvancedKill plugin;

    public HalfCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        target.setHealth(1.0);
        sender.sendMessage("§aSuccess!");
    }
}
