package de.marc.advancedKill;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;
import de.marc.advancedKill.commands.*;

import java.util.ArrayList;
import java.util.List;

public final class AdvancedKill extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        getCommand("akill").setExecutor(this);
        getCommand("afilter").setExecutor(new AdvancedKillFilter(this));

        getLogger().info("AdvancedKill was loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AdvancedKill was disabled");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Check Permission
        if(!sender.hasPermission("akill.use")) {
            sender.sendMessage("§cPermission denied!");
            return true;
        }

        //Check Args
        if (args.length == 0) {
            sender.sendMessage("§aMethods:\nlightning\nanvil\nzombie\nvoid\nhalf\nexplosion\nfall\nlava");
            return true;
        }

        if (args.length == 1) {
            sender.sendMessage("§cNo player defined!");
            return true;
        }


        //Define mode and player
        String mode = args[0].toLowerCase();
        Player target = Bukkit.getPlayer(args[1]);

        if (target == null) {
            sender.sendMessage("§cPlayer does not exists!");
            return true;
        }

        //Check filter
        if (getConfig().getBoolean("filter-player")) {
            List<String> filter = getConfig().getStringList("bypass-players");

            String uuid = target.getUniqueId().toString();

            if (filter.contains(uuid)) {
                sender.sendMessage("§cYou can not kill this player!");
                return true;
            }
        }



        //Run Commands
        switch (mode) {
            case "lightning":
                new LightningCmd(this).execute(sender, target);
                break;

            case "void":
                new VoidCmd(this).execute(sender, target);
                break;

            case "zombie":
                new ZombieCmd(this).execute(sender, target);
                break;

            case "half":
                new HalfCmd(this).execute(sender, target);
                break;

            case "anvil":
                new AnvilCmd(this).execute(sender, target);
                break;

            case "explosion":
                new ExplosionCmd(this).execute(sender, target);
                break;

            case "fall":
                new FallCmd(this).execute(sender, target);
                break;

            case "lava":
                new LavaCmd(this).execute(sender, target);
                break;

            default:
                sender.sendMessage("§cThis method does not exists.");
                break;
        }
        return true;
    }

    //Completions
    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();

        if (label.equals("akill")) {
            if (sender.hasPermission("akill.use")) {
                if (args.length == 1) {
                    completions.add("lightning");
                    completions.add("void");
                    completions.add("zombie");
                    completions.add("half");
                    completions.add("anvil");
                    completions.add("explosion");
                    completions.add("fall");
                    completions.add("lava");
                }

                if (args.length == 2) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        completions.add(player.getName());
                    }
                }
            }
        }

        if (label.equals("afilter")) {
            if (args.length == 1) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    completions.add(player.getName());
                }
            }
        }

        return completions;
    }
}