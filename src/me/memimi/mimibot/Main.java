package me.memimi.mimibot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLogger;
import org.slf4j.impl.SimpleLoggerFactory;

public class Main {

    protected static Config config;

    public static void main(String[] args) throws Exception {

        config = new Config();

        //Setup Logger
        System.setProperty(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        System.setProperty(SimpleLogger.DATE_TIME_FORMAT_KEY, "[HH:mm:ss]");
        System.setProperty(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
        System.setProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        System.setProperty(SimpleLogger.SHOW_LOG_NAME_KEY, "true");
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
        Logger logger = new SimpleLoggerFactory().getLogger(Main.class.getName());

        //Setup this bot
        Configuration.Builder builder = new Configuration.Builder();
        builder.setName(config.getProperty("botNick"));
        builder.setRealName(config.getProperty("botRealName"));
        builder.setLogin(config.getProperty("botLogin"));
        builder.setNickservPassword(config.getProperty("botNickservPassword"));
        builder.setAutoNickChange(true);
        builder.addListener(new BotListener());
//        builder.setServer("memimi.me", 22918, "")
        builder.setServerHostname("fox.seion.us");
        builder.addAutoJoinChannel("#mimi");
        Configuration configuration = builder.buildConfiguration();
        PircBotX bot = new PircBotX(configuration);

//Connect to server
        try {
            logger.debug("staring bot");
            bot.startBot();

        } catch (Exception ex) {
            logger.error(null, ex);
            ex.printStackTrace();
        }
    }
}
