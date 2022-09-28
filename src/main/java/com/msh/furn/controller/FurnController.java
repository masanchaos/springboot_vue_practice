package com.msh.furn.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msh.furn.bean.Furn;
import com.msh.furn.service.FurnService;
import com.msh.furn.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class FurnController {
    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    private Result save(@Validated @RequestBody Furn furn, Errors errors){//前端用JSON提交（非表单）才用@RequestBody
//        log.info("furn={}" , furn);
//        furnService.save(furn);
//        return Result.success();
        //定義map 準備把errors中的校驗錯誤放入到map，如果有錯誤信息
        //就不添加，並且將錯誤信息通過map返回給客戶端，客戶端即可取出顯示
        //map的kv是:k = 校驗失敗的字段名 , v =校驗失敗提示的message
        HashMap<Object, Object> map = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        if (map.isEmpty()){//說明沒有校驗錯誤，正常添加
            log.info("furn={}" , furn);
            furnService.save(furn);
            return Result.success();
        }else {
            return Result.error("400","後端校驗失敗!",map);
        }

    }
    @RequestMapping("/furns")
    public Result listFurns(){
        List<Furn> furns = furnService.list();
        return Result.success(furns);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Furn furn){
        //mybatisplus提供
        furnService.updateById(furn);
        return Result.success();

    }

    @DeleteMapping("/del/{id}")
    public Result del(@PathVariable Integer id){
        furnService.removeById(id);
        return Result.success();
    }

    @GetMapping("/find/{id}")
    public Result findById(@PathVariable Integer id){
        Furn furn = furnService.getById(id);
        return Result.success(furn);

    }
    @GetMapping("/furnsByPage")
    public Result listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "5") Integer pageSize){
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize));
        return Result.success(page);
    }
    @GetMapping("/furnsBySearchPage")
    public Result listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                            @RequestParam(defaultValue = "") String search){
        QueryWrapper<Furn> query = Wrappers.query();
        if (StringUtils.hasText(search)){
            query.like("name",search);
        }
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize), query);
        return Result.success(page);
    }

    @GetMapping("/furnsBySearchPage2")
    public Result listFurnsByConditionPage2(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                           @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Furn> lambdaQueryWrapper = Wrappers.lambdaQuery();
        if (StringUtils.hasText(search)){
            lambdaQueryWrapper.like(Furn::getName,search);
        }
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize), lambdaQueryWrapper);
        log.info("page={}",page.getRecords());
        return Result.success(page);
    }

}
