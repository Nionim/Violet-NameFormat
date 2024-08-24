package delta.cion.Command;

import delta.cion.Command.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CmdExecutor implements CommandExecutor, TabCompleter {

    public final ArrayList<CmdUtil> c = new ArrayList<>();

    public CmdExecutor() {
        c.add(new vReset());
        c.add(new vReload());
        c.add(new vColor());
        c.add(new vNick());
        c.add(new vSet());
        c.add(new vCdata());
        // c.add(new VioHelp()); Fix in progress
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, String[] args) {
        for (CmdUtil cmdUtil : c) {
            if (args.length > 0 && args[0].equals(cmdUtil.CmdName()) && (sender.hasPermission("vio."+cmdUtil.CmdName()))) {
                String[] argscmd = Arrays.copyOfRange(args, 1, args.length);
                cmdUtil.CmdUse(sender, argscmd, c);
                return true;
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, String[] args) {
        ArrayList<String> CMDList = new ArrayList<>();
        for (CmdUtil cmdUtil : c) {
            if (sender.hasPermission("vio."+cmdUtil.CmdName()) || sender.hasPermission("vio.name.format.*")) {
                CMDList.add(cmdUtil.CmdName());
            }
            if ((sender.hasPermission("vio.color") || sender.hasPermission("vio.name.format.*")) && args.length >= 2) {
                CMDList.clear();
                CMDList.add("<args>");
            }
        }
        return CMDList;
    }

    public interface CmdUtil {
        String CmdName();
        String CmdDescription();
        void CmdUse(CommandSender sender, String[] args, ArrayList<CmdUtil> cmdUtil);
    }
}
