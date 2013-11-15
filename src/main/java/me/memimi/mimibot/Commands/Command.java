package me.memimi.mimibot.Commands;

import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 15/11/13
 * Time: 04:12
 * To change this template use File | Settings | File Templates.
 */
public abstract class Command {
    private final String name;
    private final String help;
    protected String command;
    protected String args;

    public Command(String name) {
        this.name = name;
        this.help = "";
    }

    public Command(String name, String help) {
        this.name = name;
        this.help = help;
    }

    public abstract void run(GenericMessageEvent event);

    public String getName() {
        return name;
    }

    public String getHelp() {
        return help;
    }

}
