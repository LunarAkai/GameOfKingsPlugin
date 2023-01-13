package de.lunarakai.gameofkings.cards;

import de.lunarakai.gameofkings.utils.Attributes;
import de.lunarakai.gameofkings.utils.CardTyping;
import de.lunarakai.gameofkings.utils.LangUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class MonsterCard extends AbstractCard{
    protected MonsterCard(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        super("null", "null");
    }

    protected ItemMeta setMonsterCardMeta(ItemMeta cardMeta, int level, Attributes attribute,
                                          CardTyping typing, Boolean isEffect, int atk, int def, String cardName, String... cardText) throws UnsupportedEncodingException {

        TextComponent textNameComponent = Component.text(cardName)
                .color(NamedTextColor.WHITE).decoration(TextDecoration.BOLD, true);
        cardMeta.displayName(textNameComponent);

        ArrayList<String> lore = new ArrayList<>();
        StringBuilder levelStr = new StringBuilder();

        for(int i = 0; i < level; i++) {
            levelStr.append("(*)");
        }
        lore.add(ChatColor.GOLD + levelStr.toString());

        switch (attribute) {
            case LIGHT -> lore.add(ChatColor.YELLOW + LangUtil.getLocalizedAttributeName("light"));
            case DARK -> lore.add(ChatColor.DARK_PURPLE + LangUtil.getLocalizedAttributeName("dark"));
            case FIRE -> lore.add(ChatColor.RED + LangUtil.getLocalizedAttributeName("fire"));
            case EARTH -> lore.add(ChatColor.BLACK + LangUtil.getLocalizedAttributeName("earth"));
            case WATER -> lore.add(ChatColor.AQUA + LangUtil.getLocalizedAttributeName("water"));
            case WIND -> lore.add(ChatColor.DARK_BLUE + LangUtil.getLocalizedAttributeName("wind"));
            case DIVINE -> lore.add(ChatColor.GOLD + LangUtil.getLocalizedAttributeName("divine"));
        }
        lore.add("\n"); //Empty Line for better readability

        String typingString = null;

        switch (typing) {
            case AQUA -> typingString = LangUtil.getLocalizedTypingName("aqua");
            case BEAST -> typingString =  LangUtil.getLocalizedTypingName("beast");
            case BEASTWARRIOR -> typingString =  LangUtil.getLocalizedTypingName("beastwarrior");
            case CYBERSE -> typingString =  LangUtil.getLocalizedTypingName("cyberse");
            case DINOSAUR -> typingString =  LangUtil.getLocalizedTypingName("dinosaur");
            case DIVINEBEAST -> typingString =  LangUtil.getLocalizedTypingName("divinebeast");
            case DRAGON -> typingString =  LangUtil.getLocalizedTypingName("dragon");
            case FAIRY -> typingString =  LangUtil.getLocalizedTypingName("fairy");
            case FIEND -> typingString =  LangUtil.getLocalizedTypingName("fiend");
            case FISH -> typingString =  LangUtil.getLocalizedTypingName("fish");
            case INSECT -> typingString =  LangUtil.getLocalizedTypingName("insect");
            case MACHINE -> typingString =  LangUtil.getLocalizedTypingName("machine");
            case PLANT -> typingString =  LangUtil.getLocalizedTypingName("plant");
            case PSYCHIC -> typingString =  LangUtil.getLocalizedTypingName("psychic");
            case PYRO -> typingString =  LangUtil.getLocalizedTypingName("pyro");
            case REPTILE -> typingString =  LangUtil.getLocalizedTypingName("reptile");
            case ROCK -> typingString =  LangUtil.getLocalizedTypingName("rock");
            case SEASERPENT -> typingString =  LangUtil.getLocalizedTypingName("seaserpent");
            case SPELLCASTER -> typingString =  LangUtil.getLocalizedTypingName("spellcaster");
            case THUNDER -> typingString =  LangUtil.getLocalizedTypingName("thunder");
            case WARRIOR -> typingString =  LangUtil.getLocalizedTypingName("warrior");
            case WINGEDBEAST -> typingString =  LangUtil.getLocalizedTypingName("wingedbeast");
            case WYRM -> typingString =  LangUtil.getLocalizedTypingName("wyrm");
            case ZOMBIE -> typingString =  LangUtil.getLocalizedTypingName("zombie");
        }

        if(isEffect) {
            lore.add(ChatColor.WHITE + "[" + typingString + "/" + LangUtil.getLocalizedEffectCardTypingName("effect") + "]");
        } else {
            lore.add(ChatColor.WHITE + "[" + typingString + "]");
        }

        Arrays.stream(cardText).toList().forEach(s -> {
            lore.add(ChatColor.GRAY + s);
        });

        lore.add(ChatColor.WHITE + "ATK/" + atk + " DEF/" + def);


        cardMeta.setLore(lore);
        return cardMeta;
    }


}
