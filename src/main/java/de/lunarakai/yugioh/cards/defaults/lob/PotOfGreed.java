package de.lunarakai.yugioh.cards.defaults.lob;

import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.SpellCard;
import de.lunarakai.yugioh.utils.LangUtil;
import de.lunarakai.yugioh.utils.SpellCardTypes;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class PotOfGreed extends SpellCard {

    public PotOfGreed() throws UnsupportedEncodingException {
        super(new NamespacedKey(Yugioh.getPlugin(), "lob" + "-" + "119"));
    }

    @Override
    protected ItemStack createItemStack() throws UnsupportedEncodingException {
        ItemStack stack = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stack.getItemMeta();
        meta = setSpellCardMeta(
                meta,
                SpellCardTypes.NORMAL,
                LangUtil.getLocalizedCardName("lob", "119"),
                LangUtil.getLocalizedCardText("lob", "119")
        );
        stack.setItemMeta(meta);

        return stack;
    }


}
