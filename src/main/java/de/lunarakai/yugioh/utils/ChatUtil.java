package de.lunarakai.yugioh.utils;

import de.iani.cubesideutils.bukkit.ChatUtilBukkit;
import de.lunarakai.yugioh.Yugioh;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatUtil {

    public static final ChatColor GREEN = ChatColor.of("#52ff9d");
    public static final ChatColor ORANGE = ChatColor.of("#ffac4d");
    public static final ChatColor RED = ChatColor.of("#ff6b6b");
    public static final ChatColor BLUE = ChatColor.of("#87f7ea");

    private ChatUtil() {

    }

    public static void sendMessage(CommandSender sender, String colors, Object... messageParts) {
        ChatUtilBukkit.sendMessage(sender, Yugioh.PREFIX, colors, messageParts);
    }

    public static void sendNormalMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, GREEN.toString(), messageParts);
    }

    public static void sendWarningMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, ORANGE.toString(), messageParts);
    }

    public static void sendErrorMessage(CommandSender sender, Object... messageParts) {
        sendMessage(sender, RED.toString(), messageParts);
    }
}
