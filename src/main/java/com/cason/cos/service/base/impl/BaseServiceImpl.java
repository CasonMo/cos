package com.cason.cos.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 22:35
 */
public class BaseServiceImpl<REPOSITORY extends JpaRepository> {
    @Autowired
    protected REPOSITORY repository;
}
