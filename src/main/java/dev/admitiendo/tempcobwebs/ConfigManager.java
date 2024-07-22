package dev.admitiendo.tempcobwebs;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConfigManager {

    public FileConfiguration config = TempCobwebs.get().getConfig();

    public void saveUUID(UUID uuid) {
        List<String> list = new ArrayList<>();
        list.add(uuid.toString());
        list.addAll(config.getStringList("List"));
        config.set("List", list);
        try {
            config.save(TempCobwebs.configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isInList(UUID uuid) {
        List<String> list = config.getStringList("List");
        return list.contains(uuid.toString());
    }

    public void removeUUID(UUID uuid) {
        List<String> list = new ArrayList<>(config.getStringList("List"));
        list.remove(uuid.toString());
        config.set("List", list);
        try {
            config.save(TempCobwebs.configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void wipeUUIDs() {
        config.set("List", "");
        try {
            config.save(TempCobwebs.configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDisappearTime(int tiempo) {
        config.set("DisappearTime", tiempo);
        try {
            config.save(TempCobwebs.configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getDisappearTime() {
        return config.getInt("DisappearTime");
    }
}
