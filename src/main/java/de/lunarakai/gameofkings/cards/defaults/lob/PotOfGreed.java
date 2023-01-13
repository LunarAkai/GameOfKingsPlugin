package de.lunarakai.gameofkings.cards.defaults.lob;

import de.lunarakai.gameofkings.cards.SpellCard;
import de.lunarakai.gameofkings.utils.LangUtil;
import de.lunarakai.gameofkings.utils.SpellCardTypes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class PotOfGreed extends SpellCard {

    String boosterKey;
    String cardKey;


    public PotOfGreed(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        super(keyBooster, keyCard);

        this.boosterKey = keyBooster;
        this.cardKey = keyCard;
    }


    @Override
    protected ItemStack createItemStack() throws UnsupportedEncodingException {
        ItemStack stack = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stack.getItemMeta();
        meta = setSpellCardMeta(
                meta,
                SpellCardTypes.NORMAL,
                LangUtil.getLocalizedCardName(boosterKey, cardKey),
                LangUtil.getLocalizedCardText(boosterKey, cardKey)
        );
        stack.setItemMeta(meta);

        return stack;
    }


}
