package app.vo;

import app.main.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by lili19289 on 2016/11/7.
 */
public class ResultVO {

    /**
     * 返回状态：“true”表示成功；“false”表示失败
     */
    public String status;
    /**
     * 返回状态码
     */
    public int statusCode;

    public String msg;
    /**
     * 结果
     */
    public Object result;

    public Collection<? extends Object > list;

    public Long systemTime;

    public ResultVO() {
        systemTime = System.currentTimeMillis();
    }

    public static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    }

    public static String failed(int statusCode) {
        ResultVO vo = new ResultVO();
        vo.status = "false";
        vo.statusCode = statusCode;
        try {
            return mapper.writeValueAsString(vo);
        } catch (IOException e) {
            Logger.info("vo failed : " + e.getMessage());
            return null;
        }
    }

    public static String failed(String msg) {
        ResultVO vo = new ResultVO();
        vo.status = "false";
        vo.msg = msg;
        try {
            return mapper.writeValueAsString(vo);
        } catch (IOException e) {
            Logger.info("vo failed : " + e.getMessage());
            return null;
        }
    }

    public static String failed(int statusCode, String msg) {
        ResultVO vo = new ResultVO();
        vo.status = "false";
        vo.statusCode = statusCode;
        vo.msg = msg;
        try {
            return mapper.writeValueAsString(vo);
        } catch (IOException e) {
            Logger.info("vo failed : " + e.getMessage());
            return null;
        }
    }

    public static String succeed(Object result) {
        ResultVO vo = new ResultVO();
        vo.status = "true";

        vo.result = result;
        try {
            return mapper.writeValueAsString(vo);
        } catch (IOException e) {
            Logger.info("vo failed : " + e.getMessage());
            return null;
        }
    }

    public static String succeed(Collection  list) {
        ResultVO vo = new ResultVO();
        vo.status = "true";
        vo.list=list;
        try {
            return mapper.writeValueAsString(vo);
        } catch (IOException e) {
            Logger.info("vo failed : " + e.getMessage());
            return null;
        }
    }
}
