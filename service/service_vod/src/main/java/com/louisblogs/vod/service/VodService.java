package com.louisblogs.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/25 20:20
 */

public interface VodService {

	//上传视频到阿里云
	String uploadVideoAliyun(MultipartFile file);

	//根据视频id删除阿里云视频
	void removeVideo(String id);

	//删除多个阿里云视频的方法
	void removeMoreAliyunVideo(List videoIdList);
}
