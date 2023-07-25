package de.enderkatze.languageapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class LanguageAPIPlugin extends JavaPlugin {

    public LanguageAPIPlugin() {
    }


    private static LanguageAPIPlugin instance;

    private final String PREFIX = "[LanguageAPI] ";

    /**
     * Gets an instance of the plugin
     * @return instance of the plugin
     */
    public static LanguageAPIPlugin getInstance() {return instance;}



    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();

        // Set languages
        LanguageAPI.SetDefaultTranslation(getInstance(), "en_us");
        LanguageAPI.SetDefaultTranslation(getInstance(), "de_de");
        LanguageAPI.SetDefaultTranslation(getInstance(), "en_gb");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
