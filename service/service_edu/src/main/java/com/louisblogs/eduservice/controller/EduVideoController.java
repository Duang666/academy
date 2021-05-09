package com.louisblogs.eduservice.controller;


import com.louisblogs.commonutils.R;
import com.louisblogs.eduservice.client.VodClient;
import com.louisblogs.eduservice.entity.EduChapter;
import com.louisblogs.eduservice.entity.EduVideo;
import com.louisblogs.eduservice.service.EduVideoService;
import com.louisblogs.servicebase.exceptionhandler.LouisblogsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author luqi
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/eduservice/video")
//@CrossOrigin
public class EduVideoController {

	@Autowired
	private EduVideoService videoService;

	//注入vodclient
	@Autowired
	private VodClient vodClient;

	//添加小节
	@PostMapping("addVideo")
	public R addVideo(@RequestBody EduVideo eduVideo){
		videoService.save(eduVideo);
		return R.ok();
	}

	//根据小节id查询
	@GetMapping("getVideoInfo/{videoId}")
	public R getVideoInfo(@PathVariable String videoId){
		EduVideo eduVideo = videoService.getById(videoId);
		return R.ok().data("video",eduVideo);
	}

	//修改小节
	@PostMapping("updateVideo")
	public R updateVideo(@RequestBody EduVideo eduVideo){
		videoService.updateById(eduVideo);
		return R.ok();
	}

	//删除小节，删除对应阿里云视频
	@DeleteMapping("{id}")
	public R deleteVideo(@PathVariable String id){

		//根据小节id获取视频id，调用方法实现视频删除
		EduVideo eduVideo = videoService.getById(id);
		String videoSourceId = eduVideo.getVideoSourceId();

		//判断小节里面是否有视频id
		if(!StringUtils.isEmpty(videoSourceId)){
			//根据视频id，远程调用实现视频删除
			R result = vodClient.removeAliyunVideo(videoSourceId);
			if(result.getCode() == 20001) {
				throw new LouisblogsException(20001,"删除视频失败，熔断器。。。");
			}
		}

		//删除小节
		videoService.removeById(id);
		return R.ok();

	}

}





















