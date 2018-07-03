package com.afei.jktest;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TianXingShuKe {
    @PostMapping(value="/", produces = "application/json;charset=UTF-8")
    public Result queryCenterAnxinqian(@RequestBody JSONObject jsonParam){
        JSONObject jsonObject = jsonParam.getJSONObject("data");
        int getDataWay = jsonObject.getInt("getDataWay");
        String name = jsonObject.getString("name");
        String id_card = jsonObject.getString("id_card");
        String accountNO = jsonObject.getString("accountNO");
        System.out.println(getDataWay);
        Result result = new Result();
        Data data = new Data();
        Map<String,Object> map = new HashMap<>();
      if(getDataWay == 1) {                        //成功时返回参数结构
            result.setCode("S000000");
            result.setMsg("验证成功");
            result.setGetDataWay("others");
            map.put("name",name);
            map.put("identityCard",id_card);
            map.put("accountNO",accountNO);
            map.put("checkStatus","SAME");
            map.put("result","验证成功");
            map.put("success",true);
            result.setData(map);
            return result;
        }else if(getDataWay == 2){                //无数据时返回数据结构
            result.setCode("E0000");
            result.setMsg("查询成功无数据");
            result.setGetDataWay("local");
          return result;
      }else if(getDataWay == 3){                  //不匹配时返回数据结构
          result.setCode("E00");
          result.setMsg("验证失败,信息不匹配");
          result.setGetDataWay("others");
          map.put("name",name);
          map.put("identityCard",id_card);
          map.put("accountNO",accountNO);
          map.put("checkStatus","DIFFERENT");
          map.put("result","验证失败,信息不匹配");
          map.put("success",true);
          result.setData(map);
          return result;
      }else{                                          //错误时返回数据结构
          result.setCode("30001001");
          result.setMsg("POLICE_IDENTITY_CHECK_ID_INVALID");
          result.setGetDataWay("others");
          map.put("code",30001001);
          map.put("errorDesc","身份证验证查询输入身份证不合法");
          map.put("success",false);
          map.put("error","POLICE_IDENTITY_CHECK_ID_INVALID");
          result.setData(map);
          return result;
      }
    }
}
