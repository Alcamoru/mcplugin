package fr.alcamoru.minecraft.BedWars;

import fr.alcamoru.minecraft.Main;
import fr.alcamoru.minecraft.States;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BedWarsTask extends BukkitRunnable {

    private int timer = 10;
    private Main main;

    public BedWarsTask(Main main) {
        this.main = main;
    }

    @Override
    public void run() {

        for (Player player: main.getPlayers()) {
            player.setLevel(timer);
        }

        if (timer == 10 || timer == 5 ||timer == 4 ||timer == 3 ||timer == 2 ||timer == 1) {
            for (Player player: main.getPlayers()) {
                player.sendTitle("§4" + timer, "", 5, 20, 5);
            }
        }

        if (timer == 0) {
            Bukkit.broadcastMessage("Lancement...");
            main.setState(States.WAITING);
            for (Player player: main.getPlayers()) {
                main.getPlayers().remove(player);
            }
            cancel();
        }
        timer --;
    }
}
