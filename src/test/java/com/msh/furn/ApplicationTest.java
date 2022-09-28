package com.msh.furn;

import com.msh.furn.bean.Furn;
import com.msh.furn.mapper.FurnMapper;
import com.msh.furn.service.FurnService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Resource
    private FurnMapper furnMapper;

    @Test
    public void testFurnMapper(){
        System.out.println(furnMapper.getClass());
        Furn furn = furnMapper.selectById(4);
        System.out.println(furn);
    }
    @Resource
    private FurnService furnService;
    @Test
    public void testFurnService(){
        List<Furn> list = furnService.list();
        for (Furn furn : list) {
            System.out.println(furn);

        }
    }
}
