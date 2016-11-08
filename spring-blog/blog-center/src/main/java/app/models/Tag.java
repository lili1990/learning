package app.models;

/**
 * Created by sdlili on 16-10-29.
 */
public class Tag extends BaseModel {

    public String name;

    public String alias_name;

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
