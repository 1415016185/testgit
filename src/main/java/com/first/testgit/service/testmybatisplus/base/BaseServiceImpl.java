package com.first.testgit.service.testmybatisplus.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.first.testgit.service.testmybatisplus.base.BaseService;

/**
 * @author:jiaxingxu  次要基础的service
 **/
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

//应该做一些分页的操作
}
