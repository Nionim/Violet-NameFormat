package delta.cion.Command.commands;

import delta.cion.Command.CmdUtil;
import delta.cion.Util.Senders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VioNick implements CmdUtil {
    @Override
    public String CmdName() {return "nick";}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        Player player = Bukkit.getPlayer(sender.getName());

        player.setDisplayName(args[0]);
    }
}
