package delta.cion.Command.commands;

import delta.cion.Command.CmdUtil;
import delta.cion.Util.Senders;
import org.bukkit.command.CommandSender;

public class VioHelp implements CmdUtil {
    @Override
    public String CmdName() {return "help";}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
    Senders.Messages(4, sender);
    }
}
