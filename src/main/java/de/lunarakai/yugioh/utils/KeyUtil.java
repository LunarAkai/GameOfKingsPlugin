package de.lunarakai.yugioh.utils;

import de.lunarakai.yugioh.Yugioh;

public class KeyUtil {
    public static String getBoosterPackKey(String boosterKey) {
        return Yugioh.getPlugin().getConfig().getString("boosterpack-keys" + "." + boosterKey);
    }
}
