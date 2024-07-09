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

    private final ArrayList<CmdUtil> c = new ArrayList<>();

    public CmdExecutor() {
        c.add(new VioHelp());
        c.add(new VioReset());
        c.add(new VioReload());
        c.add(new VioColor());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, String[] args) {
        for (CmdUtil cmdUtil : c) {
            if (args.length > 0 && args[0].equalsIgnoreCase(cmdUtil.CmdName()) && (sender.hasPermission("vio."+cmdUtil.CmdName()) || sender.hasPermission("vio.name.format.*"))) {
                String[] argscmd = Arrays.copyOfRange(args, 1, args.length);
                cmdUtil.CmdUse(sender, argscmd);
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
        }
        return CMDList;
    }
}
