package delta.cion;

import delta.cion.Anvil.AnvilColorize;
import delta.cion.Command.CmdExecutor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Violet_NameFormat extends JavaPlugin {

    @Getter
    private static Violet_NameFormat instance;

    @Override
    public void onEnable() {
        instance = this;
        CmdExecutor.Enablez();
    }

    @Override
    public void onDisable() {

    }
}
