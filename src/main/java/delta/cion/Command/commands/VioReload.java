package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.Senders;
import delta.cion.Violet_NameFormat;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class VioReload implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "reload";}

    @Override
    public String CmdDescription() {return "Reload config";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> commands) {
        Violet_NameFormat.getInstance().reloadConfig();
        Senders.Messages(1, sender);
    }
}
