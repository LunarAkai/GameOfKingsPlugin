package de.lunarakai.gameofkings;

import de.lunarakai.gameofkings.cards.CardRegistration;
import de.lunarakai.gameofkings.cards.boosterpacks.BoosterPackRegistration;
import de.lunarakai.gameofkings.commands.CommandRegistration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GameOfKings extends JavaPlugin {

    public static Logger LOGGER;
    private static GameOfKings plugin;
    public static String PREFIX = "[GoK]";
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
        saveLangConfig();
        this.saveDefaultConfig();
        this.boosterPackRegistry = new BoosterPackRegistry(this);
        new BoosterPackRegistration(this).registerBoosterPacks();

        new CommandRegistration(this).registerCommands();

        this.cardRegistry = new CardRegistry(this);
        try {
            new CardRegistration(this).registerCards();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        getLogger().info("Plugin loaded successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin unloaded successfully!");
    }

    public static GameOfKings getPlugin() {
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
        langConfig = YamlConfiguration.loadConfiguration(activeLangFile); // see next lines
        // new YamlConfig
        // try
        // langConfig.load
        // catch
    }

    public void saveLangConfig() {
        if (langConfig == null || activeLangFile == null) {
            return;
        }
        try {
            getLangConfig().save(activeLangFile);
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Could not save config to " + activeLangFile, ex);
        }
    }

}
