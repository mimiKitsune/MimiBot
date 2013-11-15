package me.memimi.mimibot.Commands;

import org.pircbotx.hooks.types.GenericMessageEvent;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 04:23
 * To change this template use File | Settings | File Templates.
 */
public class CommandPing extends Command {

    private Logger logger = new SimpleLoggerFactory().getLogger(this.getClass().getName());

    public CommandPing() {
        super("ping", "Returns PONG!");
    }

    @Override
    public void run(GenericMessageEvent event) {
        logger.info("Ping command by "+event.getUser().getNick());
        event.respond("PONG!");
    }
}
