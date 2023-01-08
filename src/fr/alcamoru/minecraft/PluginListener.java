package fr.alcamoru.minecraft;

import fr.alcamoru.minecraft.BedWars.BedWars;
import fr.alcamoru.minecraft.BedWars.BedWarsListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PluginListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().clear();

        Location spawn = new Location(Bukkit.getWorld("world"), 4.5, -59.5, 1.5, 0, 0);
        player.teleport(spawn);

        ItemStack customCompass = new ItemStack(Material.COMPASS, 1);
        ItemMeta customM = customCompass.getItemMeta();
        customM.setDisplayName("§c§lMenu");
        customM.setLore(Arrays.asList("§fCet item vous permet ", "§fde naviguer dans le menu"));
        customM.addEnchant(Enchantment.DURABILITY, 200, true);
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customCompass.setItemMeta(customM);

        player.getInventory().setItem(0, customCompass);
        player.updateInventory();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it == null) return;

        if (it.getType() == Material.COMPASS) {
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lMenu")){
                Inventory inv = Bukkit.createInventory(null, 9, "§7Menu");
                ItemStack bed = getItem(Material.WHITE_BED, "§rBedWars");
                inv.setItem(0, bed);

                player.openInventory(inv);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inv = event.getClickedInventory();

        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (event.getView().getTitle().equalsIgnoreCase("§7Menu")) {

            event.setCancelled(true);

            if (current.getType() == Material.WHITE_BED) {
                BedWars.tpToLoc(player);
                player.closeInventory();
            }
        }
    }

    public ItemStack getItem(Material material, String customDisplayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName(customDisplayName);
        item.setItemMeta(itemM);
        return item;
    }
}
