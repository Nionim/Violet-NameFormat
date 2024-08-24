package delta.cion.Command.commands;

import delta.cion.Command.CmdExecutor;
import delta.cion.Util.MsgBuffer;
import delta.cion.Util.Senders;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class vHelp implements CmdExecutor.CmdUtil {
    @Override
    public String CmdName() {return "help";}

    @Override
    public String CmdDescription() {return "Help command! :D";}

    @Override
    public void CmdUse(CommandSender sender, String[] args, ArrayList<CmdExecutor.CmdUtil> commands) {
        MsgBuffer msgBuffer = new MsgBuffer();
        msgBuffer.bufClear();
        for (CmdExecutor.CmdUtil cmdUtil : commands) {
            String format = cmdUtil.CmdName() + " - " + cmdUtil.CmdDescription();
            msgBuffer.bufAppend(format);
        }
        Senders.Msg(1, sender, msgBuffer.getMessage());
    }
}

