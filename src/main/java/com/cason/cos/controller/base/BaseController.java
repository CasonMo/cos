package com.cason.cos.controller.base;

import com.cason.cos.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 17:32
 */
public class BaseController<SERVICE extends BaseService> {
    @Autowired
    protected SERVICE service;
}
