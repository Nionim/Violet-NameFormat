package delta.cion.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginEvent implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        ConfigNames.joinPlayer(event.getPlayer());
    }
}
