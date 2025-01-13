package com.vsrstudio.squidgame.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class SquidGameMenu {
    public static Inventory createMenu() {
        Inventory menu = Bukkit.createInventory(null, 9, "Squid Game Menu");

        ItemStack joinItem = new ItemStack(Material.GREEN_WOOL);
        ItemMeta joinMeta = joinItem.getItemMeta();
        joinMeta.setDisplayName("Join Squid Game");
        joinItem.setItemMeta(joinMeta);

        ItemStack leaveItem = new ItemStack(Material.RED_WOOL);
        ItemMeta leaveMeta = leaveItem.getItemMeta();
        leaveMeta.setDisplayName("Leave Squid Game");
        leaveItem.setItemMeta(leaveMeta);

        menu.setItem(3, joinItem);
        menu.setItem(5, leaveItem);

        return menu;
    }

    public static void openMenu(Player player) {
        Inventory menu = createMenu();
        player.openInventory(menu);
    }
}
