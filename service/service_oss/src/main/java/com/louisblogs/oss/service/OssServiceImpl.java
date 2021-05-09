package com.louisblogs.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.louisblogs.oss.Utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author ：luqi
 * @description：OssService实现类
 * @date ：2021/4/8 15:55
 */

@Service
public class OssServiceImpl implements OssService {

	//上传头像到OSS
	@Override
	public String uploadFileAvatar(MultipartFile file) {
		// 工具类获取值
		String endpoint = ConstantPropertiesUtils.END_POIND;
		String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
		String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
		String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

		try {

			// 创建OSSClient实例。
			OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

			// 获取文件上传输入流
			InputStream inputStream = file.getInputStream();

			// 获取文件名称
			String fileName = file.getOriginalFilename();

			//1. 在文件名称里面添加 随机唯一的值
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			fileName = uuid + fileName;

			//2. 将文件按照日期进行分类
			// 获取当前日期
			String datePath = new DateTime().toString("yyyy/MM/dd");

			// 拼接
			fileName = datePath + "/" + fileName;

			// 调用OSS方法实现上传
			// 第一个参数 Bucket名称
			// 第二个参数 上传到oss文件路径和名称
			// 第三个参数 上传文件输入流
			ossClient.putObject(bucketName, fileName, inputStream);

			// 关闭OSSClient。
			ossClient.shutdown();

			// 把文件之后文件路径返回
			// 需要把上传到 阿里云oss路径手动拼接出来
			// https://louisblogs-academy.oss-cn-beijing.aliyuncs.com/myPhoto.png
			String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
			return url;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
