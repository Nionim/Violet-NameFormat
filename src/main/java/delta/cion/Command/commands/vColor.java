package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.ConfigNames;
import delta.cion.Util.Senders;
import delta.cion.Violet_NameFormat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class vColor implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "color";}

    @Override
    public String CmdDescription() {return "Set color in your nickname";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> commands) {

        String nick = String.join(" ", Arrays.copyOfRange(args, 0, args.length)).replace('&', '§');
        if (!sender.hasPermission("vio.magic-font")) nick = nick.replace("§k", "");

        String nickRaw = nick.replaceAll("#[a-fA-F0-9]{6}", "").replaceAll("§.", "");

        StringBuilder regex = new StringBuilder();
        for (char c : nickRaw.toCharArray()) {
            regex.append(Pattern.quote(String.valueOf(c)));
        }

        nick = nick.replaceAll(regex.toString(), "");

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (nickRaw.length() <= Violet_NameFormat.getInstance().getConfig().getInt("Nick-Max-Length") || sender.hasPermission("vio.length.bypass")) {
                ConfigNames.checkPlayer(player, nick);
            } else {
                Senders.Messages(5, sender);
            }
        } else {
            Senders.Messages(2, sender);
        }
    }
}