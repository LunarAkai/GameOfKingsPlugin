package de.lunarakai.gameofkings.utils;

import com.google.common.base.Preconditions;
import de.lunarakai.gameofkings.GameOfKings;

import java.io.UnsupportedEncodingException;

public class LangUtil {
    public static String getLocalizedCardName(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        GameOfKings.LOGGER.info("cards." + boosterKey + "." + boosterKey + cardKey + ".name");
        Preconditions.checkArgument(GameOfKings.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".name"));
        return GameOfKings.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".name");
    }
    public static String getLocalizedCardText(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(GameOfKings.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc"));
        return GameOfKings.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc");
    }

    public static String getLocalizedTypingName(String typingKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(GameOfKings.getPlugin().getLangConfig().isString("cardtypings." + typingKey));
        return GameOfKings.getPlugin().getLangConfig().getString("cardtypings." + typingKey);
    }

    public static String getLocalizedAttributeName(String attributeKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(GameOfKings.getPlugin().getLangConfig().isString("attributes." + attributeKey));
        return GameOfKings.getPlugin().getLangConfig().getString("attributes." + attributeKey);
    }

    public static String getLocalizedEffectCardTypingName(String effectNameKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(GameOfKings.getPlugin().getLangConfig().isString("effect." + effectNameKey));
        return GameOfKings.getPlugin().getLangConfig().getString("effect." + effectNameKey);
    }

}
