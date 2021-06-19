package com.cason.cos.service;

import com.cason.cos.entity.bo.Dir;
import com.cason.cos.service.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 17:26
 */
public interface CommandService extends BaseService {
    Dir cd(String path) throws Exception;
    Dir pwd();
}
