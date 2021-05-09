package com.louisblogs.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/22 18:50
 */

public class TestVod {

	public static void main(String[] args) throws Exception {
		//1 根据视频ID获取视频播放凭证
		//创建初始化对象
		DefaultAcsClient client = InitObject.initVodClient("LTAI5tEezML8G8FdEnxhs7ci", "yNUnHKgsvTqiDogS05AVSaONM58Wd8");

		//创建获取视频地址request和response
		GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
		GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();

		//向request对象里面设置视频id
		request.setVideoId("a02d9128d7a048adb9fc53d44368363f");

		//调用初始化对象里面的方法传递request，获取数据
		response = client.getAcsResponse(request);

		//播放凭证
		System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
	}

	public static void getPlayUrl() throws Exception {
		//1 根据视频ID获取视频播放地址
		//创建初始化对象
		DefaultAcsClient client = InitObject.initVodClient("LTAI5tEezML8G8FdEnxhs7ci", "yNUnHKgsvTqiDogS05AVSaONM58Wd8");

		//创建获取视频地址request和response
		GetPlayInfoRequest request = new GetPlayInfoRequest();
		GetPlayInfoResponse response = new GetPlayInfoResponse();

		//向request对象里面设置视频id
		request.setVideoId("a02d9128d7a048adb9fc53d44368363f");

		//调用初始化对象里面的方法传递request，获取数据
		response = client.getAcsResponse(request);

		List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
		//播放地址
		for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
			System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
		}
		//Base信息
		System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
	}

}















