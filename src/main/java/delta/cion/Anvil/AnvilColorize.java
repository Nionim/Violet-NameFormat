package delta.cion.Anvil;

import delta.cion.Util.ConfigNames;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AnvilColorize implements Listener {

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        AnvilInventory inventory = event.getInventory();
        ItemStack result = inventory.getItem(2);
        Player player = (Player)event.getViewers().get(0);
        if (player != null && player.hasPermission("vio.anvil") && result != null && result.hasItemMeta()) {
            ItemMeta meta = result.getItemMeta();
            if (meta.hasDisplayName()) {
                String displayName = meta.getDisplayName();
                displayName = ChatColor.translateAlternateColorCodes('&', displayName);
                displayName = ConfigNames.hexTranslate(displayName);


                meta.setDisplayName(displayName);
                result.setItemMeta(meta);
                event.setResult(result);
            }
        }

    }
}
