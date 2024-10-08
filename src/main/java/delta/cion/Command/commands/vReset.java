package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.ConfigNames;
import delta.cion.Util.Senders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vReset implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "reset";}

    @Override
    public String CmdDescription() {return "Reset our nickname";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> commands) {
        if (sender instanceof Player) {
            Player player = Bukkit.getPlayer(sender.getName());
            ConfigNames.removePlayer(player);
        } else {
            Senders.Messages(2, sender);
        }
    }
}
