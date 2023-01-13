package de.lunarakai.yugioh.utils;

import com.google.common.base.Preconditions;
import de.lunarakai.yugioh.Yugioh;

import java.io.UnsupportedEncodingException;

public class LangUtil {
    public static String getLocalizedCardName(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".name"));
        return Yugioh.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".name");
    }
    public static String getLocalizedCardText(String boosterKey, String cardKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc"));
        return Yugioh.getPlugin().getLangConfig().getString("cards." + boosterKey + "." + boosterKey + cardKey + ".desc");
    }

    public static String getLocalizedTypingName(String typingKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("cardtypings." + typingKey));
        return Yugioh.getPlugin().getLangConfig().getString("cardtypings." + typingKey);
    }

    public static String getLocalizedAttributeName(String attributeKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("attributes." + attributeKey));
        return Yugioh.getPlugin().getLangConfig().getString("attributes." + attributeKey);
    }

    public static String getLocalizedEffectCardTypingName(String effectNameKey) throws UnsupportedEncodingException {
        Preconditions.checkArgument(Yugioh.getPlugin().getLangConfig().isString("effect." + effectNameKey));
        return Yugioh.getPlugin().getLangConfig().getString("effect." + effectNameKey);
    }

}
