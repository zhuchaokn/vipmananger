package com.stonegate.vip.controller;

import com.stonegate.vip.bean.VipInfo;
import com.stonegate.vip.context.AccountContext;
import com.stonegate.vip.service.VipInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu created on 15/8/24 下午11:48
 * @version 1.0
 */
@Controller
@RequestMapping("/vip/vipInfo")
public class VipInfoController {
    @Resource
    private VipInfoService vipInfoService;

    @RequestMapping("/list")
    public List<VipInfo> vipInfoList(@RequestParam int page, @RequestParam int size) {
        return vipInfoService.getVipInfoList(AccountContext.currentAccount().getUserName(), page, size);
    }

}
