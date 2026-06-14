package cn.xiaoxin.sdk.infrastructure.openai;


import cn.xiaoxin.sdk.infrastructure.openai.dto.ChatCompletionRequestDTO;
import cn.xiaoxin.sdk.infrastructure.openai.dto.ChatCompletionSyncResponseDTO;

public interface IOpenAI {

    ChatCompletionSyncResponseDTO completions(ChatCompletionRequestDTO requestDTO) throws Exception;

}
