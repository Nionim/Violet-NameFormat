package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.Senders;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vCdata implements CmdExecutor.CmdUtil {

    @Override
    public String CmdName() {return "cmdata";}

    @Override
    public String CmdDescription() {return "Set custom model data";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> cmdUtil) {
        if (!(sender instanceof Player)) Senders.Messages(6, sender);
        else if (((Player) sender).getInventory().getItemInMainHand().getType() == Material.AIR) Senders.Messages(8, sender);
        else if (args[0] == null || args[0].isBlank()) Senders.Messages(8, sender);
        else if (args[0].length() > 7) Senders.Messages(8, sender);
        else {
            try {
                Player player = (Player) sender;
                player.getInventory().getItemInMainHand().getItemMeta().setCustomModelData(Integer.parseInt(args[0]));
            } catch (Exception e) {
                Senders.Messages(9, sender);
            }
        }
    }
}
