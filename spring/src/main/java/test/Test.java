package test;

import app.utils.JackSonUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lili19289 on 2016/11/23.
 */
public class Test {


    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1", "1-1|2");
        map.put("2", "11233");
        String str = JackSonUtil.toJson(map);
        testTT tmp = JackSonUtil.fromJson(str,testTT.class);

        System.out.print(str);
    }

    class testTT implements Serializable {
        private String fare;
        private String test;

        public String getFare() {
            return fare;
        }

        public void setFare(String fare) {
            this.fare = fare;
        }

        public String getTest() {
            return test;
        }

        public void setTest(String test) {
            this.test = test;
        }
    }



}
