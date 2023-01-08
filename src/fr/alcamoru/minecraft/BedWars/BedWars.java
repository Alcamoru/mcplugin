package fr.alcamoru.minecraft.BedWars;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedWars implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

    public static Location bwLoc = new Location(Bukkit.getWorld("world"), 3.5, -59.5, 167.5, 0, 0);

    public static void tpToLoc(Player player) {
        player.teleport(bwLoc);
    }

}
