package app.main;

import com.google.gson.JsonObject;

import java.util.Collection;

/**
 * Created by lili19289 on 2016/9/13.
 */
public class Plugin implements Comparable<Plugin> {
    /**
     * Plugin priority (0 for highest priority)
     */
    public int index;

    /**
     * Called at plugin loading
     */
    public void onLoad() {
    }

    public boolean compileSources() {
        return false;
    }

    /**
     * Return the plugin status
     */
    public String getStatus() {
        return null;
    }

    /**
     * Return the plugin status in JSON format
     */
    public JsonObject getJsonStatus() {
        return null;
    }

    /**
     * Called at application start (and at each reloading)
     * Time to start stateful things.
     */
    public void onApplicationStart() {
    }

    /**
     * Called after the application start.
     */
    public void afterApplicationStart() {
    }

    /**
     * Called at application stop (and before each reloading)
     * Time to shutdown stateful things.
     */
    public void onApplicationStop() {
    }

    @Override
    public int compareTo(Plugin o) {
        int res = index < o.index ? -1 : (index == o.index ? 0 : 1);
        if (res != 0) {
            return res;
        }

        // index is equal in both plugins.
        // Sort on class type to get consistent order
        res = this.getClass().getName().compareTo(o.getClass().getName());
        if (res != 0) {
            // classnames where different
            return res;
        }

        // Identical classnames.
        // Sort on instance to get consistent order.
        // We only return 0 (equal) if both identityHashCode are identical
        // which is only the case if both this and other are the same object instance.
        // This is consistent with equals() when no special equals-method is implemented.
        int thisHashCode = System.identityHashCode(this);
        int otherHashCode = System.identityHashCode(o);
        return (thisHashCode < otherHashCode ? -1 : (thisHashCode == otherHashCode ? 0 : 1));
    }




}
