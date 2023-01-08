package fr.alcamoru.minecraft.BedWars;

import fr.alcamoru.minecraft.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BedWarsListener implements Listener {

    private Location gLoc = new Location(Bukkit.getWorld("world"), 3.5, -59.5, 167.5, 0, 0);
    private Main main;

    public void BedWarsListene(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.getTo().equals(this.gLoc)) {

        }
    }

}
