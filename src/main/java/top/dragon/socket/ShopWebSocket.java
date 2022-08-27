package top.dragon.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.dragon.job.DeviceInfo;
import top.dragon.utils.JwtUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ServerEndpoint(value = "/webSocket/{openId}")
public class ShopWebSocket {

    private static Logger logger = LoggerFactory.getLogger(ShopWebSocket.class);

    private JwtUtils jwtUtils;
    private static Map<Session,DeviceInfo> online = new HashMap<>(16);


    private RedisTemplate<String,List<String>> phoneRedisTemplate;


    public ShopWebSocket(){
        this.jwtUtils = new JwtUtils();
    }

    @Autowired
    @Qualifier(value = "phoneRedisTemplate")
    public void setPhoneRedisTemplate(RedisTemplate<String, List<String>> phoneRedisTemplate) {
        this.phoneRedisTemplate = phoneRedisTemplate;
    }

    @OnOpen
    public void onOpen(@PathParam("openId") String openId, Session session) throws IOException {
        logger.info("open openId:{}",openId);
        Claims claims = jwtUtils.parseJWTToken(openId);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setUid(claims.get("Id",Integer.class));
        online.put(session,deviceInfo);
    }
    @OnClose
    public void onClose(@PathParam("openId") String openId,Session session) {
        logger.info("close openId:{}",openId);
        try {
            session.close();
        } catch (IOException e) {
            logger.info("close exception:{}",e.getMessage());
        }
    }
    @OnMessage
    public void onMessage(Session session, String msg) throws IOException, InterruptedException {
        logger.info("msg:{}",msg);
        JSONObject jsonObject = JSON.parseObject(msg);
        switch (jsonObject.getInteger("code")){
            case -1:
                session.close();
                break;
            case 0:
                //设备信息存储
                online.get(session).setDeviceId(jsonObject.getString("deviceId"));
                break;
            case 1:
                //在线卡数
                List<String> cardInfos = JSON.parseArray(jsonObject.getString("data"), String.class);
                phoneRedisTemplate.opsForValue().set(online.get(session).getDeviceId(),cardInfos);
                online.get(session).setCards(cardInfos);
                online.get(session).setNumber(cardInfos.size());
                break;
            case 2:
                //
            default:
                break;
        }


    }
    /**
     * 配置错误信息处理
     * @param session
     * @param t
     */
    @OnError
    public void onError(Session session, Throwable t) {
        //什么都不想打印都去掉就好了
        logger.info("【websocket消息】出现未知错误 ");
        //打印错误信息，如果你不想打印错误信息，去掉就好了
        //这里打印的也是  java.io.EOFException: null
        logger.info("msg:{}",t.getMessage());
    }

}
