package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplosionCmd {
    private final AdvancedKill plugin;

    public ExplosionCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }

    public void execute(CommandSender sender, Player target) {
        target.getWorld().createExplosion(
                target.getLocation(),
                6.0f,
                false,
                false
        );
        sender.sendMessage("§aSuccess!");
    }
}