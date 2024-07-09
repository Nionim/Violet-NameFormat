package delta.cion.Anvil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                displayName = this.translateHexColorCodes(displayName);


                meta.setDisplayName(displayName);
                result.setItemMeta(meta);
                event.setResult(result);
            }
        }

    }

    private String translateHexColorCodes(String textToTranslate) {
        Pattern hexPattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = hexPattern.matcher(textToTranslate);
        StringBuffer buffer = new StringBuffer();

        while(matcher.find()) {
            String hexColor = matcher.group();
            StringBuilder replacement = new StringBuilder("§x");
            char[] var7 = hexColor.substring(1).toCharArray();
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                char c = var7[var9];
                replacement.append('§').append(c);
            }

            matcher.appendReplacement(buffer, replacement.toString());
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }


}
