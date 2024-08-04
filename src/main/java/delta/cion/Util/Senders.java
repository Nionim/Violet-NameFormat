package delta.cion.Util;

import delta.cion.Violet_NameFormat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Senders {

    private static final Violet_NameFormat plugin = Violet_NameFormat.getInstance();
    static String prefix = "&5&lVioNick&8&l >>&r ";
    static String line = "\n&7&l———————————[&5&lVioNick&7&l]———————————\n";
    static String cmdline = line.replaceAll("—", "——");

    private static void send(CommandSender sender, String msg){
        if (sender != null) sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        else Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + msg));
    }

    public static void Log(int lvl, String msg){
        switch(lvl) {
            case 52 -> send(null, "&4&n"+msg+" &8(&eDEBUG&8)");
            case 0 -> send(null, cmdline+msg+cmdline);
            case 1 -> send(null, "&f"+msg);
            case 2 -> send(null, "&e"+msg);
            case 3 -> send(null, "&c"+msg);
        }
    }

    public static void Msg(int lvl, CommandSender sender, String msg) {
        switch(lvl) {
            case 0 -> send(sender, msg);
            case 1 -> send(sender, line+msg+line);
            case 2 -> send(sender, prefix+msg);
        }
    }

    public static String getMsg(String text) {
        return Objects.requireNonNull(plugin.getConfig().getString("Messages."+text));
    }

    public static void Messages(int lvl, CommandSender sender) {
        try {
            switch (lvl) {
                case 0 -> send(sender, prefix + getMsg("Unknown-Command"));
                case 1 -> send(sender, prefix + getMsg("Config-Reloaded"));
                case 2 -> send(sender, prefix + getMsg("Only-Player"));
                case 3 -> send(sender, prefix + getMsg("Args-Missing"));
                case 4 -> send(sender, prefix + getMsg("Help"));
                case 5 -> send(sender, prefix + getMsg("Max-Limit"));
                case 6 -> send(sender, prefix + getMsg("No-Player"));
                case 7 -> send(sender, prefix + getMsg("New-Name")
                        .replace("{newName}", Bukkit.getPlayer(sender.getName()).getDisplayName())
                        .replace("{player}", sender.getName()));
            }
        } catch (Exception e) {Senders.Msg(1, sender, "Senders.Messages -> Unknown \"int lvl\"! Contact with @nionim (In Discord)");}
    }
}
