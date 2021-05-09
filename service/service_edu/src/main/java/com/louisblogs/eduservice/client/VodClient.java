package com.louisblogs.eduservice.client;

import com.louisblogs.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/27 21:55
 */

@FeignClient(name = "service-vod",fallback = VodFileDegradeFeignClient.class)    //调用的服务名称
@Component
public interface VodClient {

	//定义调用方法路径
	//根据视频id删除阿里云视频
	@DeleteMapping("/eduvod/video/removeAliyunVideo/{id}")
	public R removeAliyunVideo(@PathVariable("id") String id);

	//删除多个阿里云视频的方法
	@DeleteMapping("/eduvod/video/delete-batch")
	public R deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
