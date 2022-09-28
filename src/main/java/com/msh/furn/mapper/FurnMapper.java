package com.msh.furn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msh.furn.bean.Furn;
import org.apache.ibatis.annotations.Mapper;


//這邊如果不用@Mapper是因为Applicaiton有設置掃包
@Mapper
public interface FurnMapper extends BaseMapper<Furn> {// BaseMapper<Furn>擴展功能

}
