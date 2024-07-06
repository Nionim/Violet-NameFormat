package delta.cion.Command;

import org.bukkit.command.CommandSender;

public interface CmdUtil {
    String CmdName();
    void CmdUse(CommandSender sender, String[] args);
}
