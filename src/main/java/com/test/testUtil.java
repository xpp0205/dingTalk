package com.test;

import com.taobao.api.ApiException;
import com.util.AccessTokenUtil;

public class testUtil {

    public static void main(String[] args)throws ApiException {
        String accessToken = AccessTokenUtil.getToken();
//        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/get");
//        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
//        request.setId("1");
//        request.setHttpMethod("GET");
//        OapiDepartmentGetResponse response = client.execute(request, accessToken);
//        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
//        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
//        request.setId("1");
//        request.setHttpMethod("GET");
//        OapiDepartmentListResponse response = client.execute(request, accessToken);

//        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
//        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
//        request.setDepartmentId(69677622L);
//        request.setOffset(0L);
//        request.setSize(10L);
//        request.setHttpMethod("GET");
//        OapiUserSimplelistResponse response = client.execute(request, accessToken);

//        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/report/list");
//        OapiReportListRequest request = new OapiReportListRequest();
//        request.setUserid("045626673829200044");
//        request.setStartTime(System.currentTimeMillis()- TimeUnit.DAYS.toMillis(30));
//        request.setEndTime(System.currentTimeMillis());
//        request.setCursor(0L);
//        request.setSize(1L);
//        OapiReportListResponse response = client.execute(request, accessToken);
        System.out.println(accessToken);
    }
}
