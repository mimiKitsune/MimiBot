package me.memimi.mimibot.Commands;

import me.memimi.mimibot.Main;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 05:09
 * To change this template use File | Settings | File Templates.
 */
public class CommandIdentify extends Command {

    public CommandIdentify() {
        super("identify", "Identifies with NickServ");
    }

    @Override
    public void run(GenericMessageEvent event) {
        event.getBot().sendIRC().message("nickserv", "identify " + Main.getConfig().getBotPassword());
        event.respond("Identifying...");
    }
}
