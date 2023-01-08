package fr.alcamoru.minecraft;

import fr.alcamoru.minecraft.BedWars.BedWarsListener;
import fr.alcamoru.minecraft.commands.CommandSpawn;
import fr.alcamoru.minecraft.commands.CommandTest;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private States state;

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

}

