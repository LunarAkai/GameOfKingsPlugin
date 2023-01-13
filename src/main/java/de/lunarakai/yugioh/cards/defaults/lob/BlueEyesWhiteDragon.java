package de.lunarakai.yugioh.cards.defaults.lob;

import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.MonsterCard;
import de.lunarakai.yugioh.utils.Attributes;
import de.lunarakai.yugioh.utils.CardTyping;
import de.lunarakai.yugioh.utils.LangUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class BlueEyesWhiteDragon extends MonsterCard {
    public BlueEyesWhiteDragon() throws UnsupportedEncodingException {
        super(new NamespacedKey(Yugioh.getPlugin(), "lob" + "-" + "001"));
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
                LangUtil.getLocalizedCardName("lob", "001"),
                LangUtil.getLocalizedCardText("lob", "001")
        );
        stack.setItemMeta(meta);

        return stack;
    }

}
