package com.louisblogs.eduservice.client;

import com.louisblogs.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/28 20:28
 */

@Component
public class VodFileDegradeFeignClient implements VodClient {
	//出错之后会执行
	@Override
	public R removeAliyunVideo(String id) {
		return R.error().message("删除视频出错了");
	}

	@Override
	public R deleteBatch(List<String> videoIdList) {
		return R.error().message("删除多个视频出错了");
	}
}
