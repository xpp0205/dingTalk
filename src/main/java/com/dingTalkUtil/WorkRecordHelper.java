package com.dingTalkUtil;

public class WorkRecordHelper {

    //发起待办
    //企业可以调用该接口发起一个待办事项，该待办事项会出现在钉钉客户端“待办事项”页面，与钉钉审批待办事项并列
//    public Long addWorkRecord(){
//        try {
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/workrecord/add");
//            OapiWorkrecordAddRequest req = new OapiWorkrecordAddRequest();
//            req.setUserid("manager7078");
//            req.setCreateTime(1496678400000L);
//            req.setTitle("title");
//            req.setUrl("https://oa.dingtalk.com");
//            List<FormItemVo> list2 = new ArrayList<FormItemVo>();
//            FormItemVo obj3 = new FormItemVo();
//            list2.add(obj3);
//            obj3.setTitle("标题");
//            obj3.setContent("内容");
//            req.setFormItemList(list2);
//            OapiWorkrecordAddResponse rsp = client.execute(req, access_token);
//            System.out.println(rsp.getBody());
//        }catch (ApiException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
