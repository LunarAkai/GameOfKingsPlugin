package de.lunarakai.gameofkings.cards.defaults.lob;

import de.lunarakai.gameofkings.cards.MonsterCard;
import de.lunarakai.gameofkings.utils.Attributes;
import de.lunarakai.gameofkings.utils.CardTyping;
import de.lunarakai.gameofkings.utils.LangUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class BlueEyesWhiteDragon extends MonsterCard {


    public BlueEyesWhiteDragon(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        super(keyBooster, keyCard);
    }

    @Override
    protected ItemStack createItemStack() throws UnsupportedEncodingException {
        ItemStack stack = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stack.getItemMeta();
        meta = setMonsterCardMeta(
                meta,
                8,
                Attributes.LIGHT,
                CardTyping.DRAGON,
                false,
                3000,
                2500,
                LangUtil.getLocalizedCardName(getBoosterKey(), getCardKey()),
                LangUtil.getLocalizedCardText(getBoosterKey(), getCardKey())
        );
        stack.setItemMeta(meta);

        return stack;
    }
}
