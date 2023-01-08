package fr.alcamoru.minecraft.listeners;

import fr.alcamoru.minecraft.BedWars.BedWarsTask;
import fr.alcamoru.minecraft.Main;
import fr.alcamoru.minecraft.States;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
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
        Player player = event.getPlayer();
        if (event.getTo().equals(this.gLoc)) {
            if (!main.isState(States.WAITING)){
                player.setGameMode(GameMode.SPECTATOR);
            }
            else {
                if (!main.getPlayers().contains(player)) {
                    main.getPlayers().add(player);
                    if (main.getPlayers().size() > 0) {
                        main.setState(States.STARTING);
                        BedWarsTask start = new BedWarsTask(main);
                        start.runTaskTimer(main, 0, 20);
                    }
                }
            }
        }
    }

}
