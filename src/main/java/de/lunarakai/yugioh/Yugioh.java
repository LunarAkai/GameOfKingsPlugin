package de.lunarakai.yugioh;

import de.lunarakai.yugioh.cards.CardRegistration;
import de.lunarakai.yugioh.cards.boosterpacks.BoosterPackRegistration;
import de.lunarakai.yugioh.commands.CommandRegistration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Yugioh extends JavaPlugin {

    public static Logger LOGGER;
    private static Yugioh plugin;
    public static String PREFIX = "[YuGiOh]";
    private CardRegistry cardRegistry;
    private BoosterPackRegistry boosterPackRegistry;
    private FileConfiguration langConfig = null;
    public static File activeLangFile = null;
    private String langName;

    @Override
    public void onEnable() {
        LOGGER = getLogger();
        plugin = this;

        loadConfig();
        langName = plugin.getConfig().getString("active-language");
        saveLangConfig(langName);
        this.saveDefaultConfig();
        this.saveLangDefaultConfig();

        this.cardRegistry = new CardRegistry(this);
        this.boosterPackRegistry = new BoosterPackRegistry(this);

        new CommandRegistration(this).registerCommands();
        try {
            new CardRegistration(this).registerCards();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        new BoosterPackRegistration(this).registerBoosterPacks();

        getLogger().info("Plugin loaded successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin unloaded successfully!");
    }

    public static Yugioh getPlugin() {
        return plugin;
    }

    public CardRegistry getCardRegistry() {
        return cardRegistry;
    }

    public BoosterPackRegistry getBoosterPackRegistry() {
        return boosterPackRegistry;
    }

    public void loadConfig() {
        FileConfiguration cfg = getConfig();
        cfg.options().copyDefaults(true);
        saveConfig();
    }

    public FileConfiguration getLangConfig() throws UnsupportedEncodingException {
        if (langConfig == null) {
            reloadLangConfig();
        }
        return langConfig;
    }

    public void reloadLangConfig() {
        if (activeLangFile == null) {
            activeLangFile = new File(getDataFolder(), langName + ".yml");
        }
        if (!activeLangFile.exists()) {
            plugin.saveResource(langName+".yml", false);
        }
        langConfig = YamlConfiguration.loadConfiguration(activeLangFile);
    }

    public void saveLangConfig(String langName) {
        if (langConfig == null || activeLangFile == null) {
            return;
        }
        try {
            getLangConfig().save(new File(langName + ".yml"));
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save config to " + activeLangFile, ex);
        }
    }

    public void saveLangDefaultConfig() {
        if (activeLangFile == null) {
            activeLangFile = new File(getDataFolder(), langName+"yml");
        }
        if (!activeLangFile.exists()) {
            plugin.saveResource(langName+".yml", true);
        }
    }
}
