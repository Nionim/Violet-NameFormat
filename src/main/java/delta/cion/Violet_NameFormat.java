package delta.cion;

import delta.cion.Util.ConfigNames;
import lombok.Getter;
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
    }

    @Override
    public void onDisable() {

    }
}
