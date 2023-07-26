package de.enderkatze.easylanguages;

import org.bukkit.plugin.java.JavaPlugin;

public final class EasyLanguagesPlugin extends JavaPlugin {

    public EasyLanguagesPlugin() {
    }


    private static EasyLanguagesPlugin instance;

    private final String PREFIX = "[EasyLanguages] ";

    /**
     * Gets an instance of the plugin
     * @return instance of the plugin
     */
    public static EasyLanguagesPlugin getInstance() {return instance;}



    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();

        // Set languages
        EasyLanguages.SetDefaultTranslation(getInstance(), "en_us");
        EasyLanguages.SetDefaultTranslation(getInstance(), "de_de");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
