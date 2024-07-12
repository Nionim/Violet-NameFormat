package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.Senders;
import org.bukkit.command.CommandSender;

public class VioHelp implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "help";}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
    Senders.Messages(4, sender);
    }
}
