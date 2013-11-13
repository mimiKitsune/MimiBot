package me.memimi.mimibot;

import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: greg
 * Date: 13/11/13
 * Time: 00:34
 * To change this template use File | Settings | File Templates.
 */
public class Config extends Properties{

    private Logger logger = new SimpleLoggerFactory().getLogger(this.getClass().getName());

    public Config() {
        File file = new File("bot.conf");

        try {
            super.load(new FileReader(file));
        } catch (IOException e) {
            logger.warn("Config not found, creating example config");
            super.setProperty("botNick", "MimiBot");
            try {
                file.createNewFile();
                super.store(new FileWriter(file), "");
                logger.warn("Example config created");

            } catch (IOException e2) {
                logger.error("Unable to create example config!", e2);
            }
        }

    }

    @Override
    public String getProperty(String key) {
        String value = super.getProperty(key);
        logger.debug("[GET] "+key+": "+value);
        return value;
    }

    @Override
    public Object setProperty(String key, String value) {
        logger.debug("[PUT] "+key+": "+value);
        return super.setProperty(key, value);
    }

    @Override
    public void load(Reader reader) throws IOException {
        logger.debug("Loading config");
        super.load(reader);
    }

}
