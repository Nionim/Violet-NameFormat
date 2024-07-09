package delta.cion;

import delta.cion.Anvil.AnvilColorize;
import delta.cion.Util.ConfigNames;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Violet_NameFormat extends JavaPlugin {

    @Getter
    private static Violet_NameFormat instance;
    private static ConfigNames configNames;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configNames = new ConfigNames();
        Bukkit.getPluginManager().registerEvents(new AnvilColorize(), this);
    }

    @Override
    public void onDisable() {

    }
}
