package me.memimi.mimibot.Commands;

import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 04:58
 * To change this template use File | Settings | File Templates.
 */
public class CommandRaw extends Command{

    public CommandRaw() {
        super("raw", "Allows sending of raw IRC commands.");
    }

    @Override
    public void run(GenericMessageEvent event) {
        String[] messageArr = event.getMessage().split(" ", 2);
        event.getBot().sendRaw().rawLineNow(messageArr[1]);
    }
}
