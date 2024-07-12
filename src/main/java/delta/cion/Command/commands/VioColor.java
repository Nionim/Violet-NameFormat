package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.ConfigNames;
import delta.cion.Util.Senders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VioColor implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "color";}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = Bukkit.getPlayer(sender.getName());
            ConfigNames.checkPlayer(player, args[0].replace('&', '§'));
        } else {
            Senders.Messages(2, sender);
        }
    }
}