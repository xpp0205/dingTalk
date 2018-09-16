package com.dingTalkUtil;

import com.config.URLConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMediaUploadRequest;
import com.dingtalk.api.response.OapiMediaUploadResponse;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;

public class FileHelper {

    //上传媒体文件
    public OapiMediaUploadResponse uploadFile(String accessToken, String fileType){
        try{
            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_UPLOAD_FILE);
            OapiMediaUploadRequest request = new OapiMediaUploadRequest();
            request.setType(fileType);
            request.setMedia(new FileItem(""));
            OapiMediaUploadResponse response = client.execute(request,accessToken);
            return response;
        }catch (ApiException e){
            e.printStackTrace();
            return null;
        }
    }

    //下载媒体文件
//    public List downloadFile(){
//        try {
//            DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_DOWNLOAD_FILE);
//
//        }catch (ApiException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
