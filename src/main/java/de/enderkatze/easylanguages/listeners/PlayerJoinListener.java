package de.enderkatze.easylanguages.listeners;

import de.enderkatze.easylanguages.EasyLanguages;
import de.enderkatze.easylanguages.EasyLanguagesPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if(event.getPlayer().isOp() && EasyLanguagesPlugin.getInstance().updateAvailable) {

            event.getPlayer().sendMessage("[EasyLanguages] " + EasyLanguages.GetServerLanguage(EasyLanguagesPlugin.getInstance()).getString("updateChecker.update"));
        }
    }
}
