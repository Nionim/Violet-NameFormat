package delta.cion.Util;

import delta.cion.Violet_NameFormat;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigNames {
    private static FileConfiguration conf;
    private static ConfigurationSection section;

    // Players:
    //  playername: "&4&l{name}"

    public static void addPlayer(String player, String format) {
        conf = Violet_NameFormat.getInstance().getConfig();
        section = conf.getConfigurationSection("Players");
        if (section == null) {conf.createSection("Players");}

        section.set(player, format);
        Violet_NameFormat.getInstance().saveConfig();
    }

    public static void removePlayer(Player player) {
        conf = Violet_NameFormat.getInstance().getConfig();
        section = conf.getConfigurationSection("Players");
        if (section == null) {conf.createSection("Players");}

        if (section != null || section.contains(player.getName())) {
            section.set(player.getName(), null);
            player.setDisplayName(player.getName());
            Violet_NameFormat.getInstance().saveConfig();
        }
    }

    public static void joinPlayer(Player player) {
        conf = Violet_NameFormat.getInstance().getConfig();
        section = conf.getConfigurationSection("Players");

        if (section != null || section.contains(player.getName())) {

            player.setDisplayName(section.getString(player.getName()));
        }
    }

    public static void checkPlayer(Player player, String color) {
        String playerz = player.getName();
        conf = Violet_NameFormat.getInstance().getConfig();
        section = conf.getConfigurationSection("Players");
        if (section == null) {conf.createSection("Players");}

        player.setDisplayName(hexTranslate(color)+playerz);
        addPlayer(playerz, hexTranslate(color)+playerz);
    }

    public static String hexTranslate(String text) {
        Pattern hexPattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = hexPattern.matcher(text);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hexColor = matcher.group();
            String replacement = hexColor
                    .substring(1) // Убираем #
                    .replaceAll(".", "§$0")
                    .replaceFirst("^", "§x");
            matcher.appendReplacement(buffer, replacement);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
