package com.louisblogs.msmservice.service;

import java.util.Map;

/**
 * @author ：luqi
 * @description：TODO
 * @date ：2021/4/30 21:37
 */

public interface MsmService {
	boolean send(Map<String, Object> param, String phone);
}
