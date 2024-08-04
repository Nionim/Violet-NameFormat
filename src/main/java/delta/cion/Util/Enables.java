package delta.cion.Util;

import delta.cion.Anvil.AnvilColorize;
import delta.cion.Command.CmdExecutor;
import delta.cion.Violet_NameFormat;
import org.bukkit.Bukkit;

import java.util.Objects;

public class Enables {

    private static final Violet_NameFormat plugin = Violet_NameFormat.getInstance();

    public static void enable() {
        if (plugin.getDescription().getVersion().contains("-DEV")) {
            Senders.Log(3, "WARNING! THIS A TEST BUILD!");
        }

        Objects.requireNonNull(plugin.getCommand("vionf")).setExecutor(new CmdExecutor());
        Objects.requireNonNull(plugin.getCommand("vionf")).setTabCompleter(new CmdExecutor());
        Bukkit.getPluginManager().registerEvents(new AnvilColorize(), plugin);
        Bukkit.getPluginManager().registerEvents(new LoginEvent(), plugin);
    }

}
