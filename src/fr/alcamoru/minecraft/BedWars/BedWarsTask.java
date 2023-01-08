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

        if (timer == 0) {
            Bukkit.broadcastMessage("Lancement...");
            main.setState(States.PLAYING);
            cancel();
        }

        timer --;
    }
}
