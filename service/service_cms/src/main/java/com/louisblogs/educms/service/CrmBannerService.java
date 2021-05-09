package com.louisblogs.educms.service;

import com.louisblogs.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author luqi
 * @since 2021-04-30
 */
public interface CrmBannerService extends IService<CrmBanner> {

	//查询所有banner
	List<CrmBanner> selectAllBanner();
}
