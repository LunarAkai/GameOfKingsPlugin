package de.lunarakai.yugioh.cards.defaults.lob;

import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.EffectMonster;
import de.lunarakai.yugioh.utils.Attributes;
import de.lunarakai.yugioh.utils.LangUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.UnsupportedEncodingException;

public class ExodiaTheForbiddenOne extends EffectMonster {

    public ExodiaTheForbiddenOne() throws UnsupportedEncodingException {
        super(new NamespacedKey(Yugioh.getPlugin(), "lob" + "-" + "124"));
    }

    @Override
    protected ItemStack createItemStack() throws UnsupportedEncodingException {
        ItemStack stack = new ItemStack(Material.PAPER, 1);
        ItemMeta meta = stack.getItemMeta();
        meta = setMonsterCardMeta(
                meta,
                3,
                Attributes.DARK,
                "Spellcaster/Effect",
                1000,
                1000,
                LangUtil.getLocalizedCardName("lob", "124"),
                LangUtil.getLocalizedCardText("lob", "124")
        );
        stack.setItemMeta(meta);

        return stack;
    }

}
