package com.louisblogs.msmservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.louisblogs.msmservice.service.MsmService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/30 21:38
 */

@Service
public class MsmServiceImpl implements MsmService {

	//发送短信的方法
	@Override
	public boolean send(Map<String, Object> param, String phone) {
		if(StringUtils.isEmpty(phone)){ return false;}

		DefaultProfile profile =
			DefaultProfile.getProfile("default", "LTAI5tEezML8G8FdEnxhs7ci", "yNUnHKgsvTqiDogS05AVSaONM58Wd8");
		IAcsClient client = new DefaultAcsClient(profile);

		//设置相关参数
		CommonRequest request = new CommonRequest();
		//request.setProtocol(ProtocolType.HTTPS);
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");

		request.putQueryParameter("PhoneNumbers", phone); //手机号
		request.putQueryParameter("SignName", "我的谷粒在线教育网站");  //申请阿里云签名名称
		request.putQueryParameter("TemplateCode", "SMS_180051135"); //申请阿里云模板code
		request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param)); //验证码数据，转换json数据传递

		try {
			//最终发送
			CommonResponse response = client.getCommonResponse(request);
			boolean success = response.getHttpResponse().isSuccess();
			return success;
		} catch (Exception e) {
			e.printStackTrace();
		}


			return false;
	}

}
