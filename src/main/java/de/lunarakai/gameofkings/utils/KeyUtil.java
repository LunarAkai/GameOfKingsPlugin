package de.lunarakai.gameofkings.utils;

import de.lunarakai.gameofkings.GameOfKings;

public class KeyUtil {
    public static String getBoosterPackKey(String boosterKey) {
        return GameOfKings.getPlugin().getConfig().getString("boosterpack-keys" + "." + boosterKey);
    }
}
