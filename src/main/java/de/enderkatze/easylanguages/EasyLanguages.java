package de.enderkatze.easylanguages;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class EasyLanguages {

    /**
     * Write the defined translation file to disk
     * <br></br>
     * Please note that every plugin needs "en_us" as a translation, because it's used as a fallback
     * @param plugin An instance of your plugin
     * @param lang the name of the language file as a string
     */
    public static void SetDefaultTranslation(JavaPlugin plugin, String lang){
        try {
            plugin.saveResource("languages/" + lang + ".yml", false);
            //plugin.saveResource("languages.dir", true);
        } catch (IllegalArgumentException e) {

            Bukkit.getLogger().log(Level.SEVERE, GetServerLanguage(EasyLanguagesPlugin.getInstance()).getString("languageFileNull") + lang + ".yml");
        }

    }

    public static FileConfiguration GetSpecificLanguage(JavaPlugin plugin, String language) {

        File file = new File(plugin.getDataFolder().getPath() + "/languages/" + language);
        if(!file.getPath().endsWith(".yml")) {
            file = new File(plugin.getDataFolder().getPath() + "/languages/" + language + ".yml");
        }

        if (!file.exists()) {

            file = new File(plugin.getDataFolder().getPath() + "languages/en_us.yml");
            if (!file.exists()) {
                Bukkit.getLogger().log(Level.SEVERE, "Couldn't find language file!");
                return null;
            }
        }

        FileConfiguration langConfig = YamlConfiguration.loadConfiguration(file);

        return langConfig;
    }

    public static FileConfiguration GetServerLanguage(JavaPlugin plugin) {

        File file = new File(plugin.getDataFolder().getPath() + "/languages/" + EasyLanguagesPlugin.getInstance().getConfig().getString("serverLanguage"));
        if(!file.getPath().endsWith(".yml")) {
            file = new File(plugin.getDataFolder().getPath() + "/languages/" + EasyLanguagesPlugin.getInstance().getConfig().getString("serverLanguage") + ".yml");
        }

        if (!file.exists()) {

            file = new File(plugin.getDataFolder().getPath() + "languages/en_us.yml");
            if (!file.exists()) {
                Bukkit.getLogger().log(Level.SEVERE, "Couldn't find language file!");
                return null;
            }


        }

        FileConfiguration langConfig = YamlConfiguration.loadConfiguration(file);

        return langConfig;
    }
}
