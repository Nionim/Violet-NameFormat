package delta.cion.Command;

import delta.cion.Anvil.AnvilColorize;
import delta.cion.Command.commands.*;
import delta.cion.Util.LoginEvent;
import delta.cion.Violet_NameFormat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            if ((sender.hasPermission("vio.color") || sender.hasPermission("vio.name.format.*")) && args.length > 0) {
                CMDList.add("<args>");
            }
        }
        return CMDList;
    }

    public interface CmdUtil {
        String CmdName();
        void CmdUse(CommandSender sender, String[] args);
    }
    public static void Enablez() {
        Violet_NameFormat.getInstance().saveDefaultConfig();
        Objects.requireNonNull(Violet_NameFormat.getInstance().getCommand("vionf")).setExecutor(new CmdExecutor());
        Objects.requireNonNull(Violet_NameFormat.getInstance().getCommand("vionf")).setTabCompleter(new CmdExecutor());
        Bukkit.getPluginManager().registerEvents(new AnvilColorize(), Violet_NameFormat.getInstance());
        Bukkit.getPluginManager().registerEvents(new LoginEvent(), Violet_NameFormat.getInstance());
    }
}
