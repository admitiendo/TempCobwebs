package dev.admitiendo.tempcobwebs;

import org.bukkit.*;
import org.bukkit.entity.*;


/**
 * Created by SofDev w/Apreciada
 * 14/06/2022 - 02:52:27
 */

public class CC {
    public static String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static void log(String string) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(string));
    }

    public static void broadcast(String string) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(CC.translate(string));
        }
    }

    public static String normalLine() {
        return "-------------------";
    }
}