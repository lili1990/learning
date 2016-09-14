package app.plugs;

import app.main.ApplicationClassLoader;
import app.main.Logger;
import app.main.Plugin;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lili19289 on 2016/9/14.
 */
public class PluginCollection {

    protected  static List<String> pluginClasses = new ArrayList<>();
    protected   List<Plugin> allPlugins = new ArrayList();

    static{
        pluginClasses.add("jobs.job.JobPlugin");
    }

    public  void loadPlugins() {
        Logger.info("Loading plugins", new Object[0]);
        for(String className : pluginClasses) {
            try {
                Class clazz = Class.forName(className);
                Plugin plugin = (Plugin) clazz.newInstance();
                allPlugins.add(plugin);
            } catch (ClassNotFoundException e) {
                Logger.error("loading plugins failded",e);
            } catch (InstantiationException e) {
                Logger.error("loading plugins failded",e);
            } catch (IllegalAccessException e) {
                Logger.error("loading plugins failded",e);
            }
        }


    }

    public void onApplicationStart() {
        for(Plugin plugin : allPlugins){
            plugin.onApplicationStart();
        }

    }

    public void afterApplicationStart() throws UnexpectedException {
        for(Plugin plugin : allPlugins){
            plugin.afterApplicationStart();
        }
    }

    public void onApplicationStop() {
        for(Plugin plugin : allPlugins){
            try {
                plugin.onApplicationStop();
            } catch (Throwable arg3) {
                if (arg3.getMessage() == null) {
                    Logger.error(arg3, "Error while stopping %s",
                            new Object[] { plugin });
                } else if (Logger.isDebugEnabled()) {
                    Logger.debug(arg3, "Error while stopping %s",
                            new Object[] { plugin });
                } else {
                    Logger.info("Error while stopping %s: %s", new Object[] {
                            plugin, arg3.toString() });
                }
            }
        }

    }
}
