package com.dingTalkUtil;

import com.config.Constant;
import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHelper {

    private static final Logger bizLogger = LoggerFactory.getLogger(MessageHelper.class);

    //发送工作消息
    public String sendWorkMessage(String accessToken,String type,String userIdList) {

        DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_SEND_MESSAGE);
        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setUseridList(userIdList);
        request.setAgentId(Constant.AGENT_ID);
        request.setToAllUser(false);

        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();

        if(type.equals(Constant.TEXT)){
            msg.setMsgtype(Constant.TEXT);
            msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
            msg.getText().setContent("test123");
            request.setMsg(msg);
        }
        else if(type.equals(Constant.IMAGE)){
            msg.setMsgtype(Constant.IMAGE);
            msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
            msg.getImage().setMediaId("@lADOdvRYes0CbM0CbA");
            request.setMsg(msg);
        }
        else if(type.equals(Constant.FILE)){
            msg.setMsgtype(Constant.FILE);
            msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
            msg.getFile().setMediaId("@lADOdvRYes0CbM0CbA");
            request.setMsg(msg);
        }
        else if(type.equals(Constant.LINK)){
            msg.setMsgtype(Constant.LINK);
            msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
            msg.getLink().setTitle("test");
            msg.getLink().setText("test");
            msg.getLink().setMessageUrl("test");
            msg.getLink().setPicUrl("test");
            request.setMsg(msg);
        }
        else if(type.equals(Constant.MARKDOWN)){
            msg.setMsgtype(Constant.MARKDOWN);
            msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
            msg.getMarkdown().setText("##### text");
            msg.getMarkdown().setTitle("### Title");
            request.setMsg(msg);
        }
        else if(type.equals(Constant.OA)){
            msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
            msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
            msg.getOa().getHead().setText("head");
            msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
            msg.getOa().getBody().setContent("xxx");
            msg.setMsgtype(Constant.OA);
            request.setMsg(msg);
        }
        else if(type.equals(Constant.ACTION_CARD)){
            msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
            msg.getActionCard().setTitle("xxx123411111");
            msg.getActionCard().setMarkdown("### 测试123111");
            msg.getActionCard().setSingleTitle("测试测试");
            msg.getActionCard().setSingleUrl("https://www.baidu.com");
            msg.setMsgtype(Constant.ACTION_CARD);
            request.setMsg(msg);
        }
        else{
            bizLogger.info("无效的消息类型:"+ type);
        }
        try {
            OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request,accessToken);
            return response.getErrmsg();
        }catch (ApiException e){
            e.printStackTrace();
            return null;
        }
    }
}
