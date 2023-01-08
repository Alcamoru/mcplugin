package fr.alcamoru.minecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] strings) {

        if (sender instanceof Player player) {
            Location spawn = new Location(Bukkit.getWorld("world"), 4.5, -58.5, 1.5, 0, 0);
            player.teleport(spawn);
            player.sendMessage("Vous venez d'être teleporte au spawn");
        }

        return false;
    }
}
