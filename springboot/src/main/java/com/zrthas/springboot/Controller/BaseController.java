package com.zrthas.springboot.Controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;

/**
 * Controller的使用：
 * 1.@Controller->处理Http请求
 * 2.@RestController->Spring4之后新加的注解，原来返回的json需要@ResponseBody配合@Controller
 * 3.@ResquestMapping->配置Url映射
 */
@RestController
@RequestMapping(value = "/base")
public class BaseController
{
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return "this is base controller";
    }

    /**
     * 使用Url中的参数：
     * @PathVariable->获取URL中的数据
     * @RequestParam->获取请求参数的值
     * @GetMapping->组合注解
     * @return
     */
    @RequestMapping(value ="/useUrlPath/{id}",method = RequestMethod.GET)
    public String useUrlPath(@PathVariable("id") Integer id){
        //测试链接地址：http://localhost:8881/springboot/base/useUrlPath/1
        return "使用PathVariable,参数的值为："+id.toString();
    }

    @RequestMapping(value = "/useRequestMapping",method = RequestMethod.GET)
    public String useRequestMapping(@RequestParam("id") Integer id,@RequestParam(value = "nomust",required = false,defaultValue = "0") Integer nomust){
        //测试链接地址：http://localhost:8881/springboot/base/useRequestMapping?id=100&nomust=9
        return "使用RequestMapping,参数id的值为："+id.toString()+"；nomust的值为："+nomust;
    }

    /**
     * GetMapping = @RequestMapping+method = RequestMethod.GET
     * PostMapping = @RequestMapping+method = RequestMethod.POST
     * 等等
     * @return
     */
    @GetMapping(value = "/useGetMapping")
    public String userOtherMapping(){
        //测试链接地址：http://localhost:8881/springboot/base/useGetMapping
        return "使用GetMapping";
    }
}
