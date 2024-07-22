package dev.admitiendo.tempcobwebs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Block b = event.getBlock();
        if (b.getType().equals(Material.COBWEB)
                || b.getType().toString().endsWith("WOOL")) {
            if (!new ConfigManager().isInList(event.getPlayer().getUniqueId())) {
                Bukkit.getScheduler().runTaskLater(TempCobwebs.plugin, () -> {
                    b.setType(Material.AIR);
                }, new ConfigManager().getDisappearTime() * 20L);
            }
        }
    }
}
