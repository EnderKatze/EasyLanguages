package de.enderkatze.easylanguages;

import de.enderkatze.easylanguages.listeners.PlayerJoinListener;
import de.enderkatze.easylanguages.utils.UpdateChecker;
import org.bukkit.Bukkit;
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

    public boolean updateAvailable;

    @Override
    public void onEnable() {
        // Plugin startup logic

        new UpdateChecker(this, 111556).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                getLogger().info(EasyLanguages.GetServerLanguage(this).getString("Up to date!"));
                updateAvailable = false;
            } else {
                getLogger().info(EasyLanguages.GetServerLanguage(this).getString("Update available!"));
                updateAvailable = true;

            }
        });

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);

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
