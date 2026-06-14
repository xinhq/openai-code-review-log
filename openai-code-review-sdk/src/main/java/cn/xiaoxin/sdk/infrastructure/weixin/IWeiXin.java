package cn.xiaoxin.sdk.infrastructure.weixin;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * @Author: xhq
 * @CreateTime: 2026-06-14
 * @Description:
 * @Version: 1.0
 */
public interface IWeiXin {
    void sendTemplateMessage(String logUrl, Map<String, Map<String, String>> data) throws Exception;
}
