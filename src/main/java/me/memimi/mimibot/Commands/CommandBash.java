package me.memimi.mimibot.Commands;

import org.pircbotx.hooks.types.GenericMessageEvent;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 07:12
 * To change this template use File | Settings | File Templates.
 */
public class CommandBash extends Command {

    private Logger logger = new SimpleLoggerFactory().getLogger(this.getClass().getName());

    public CommandBash() {
        super("bash", "Runs the given bash command");
    }

    @Override
    public void run(GenericMessageEvent event) {
        String[] messageArr = event.getMessage().split(" ", 2);
        try {
            logger.info("Bash command by " + event.getUser().getNick() + " command: " + messageArr[1]);
            Runtime.getRuntime().exec(messageArr[1]);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
