package fr.alcamoru.minecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (cmd.getName().equalsIgnoreCase("test")) {
            sender.sendMessage("Test reussi");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("alert")) {
            if (args.length == 0) {
                sender.sendMessage("La commande est /alert <message>");
            }
            if (args.length >= 1) {
                StringBuilder bcMessage = new StringBuilder();
                for (String part: args) {
                    bcMessage.append(part + " ");
                }
                Bukkit.broadcastMessage(bcMessage.toString());
            }
        }

        return false;
    }
}
