package delta.cion.Util;

import delta.cion.Violet_NameFormat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class Senders {

    static String prefix = "&5&lVioNick&8&l >>&r ";
    static String line = "\n&7&l———————————[&5&lVioNick&7&l]———————————\n";
    static String cmdline = line.replaceAll("—", "——");


    // Ваще похуй на устаревание ChatColor, он слишком имбовый.
    private static void senderMsg(CommandSender sender, String msg){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
    private static void cmdMsg(String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + msg));
    }

    public static void Log(int lvl, String msg){
        switch(lvl) {
            case 52: cmdMsg("&4&n"+msg+" &8(&eDEBUG&8)");   break;
            case 62: cmdMsg(cmdline+msg+cmdline);           break;
            case 0: cmdMsg("&f"+msg);                       break;
            case 1: cmdMsg("&e"+msg);                       break;
            case 2: cmdMsg("&c"+msg);                       break;
            case 3: cmdMsg("&4"+msg);                       break;
        }
    }

    public static void Msg(int lvl, CommandSender sender, String msg) {
        switch(lvl) {
            case 0: senderMsg(sender, line+msg+line);   break;
            case 1: senderMsg(sender, prefix+msg);      break;
        }
    }

    public static String MSG(String text) {
        return Objects.requireNonNull(Violet_NameFormat.getInstance().getConfig().getConfigurationSection("Messages")).getString(text);
    }

    public static void Messages(int lvl, CommandSender sender) {
        // А почему нет? Удобно, не мешает, просто.
        try {
            switch (lvl) {
                case 0: senderMsg(sender, prefix + MSG("Unknown-Command")); break;
                case 1: senderMsg(sender, prefix + MSG("Config-Reloaded")); break;
                case 2: senderMsg(sender, prefix + MSG("Only-Player"));     break;
                case 3: senderMsg(sender, prefix + MSG("Args-Missing"));    break;
                case 4: senderMsg(sender, prefix + MSG("Help"));            break;
                case 5: senderMsg(sender, prefix + MSG("Max-Limit"));       break;
                case 6: senderMsg(sender, prefix + MSG("No-Player"));       break;
            }
        } catch (Exception e) {Senders.Msg(1, sender, "Senders.Messages -> Unknown \"int lvl\"! Contact with @nionim (In Discord)");}
    }
}
