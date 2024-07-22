package dev.admitiendo.tempcobwebs;

import dev.admitiendo.tempcobwebs.commands.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class TempCobwebs extends JavaPlugin {
    public static Plugin plugin;
    public static File configFile;
    String configPath;

    @Override
    public void onEnable() {
        plugin = this;
        CommandFramework framework = new CommandFramework(this);
        framework.registerCommands(new TempCobwebsCommand());
        Bukkit.getConsoleSender().sendMessage(CC.translate("&e" + CC.normalLine() + CC.normalLine()));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&ePlugin de cobwebs y lana temporales activado exitosamente."));
        registerConfig();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&e" + CC.normalLine() + CC.normalLine()));
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&c" + CC.normalLine() + CC.normalLine()));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&cPlugin de cobwebs y lana temporales desactivado exitosamente."));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&c" + CC.normalLine() + CC.normalLine()));
    }
    
    public static TempCobwebs get() {
        return getPlugin(TempCobwebs.class);
    }

    public void registerConfig() {
        File config = new File(this.getDataFolder(), "data.yml");
        configFile = config;
        configPath = config.getPath();
        if (!config.exists()) {
            configFile = config;
            Bukkit.getConsoleSender().sendMessage(CC.translate("&eEl archivo data.yml fue creado con exito."));
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
