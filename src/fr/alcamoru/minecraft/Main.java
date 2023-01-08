package fr.alcamoru.minecraft;

import fr.alcamoru.minecraft.listeners.BedWarsListener;
import fr.alcamoru.minecraft.commands.CommandSpawn;
import fr.alcamoru.minecraft.commands.CommandTest;
import fr.alcamoru.minecraft.listeners.PluginListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin{

    private States state;
    private List<Player> players = new ArrayList<>();

    @Override
    public void onEnable() {
        super.onEnable();
        setState(States.WAITING);
        System.out.println("Le plugin est en fonctionnement");
        getCommand("test").setExecutor(new CommandTest());
        getCommand("alert").setExecutor(new CommandTest());
        getCommand("spawn").setExecutor(new CommandSpawn());
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PluginListener(), this);
        pm.registerEvents(new BedWarsListener(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("Le plugin est eteint");
    }

    public void setState(States state) {
        this.state = state;
    }

    public boolean isState(States state) {
        return this.state == state;
    }

    public List<Player> getPlayers() {
        return players;
    }
}

