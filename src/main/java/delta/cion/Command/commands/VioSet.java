package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.ConfigNames;
import delta.cion.Util.Senders;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class VioSet implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "set";}

    @Override
    public String CmdDescription() {return "Set custom nickname for other player";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> commands) {
        Player player = Bukkit.getPlayer(args[0]);
        String nick = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).replace('&', '§');
        if (player == null) {
            Senders.Messages(6, sender); return;
        }
        player.setDisplayName(ConfigNames.hexTranslate(nick));
        ConfigNames.addPlayer(player.getName(), ConfigNames.hexTranslate(nick));
    }
}
