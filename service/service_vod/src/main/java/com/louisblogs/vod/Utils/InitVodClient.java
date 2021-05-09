package com.louisblogs.vod.Utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/22 18:42
 */

@Component
public class InitVodClient {

	public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws Exception {
		String regionId = "cn-shanghai";  // 点播服务接入区域
		DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
		DefaultAcsClient client = new DefaultAcsClient(profile);
		return client;
	}

}
