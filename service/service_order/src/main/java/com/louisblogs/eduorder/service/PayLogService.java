package com.louisblogs.eduorder.service;

import com.louisblogs.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author luqi
 * @since 2021-05-03
 */
public interface PayLogService extends IService<PayLog> {

	//生成微信支付二维码接口
	Map createNative(String orderNo);

	//根据订单号查询订单状态
	Map<String, String> queryPayStatus(String orderNo);

	//向支付表添加记录，更新订单状态
	void updateOrdersStatus(Map<String, String> map);
}
