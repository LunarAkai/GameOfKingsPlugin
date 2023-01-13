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

    String boosterKey;
    String cardKey;

    public BlueEyesWhiteDragon(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        super(new NamespacedKey(Yugioh.getPlugin(), keyBooster + "-" + keyCard));

        Yugioh.LOGGER.info("KeyBooster: " + keyBooster + ", KeyCard: " + keyCard);

        this.boosterKey = keyBooster;
        this.cardKey = keyCard;

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
                LangUtil.getLocalizedCardName(boosterKey, cardKey),
                LangUtil.getLocalizedCardText(boosterKey, cardKey)
        );
        stack.setItemMeta(meta);

        return stack;
    }

}
