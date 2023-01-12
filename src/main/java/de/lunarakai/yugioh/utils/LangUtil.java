package de.lunarakai.yugioh.utils;

import com.google.common.base.Preconditions;
import de.lunarakai.yugioh.Yugioh;

import java.io.UnsupportedEncodingException;

public class LangUtil {
    public static String getLocalizedCardName(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        Yugioh.LOGGER.info("cards." + boosterKey + "." + boosterKey + cardKey + ".name");
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".name"));
        return Yugioh.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".name");
    }
    public static String getLocalizedCardText(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        Yugioh.LOGGER.info("cards." + boosterKey + "." + boosterKey + cardKey + ".desc");
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc"));
        return Yugioh.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc");
    }

}
