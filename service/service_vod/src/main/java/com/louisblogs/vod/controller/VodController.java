package com.louisblogs.vod.controller;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.louisblogs.commonutils.R;
import com.louisblogs.servicebase.exceptionhandler.LouisblogsException;
import com.louisblogs.vod.Utils.ConstantVodUtils;
import com.louisblogs.vod.Utils.InitVodClient;
import com.louisblogs.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/25 20:12
 */

@RestController
@RequestMapping("/eduvod/video")
//@CrossOrigin
public class VodController {

	@Autowired
	private VodService vodService;

	//上传视频到阿里云
	@PostMapping("uploadAliyunVideo")
	public R uploadVideoAliyun(MultipartFile file) {
		//返回上传视频id值
		String videoId = vodService.uploadVideoAliyun(file);

		return R.ok().data("videoId", videoId);
	}

	//根据视频id删除阿里云视频
	@DeleteMapping("removeAliyunVideo/{id}")
	public R removeAliyunVideo(@PathVariable String id) {
		vodService.removeVideo(id);
		return R.ok();
	}

	//删除多个阿里云视频的方法
	//参数多个视频id
	@DeleteMapping("delete-batch")
	public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList) {
		vodService.removeMoreAliyunVideo(videoIdList);
		return R.ok();
	}

	//根据视频id获取视频凭证
	@GetMapping("getPlayAuth/{id}")
	public R getPlayAuth(@PathVariable String id) {
		try {
			//创建初始化对象
			DefaultAcsClient client =
					InitVodClient.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
			//创建获取凭证request和response对象
			GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
			//向request设置视频id
			request.setVideoId(id);
			//调用方法得到凭证
			GetVideoPlayAuthResponse response = client.getAcsResponse(request);
			String playAuth = response.getPlayAuth();
			return R.ok().data("playAuth",playAuth);
		}catch(Exception e) {
			throw new LouisblogsException(20001,"获取凭证失败");
		}
	}

}














