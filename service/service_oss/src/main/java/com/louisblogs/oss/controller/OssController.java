package com.louisblogs.oss.controller;

import com.louisblogs.commonutils.R;
import com.louisblogs.oss.service.OssService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/8 15:58
 */

@Api(tags = "OSS上传头像")
@RestController
@RequestMapping("eduoss/fileoss")
//@CrossOrigin
public class OssController {

	@Autowired
	private OssService ossService;

	//上传头像的方法
	@PostMapping
	public R uploadOssFile(MultipartFile file){
		//获取上传文件 MultipartFile
		String url = ossService.uploadFileAvatar(file);

		return R.ok().data("url",url);
	}

}
