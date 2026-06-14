package cn.xiaoxin.sdk;

import cn.xiaoxin.sdk.domain.service.impl.OpenAiCodeReviewService;
import cn.xiaoxin.sdk.infrastructure.git.GitCommand;
import cn.xiaoxin.sdk.infrastructure.openai.IOpenAI;
import cn.xiaoxin.sdk.infrastructure.openai.impl.ChatGLM;
import cn.xiaoxin.sdk.infrastructure.weixin.impl.WeiXin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: xhq
 * @CreateTime: 2026-06-02
 * @Description:
 * @Version: 1.0
 */
public class OpenAiCodeReview {

    private static final Logger logger = LoggerFactory.getLogger(OpenAiCodeReview.class);

    // 配置配置
    private String weixin_appid = "wx28bfbca84a4d66e0";
    private String weixin_secret = "300bd673fcccd03195f3af933bbc3521";
    private String weixin_touser = "otfOo6lF6gqhan32BuEAj252Z2z4";
    private String weixin_template_id = "xQXZFaATarDvBZIkF3b7NCiCxyBk9miFkSrTydG5ZNM";

    // ChatGLM 配置
    private String chatglm_apiHost = "https://open.bigmodel.cn/api/paas/v4/chat/completions";
    private String chatglm_apiKeySecret = "";

    // Github 配置
    private String github_review_log_uri;
    private String github_token;

    // 工程配置 - 自动获取
    private String github_project;
    private String github_branch;
    private String github_author;

    public static void main(String[] args) throws Exception {
        GitCommand gitCommand = new GitCommand(
                getEnv("GITHUB_REVIEW_LOG_URI"),
                getEnv("GITHUB_TOKEN"),
                getEnv("COMMIT_PROJECT"),
                getEnv("COMMIT_BRANCH"),
                getEnv("COMMIT_AUTHOR"),
                getEnv("COMMIT_MESSAGE")
        );

        /**
         * 项目：{{repo_name.DATA}} 分支：{{branch_name.DATA}} 作者：{{commit_author.DATA}} 说明：{{commit_message.DATA}}
         */
        WeiXin weiXin = new WeiXin(
                getEnv("WEIXIN_APPID"),
                getEnv("WEIXIN_SECRET"),
                getEnv("WEIXIN_TOUSER"),
                getEnv("WEIXIN_TEMPLATE_ID")
        );


        IOpenAI openAI = new ChatGLM(getEnv("CHATGLM_APIHOST"), getEnv("CHATGLM_APIKEYSECRET"));

        OpenAiCodeReviewService openAiCodeReviewService = new OpenAiCodeReviewService(gitCommand, openAI, weiXin);
        openAiCodeReviewService.exec();

        logger.info("openai-code-review done!");
    }

    private static String getEnv(String key) {
        String value = System.getenv(key);
        if (null == value || value.isEmpty()) {
            throw new RuntimeException("value is null");
        }
        return value;
    }

}
