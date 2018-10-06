package com.sf.zachweb.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sf.zachweb.services.DubboService;

@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboServiceImpl implements DubboService {
    public String test() {
        return "hello world！";
    }
}
