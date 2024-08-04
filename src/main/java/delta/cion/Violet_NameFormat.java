package delta.cion;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.Senders;
import org.bukkit.plugin.java.JavaPlugin;


public final class Violet_NameFormat extends JavaPlugin {

    public static Violet_NameFormat getInstance() {
        return getPlugin(Violet_NameFormat.class);
    }

    @Override
    public void onEnable() {
        CmdExecutor.Enablez();
        if (getDescription().getVersion().contains("-DEV")) {
            Senders.Log(3, "ЕСЛИ К ВАМ ПОПАЛ DEV БИЛД - СООБЩИТЕ ОБ ЭТОМ РАЗРАБОТЧИКУ!!!\nЭТО НЕ НОРМАЛЬНО!!!");
        }
    }

    @Override
    public void onDisable() {

    }
}
