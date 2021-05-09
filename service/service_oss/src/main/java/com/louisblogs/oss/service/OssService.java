package com.louisblogs.oss.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/8 15:54
 */

public interface OssService {

	//上传头像到OSS
	String uploadFileAvatar(MultipartFile file);

}
