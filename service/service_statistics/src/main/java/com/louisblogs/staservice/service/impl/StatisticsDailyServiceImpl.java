package com.louisblogs.staservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.louisblogs.commonutils.R;
import com.louisblogs.commonutils.ordervo.UcenterMemberOrder;
import com.louisblogs.staservice.client.UcenterClient;
import com.louisblogs.staservice.entity.StatisticsDaily;
import com.louisblogs.staservice.mapper.StatisticsDailyMapper;
import com.louisblogs.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author luqi
 * @since 2021-05-04
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

	@Autowired
	private UcenterClient ucenterClient;

	//统计某一天的注册人数,生成统计数据
	@Override
	public void registerCount(String day) {
		//添加记录之前删除表相同日期的数据
		QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
		wrapper.eq("date_calculated",day);
		baseMapper.delete(wrapper);

		//远程调用得到某一天注册人数
		R registerR = ucenterClient.countRegister(day);
		Integer countRegister = (Integer) registerR.getData().get("countRegister");

		//把获取数据添加数据库，统计分析表里面
		StatisticsDaily sta = new StatisticsDaily();
		sta.setRegisterNum(countRegister);   //注册人数
		sta.setDateCalculated(day);   //统计日期

		sta.setVideoViewNum(RandomUtils.nextInt(100,200));
		sta.setLoginNum(RandomUtils.nextInt(100,200));
		sta.setCourseNum(RandomUtils.nextInt(100,200));

		baseMapper.insert(sta);
	}

	//图表显示，返回两部分数据，日期json数组，数量json数组
	@Override
	public Map<String, Object> getShowData(String type, String begin, String end) {
		//根据条件查询对应数据
		QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
		wrapper.between("date_calculated",begin,end);
		wrapper.select("date_calculated",type);
		List<StatisticsDaily> staList = baseMapper.selectList(wrapper);

		//因为返回又两部分数据：日期 和 日期对应数量
		//前端要求数组json结构，对应后端java代码时list集合
		//创建两个list集合，一个日期list，一个数量list
		List<String> date_calculatedList = new ArrayList<>();
		List<Integer> numDataList = new ArrayList<>();

		//遍历查询所有数据list集合，进行封装
		for (int i = 0; i < staList.size(); i++) {
			StatisticsDaily daily = staList.get(i);
			date_calculatedList.add(daily.getDateCalculated());
			switch (type) {
				case "register_num":
					numDataList.add(daily.getRegisterNum());
					break;
				case "login_num":
					numDataList.add(daily.getLoginNum());
					break;
				case "video_view_num":
					numDataList.add(daily.getVideoViewNum());
					break;
				case "course_num":
					numDataList.add(daily.getCourseNum());
					break;
				default:
					break;
			}
		}

		//把封装之后两个list集合放到map集合进行返回
		Map<String,Object> map = new HashMap<>();
		map.put("date_calculatedList",date_calculatedList);
		map.put("numDataList",numDataList);
		return map;
	}

}
