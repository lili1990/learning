package app.main;

import app.plugs.PluginCollection;
import app.utils.PropertiesUtil;
import org.apache.commons.codec.language.bm.Lang;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.print.attribute.standard.JobPriority;
import java.io.File;
import java.rmi.UnexpectedException;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lili19289 on 2016/8/29.
 * 从配置文件中读取配置信息
 */
public class Configure {

    public static boolean started = false;
    public static File applicationPath = null;
    public static Properties configuration;
    public static File tmpDir = null;
    public static boolean readOnlyTmp = false;

    public static PluginCollection pluginCollection = new PluginCollection();


    public static void init(File root){
        applicationPath = root;
        readConfiguration();
        Logger.init();
        String logLevel = configuration.getProperty("application.log", "INFO");
        if (!Logger.configuredManually) {
            Logger.setUp(logLevel);
        }
        Logger.recordCaller = Boolean.parseBoolean(configuration.getProperty(
                "application.log.recordCaller", "false"));
        Logger.info("Starting %s", new Object[] { root.getAbsolutePath() });
        if (configuration.getProperty("application.tmp", "tmp").equals("none")) {
            tmpDir = null;
            Logger.debug(
                    "No tmp folder will be used (application.tmp is set to none)",
                    new Object[0]);
        } else {
            tmpDir = new File(configuration.getProperty("application.tmp", "tmp"));
            if (!tmpDir.isAbsolute()) {
                tmpDir = new File(applicationPath, tmpDir.getPath());
            }

            if (Logger.isTraceEnabled()) {
                Logger.trace("Using %s as tmp dir", new Object[] { tmpDir });
            }

            if (!tmpDir.exists()) {
                try {
                    if (readOnlyTmp) {
                        throw new Exception("ReadOnly tmp");
                    }

                    tmpDir.mkdirs();
                } catch (Throwable arg4) {
                    tmpDir = null;
                    Logger.warn(
                            "No tmp folder will be used (cannot create the tmp dir)",
                            new Object[0]);
                }
            }
            pluginCollection.loadPlugins();
            start();
        }

    }

    public static synchronized void start() {
        if (started) {
            stop();
        }
        try {
            pluginCollection.onApplicationStart();
        } catch (Exception e) {
            Logger.error("plugin onApplicationStart failded...",e);
        }
        started = true;
        try {
            pluginCollection.afterApplicationStart();
        } catch (UnexpectedException e) {
            Logger.error("plugin afterApplicationStart failded...",e);
        }
    }
    public static synchronized void stop() {
        if (started) {
            Logger.trace("Stopping the play application", new Object[0]);
            pluginCollection.onApplicationStop();
            started = false;
        }

    }

    public static void readConfiguration() {
        configuration = PropertiesUtil.getFromFile("conf/application.conf");
    }


    public static String getDateFormat() {
        String localizedDateFormat = configuration
                .getProperty("date.format." +  LocaleContextHolder.getLocale());
        if (!StringUtils.isEmpty(localizedDateFormat)) {
            return localizedDateFormat;
        } else {
            String globalDateFormat = configuration
                    .getProperty("date.format");
            return !StringUtils.isEmpty(globalDateFormat) ? globalDateFormat
                    : "yyyy-MM-dd";
        }
    }




}
