package app.models;

/**
 * Created by lili19289 on 2016/12/23.
 */
public class User extends BaseModel{

    private String user_name;
    private Integer age;



    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
