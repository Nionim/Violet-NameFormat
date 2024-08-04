package delta.cion.Util;

import delta.cion.Violet_NameFormat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginEvent implements Listener {

    private final Violet_NameFormat plugin = Violet_NameFormat.getInstance();

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        ConfigNames.joinPlayer(event.getPlayer());
        Player player = event.getPlayer();
        FileConfiguration conf = plugin.getConfig();
        ConfigurationSection section = conf.getConfigurationSection("Players");

        if (section != null && section.contains(player.getName())) {
            player.setDisplayName(section.getString(player.getName()));
        }
    }
}
