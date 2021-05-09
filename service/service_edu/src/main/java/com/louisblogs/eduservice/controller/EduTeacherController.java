package com.louisblogs.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.louisblogs.commonutils.R;
import com.louisblogs.eduservice.entity.EduTeacher;
import com.louisblogs.eduservice.service.EduTeacherService;
import com.louisblogs.eduservice.entity.vo.TeacherQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description：讲师 前端控制器
 * @author     ：luqi
 * @date       ：2021-03-30 17:45
 */

@Api(tags = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
//@CrossOrigin // 解决跨域问题
@EnableSwaggerBootstrapUI
public class EduTeacherController {

  // 注入service
  @Autowired private EduTeacherService teacherService;

  // 1.查询讲师表所有数据
  // rest风格
  @ApiOperation(value = "所有讲师列表")
  @GetMapping("findAll")
  public R findAllTeacher() {
    // 调用service的方法实现查询所有的操作
    List<EduTeacher> list = teacherService.list(null);
    return R.ok().data("items", list);
  }

  // 2.逻辑删除讲师的方法
  @ApiOperation(value = "逻辑删除讲师")
  @DeleteMapping("{id}")
  public R removeTeacher(@PathVariable String id) {
    boolean flag = teacherService.removeById(id);
    if (flag) {
      return R.ok();
    } else {
      return R.error();
    }
  }

  // 3.分页查询讲师的方法
  // current 当前页
  // limit 每页记录数
  @ApiOperation(value = "分页查询讲师的方法")
  @GetMapping("pageTeacher/{current}/{limit}")
  public R pageListTeacher(@PathVariable long current, @PathVariable long limit) {

    // 创建page对象
    Page<EduTeacher> pageTeacher = new Page<>(current, limit);
    // 调用方法实现分页
    // 调用方法时候，底层封装，把分页所有数据封装到pageTeacher对象里面
    teacherService.page(pageTeacher, null);

    long total = pageTeacher.getTotal(); // 总记录数
    List<EduTeacher> records = pageTeacher.getRecords(); // 数据list集合

    /*Map map = new HashMap();
    map.put("total",total);
    map.put("rows",records);
    return R.ok().data(map);*/

    return R.ok().data("total", total).data("rows", records);
  }

  // 4.条件查询带分页的方法
  @ApiOperation("条件查询带分页的方法")
  @PostMapping("pageTeacherCondition/{current}/{limit}")
  public R pageTeacherCondition(
      @PathVariable long current,
      @PathVariable long limit,
      @RequestBody(required = false) TeacherQuery teacherQuery) {
    // 创建一个page对象
    Page<EduTeacher> pageTeacher = new Page<>(current, limit);
    // 构建条件
    QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
    // 多条件组合查询
    // 动态SQL
    // 判断条件值是否为空，如果不为空拼接条件
    String name = teacherQuery.getName();
    Integer level = teacherQuery.getLevel();
    String begin = teacherQuery.getBegin();
    String end = teacherQuery.getEnd();
    if (!StringUtils.isEmpty(name)) {
      // 构建条件
      wrapper.like("name", name);
    }
    if (!StringUtils.isEmpty(level)) {
      wrapper.eq("level", level);
    }
    if (!StringUtils.isEmpty(begin)) {
      wrapper.ge("gmt_create", begin);
    }
    if (!StringUtils.isEmpty(end)) {
      wrapper.le("gmt_modified", end);
    }
    // 排序
    wrapper.orderByDesc("gmt_create");
    // 调用方法实现条件查询
    teacherService.page(pageTeacher, wrapper);

    long total = pageTeacher.getTotal(); // 总记录数
    List<EduTeacher> records = pageTeacher.getRecords(); // 数据list集合
    return R.ok().data("total", total).data("rows", records);
  }

  // 5.添加讲师接口的方法
  @ApiOperation("添加讲师方法")
  @PostMapping("addTeacher")
  public R addTeacher(@RequestBody EduTeacher eduTeacher) {
    boolean save = teacherService.save(eduTeacher);
    if (save) {
      return R.ok();
    } else {
      return R.error();
    }
  }

  // 6.修改讲师接口的方法
  // 6.1.根据讲师id进行查询
  @ApiOperation("修改讲师_根据讲师id进行查询")
  @GetMapping("getTeacher/{id}")
  public R getTeacher(@PathVariable String id) {
    EduTeacher eduTeacher = teacherService.getById(id);
    return R.ok().data("teacher", eduTeacher);
  }
  // 6.2.讲师修改功能
  @ApiOperation("修改讲师_讲师修改功能")
  @PostMapping("updateTeacher")
  public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
    boolean flag = teacherService.updateById(eduTeacher);
    if (flag) {
      return R.ok();
    } else {
      return R.error();
    }
  }
}
