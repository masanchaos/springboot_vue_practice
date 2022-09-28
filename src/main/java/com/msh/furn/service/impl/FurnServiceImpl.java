package com.msh.furn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msh.furn.bean.Furn;
import com.msh.furn.mapper.FurnMapper;
import com.msh.furn.service.FurnService;
import org.springframework.stereotype.Service;

@Service
public class FurnServiceImpl extends ServiceImpl<FurnMapper, Furn> implements FurnService {

}
