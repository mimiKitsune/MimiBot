package me.memimi.mimibot.Commands;

import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 07:15
 * To change this template use File | Settings | File Templates.
 */
public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Display helpful information on the specified command");
    }

    @Override
    public void run(GenericMessageEvent event) {

    }
}
