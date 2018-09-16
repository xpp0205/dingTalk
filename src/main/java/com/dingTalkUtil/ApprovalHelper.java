package com.dingTalkUtil;

import com.config.Constant;
import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessGettodonumRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.response.OapiProcessGettodonumResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.taobao.api.ApiException;

import java.util.ArrayList;
import java.util.List;

public class ApprovalHelper {

    //发起审批实例
    public String ProcessinstanceCreate(String accessToken, OapiProcessinstanceCreateRequest entity) {
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_CREATE);
            OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
            request.setAgentId(Constant.AGENT_ID);
            request.setProcessCode(entity.getProcessCode());
            List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
            OapiProcessinstanceCreateRequest.FormComponentValueVo vo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            vo.setName("企业名称");
            vo.setValue("test");
            formComponentValues.add(vo);
            request.setFormComponentValues(formComponentValues);
            request.setApprovers(entity.getApprovers());
            request.setOriginatorUserId(entity.getOriginatorUserId());
            request.setDeptId(entity.getDeptId());
            request.setCcList(entity.getCcList());
            request.setCcPosition(entity.getCcPosition());
            OapiProcessinstanceCreateResponse response = client.execute(request,accessToken);
            return response.getProcessInstanceId();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
    //批量获取审批实例id
//    public List getProcessinstanceListIds(String accessToken){
//        try{
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/listids");
//            OapiProcessinstanceListidsRequest req = new OapiProcessinstanceListidsRequest();
//            req.setProcessCode("PROC-FF6YR2IQO2-NP3LJ1J0SO4182NKX26K3-3N23J-PB");
//            req.setStartTime(1496678400000L);
//            req.setEndTime(1496678400000L);
//            req.setSize(10L);
//            req.setCursor(0L);
//            req.setUseridList("manager1,manager2");
//            OapiProcessinstanceListidsResponse response = client.execute(req, accessToken);
//            return null;
//        }catch (ApiException e){
//            e.printStackTrace();
//            return null;
//        }
//    }

    //获取单个审批实例
    public OapiProcessinstanceGetResponse.ProcessInstanceTopVo getProcessinstance(String accessToken, String processInstanceId){
        try{
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_GET_PROCESSINSTANCE);
            OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
            request.setProcessInstanceId(processInstanceId);
            OapiProcessinstanceGetResponse response = client.execute(request,accessToken);
            return response.getProcessInstance();
        }catch (ApiException e){
            e.printStackTrace();
            return null;
        }
    }

    //获取用户待审批数量
    public Long getProcessInstanceToDoNum(String accessToken,String userId){
        try{
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_GET_PROCESSINSTANCE_TO_DO_NUM);
            OapiProcessGettodonumRequest req = new OapiProcessGettodonumRequest();
            req.setUserid(userId);
            OapiProcessGettodonumResponse response = client.execute(req, accessToken);
            return response.getCount();
        }catch (ApiException e){
            e.printStackTrace();
            return null;
        }
    }
}
