package delta.cion;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.Enables;
import delta.cion.Util.Senders;
import org.bukkit.plugin.java.JavaPlugin;


public final class Violet_NameFormat extends JavaPlugin {

    public static Violet_NameFormat getInstance() {
        return getPlugin(Violet_NameFormat.class);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Enables.enable();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
