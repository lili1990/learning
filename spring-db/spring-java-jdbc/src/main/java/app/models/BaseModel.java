package app.models;

/**
 * Created by lili19289 on 2016/12/27.
 */
public class BaseModel {

    public long id;

    public long create_time=System.currentTimeMillis();

    public long update_time=System.currentTimeMillis();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }
}
