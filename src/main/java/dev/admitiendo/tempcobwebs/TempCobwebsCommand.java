package dev.admitiendo.tempcobwebs;

import dev.admitiendo.tempcobwebs.commands.Command;
import dev.admitiendo.tempcobwebs.commands.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TempCobwebsCommand {

    @Command(name = "tempcobwebs", permission = "tempcobwebs.manage", inGameOnly = true)
    public void mainCommand(CommandArgs args) {
        int time = Integer.parseInt(args.getArgs(0));
        args.getSender().sendMessage(CC.translate("&bHas cambiado el tiempo de desaparicion de cobwebs a &f" + time + "s&b."));
        new ConfigManager().setDisappearTime(time);
    }

    @Command(name = "tcwaddbypass", permission = "tempcobwebs.manage", inGameOnly = true)
    public void addBypass(CommandArgs args) {
        if (args.length() == 1) {
            Player player = Bukkit.getPlayer(args.getArgs(0));
            if (player != null) {
                if (!new ConfigManager().isInList(player.getUniqueId())) {
                    new ConfigManager().saveUUID(player.getUniqueId());
                } else {
                    args.getSender().sendMessage(CC.translate("&cEl usuario " + player.getDisplayName() + " ya tiene bypass."));
                }
                return;
            }
            args.getSender().sendMessage(CC.translate("&cUsage: /tcwaddbypass <Usuario>"));
        } else {
            args.getSender().sendMessage(CC.translate("&cUsage: /tcwaddbypass <Usuario>"));
        }
    }

    @Command(name = "tcwremovebypass", permission = "tempcobwebs.manage", inGameOnly = true)
    public void removeBypass(CommandArgs args) {
        if (args.length() == 1) {
            Player player = Bukkit.getPlayer(args.getArgs(0));
            if (player != null) {
                if (!new ConfigManager().isInList(player.getUniqueId())) {
                    args.getSender().sendMessage(CC.translate("&cEl usuario " + player.getDisplayName() + " no tiene bypass."));
                } else {
                    new ConfigManager().removeUUID(player.getUniqueId());
                }
                return;
            }
            args.getSender().sendMessage(CC.translate("&cUsage: /tcwremovebypass <Usuario>"));
        } else {
            args.getSender().sendMessage(CC.translate("&cUsage: /tcwremovebypass <Usuario>"));
        }
    }
}
