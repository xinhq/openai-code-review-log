curl -X POST \
        -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsInNpZ25fdHlwZSI6IlNJR04ifQ.eyJhcGlfa2V5IjoiZDdlMzNjMGM1ZTE3NDNkY2IyYjdjNTRjN2E4YjYzNzIiLCJleHAiOjE3ODEwMDg1NDU0MzgsInRpbWVzdGFtcCI6MTc4MTAwNjc0NTQzOH0.w-pzQIVgjprK2Q6sNQU_kv8je1ZJKYVoyPHajDF_UzU" \
        -H "Content-Type: application/json" \
        -H "User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)" \
        -d '{
          "model":"glm-4",
          "stream": "true",
          "messages": [
              {
                  "role": "user",
                  "content": "1+1"
              }
          ]
        }' \
  https://open.bigmodel.cn/api/paas/v4/chat/completions