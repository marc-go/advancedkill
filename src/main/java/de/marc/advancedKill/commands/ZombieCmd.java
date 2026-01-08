package de.marc.advancedKill.commands;

import de.marc.advancedKill.AdvancedKill;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class ZombieCmd {
    private final AdvancedKill plugin;

    public ZombieCmd(AdvancedKill plugin) {
        this.plugin = plugin;
    }


    public void execute(CommandSender sender, Player target) {
        Zombie zombie = target.getWorld().spawn(
                target.getLocation(),
                Zombie.class
        );

        zombie.getEquipment().setItemInMainHand(
                new ItemStack(Material.DIAMOND_SWORD)
        );

        zombie.setCustomName("akill");
        zombie.setCustomNameVisible(false);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            zombie.remove();
        }, 200L);

        sender.sendMessage("§aSuccess!");
    }
}
