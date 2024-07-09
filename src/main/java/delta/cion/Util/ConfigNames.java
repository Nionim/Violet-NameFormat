package delta.cion.Util;

import delta.cion.Violet_NameFormat;

import java.io.File;

public class ConfigNames {
    private File configNames = new File(Violet_NameFormat.getInstance().getDataFolder(), "Formats.yml");

    public void ConfigNames() {
        if (!configNames.exists()) {
            try {
                boolean result = configNames.createNewFile();
                if (result) {Senders.Log(0, "Файл ников создан");}
            }
            catch (Exception e) {Senders.Log(3, e.getMessage());}
        }
    }

    // Players:
    //  playername:
    //      format: "&4&l{name}"

    public void addPlayer() {

    }

    public void removePlayer() {

    }
}
