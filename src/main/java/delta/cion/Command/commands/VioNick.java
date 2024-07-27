package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.ConfigNames;
import delta.cion.Util.Senders;
import delta.cion.Violet_NameFormat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class VioNick implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "nick";}

    @Override
    public void CmdUse(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            String nick = String.join(" ", Arrays.copyOfRange(args, 1, args.length)).replace('&', '§');
            if (!sender.hasPermission("vio.magic-font")) {
                nick = nick.replace("§k", "");
            }
            String nickRaw = nick.replaceAll("#[a-fA-F0-9]{6}", "").replaceAll("&.", "");

            if (nickRaw.length() <= Violet_NameFormat.getInstance().getConfig().getInt("Nick-Max-Length") || sender.hasPermission("vio.length.bypass")) {
                Player player = (Player) sender;
                player.setDisplayName(ConfigNames.hexTranslate(nick));
                ConfigNames.addPlayer(player.getName(), ConfigNames.hexTranslate(nick));
            }
        } else {
            Senders.Messages(2, sender);
        }
    }
}
