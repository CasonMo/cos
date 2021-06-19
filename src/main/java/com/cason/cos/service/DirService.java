package com.cason.cos.service;

import com.cason.cos.entity.bo.Dir;
import com.cason.cos.service.base.BaseService;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 22:36
 */
public interface DirService extends BaseService {
    void setCurrentDir(Integer id);
    Dir getCurrentDir();
}
