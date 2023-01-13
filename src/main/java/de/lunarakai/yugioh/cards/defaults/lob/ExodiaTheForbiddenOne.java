package de.lunarakai.yugioh.cards.defaults.lob;

import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.EffectMonster;
import de.lunarakai.yugioh.utils.Attributes;
import de.lunarakai.yugioh.utils.CardTyping;
import de.lunarakai.yugioh.utils.LangUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class ExodiaTheForbiddenOne extends EffectMonster {

    String boosterKey;
    String cardKey;


    public ExodiaTheForbiddenOne(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        super(new NamespacedKey(Yugioh.getPlugin(), keyBooster + "-" + keyCard));

        this.boosterKey = keyBooster;
        this.cardKey = keyCard;
    }

    @Override
    protected ItemStack createItemStack() throws UnsupportedEncodingException {
        ItemStack stack = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stack.getItemMeta();
        meta = setMonsterCardMeta(
                meta,
                3,
                Attributes.DARK,
                CardTyping.SPELLCASTER,
                true,
                1000,
                1000,
                LangUtil.getLocalizedCardName(boosterKey, cardKey),
                LangUtil.getLocalizedCardText(boosterKey, cardKey)
        );
        stack.setItemMeta(meta);

        return stack;
    }

}
