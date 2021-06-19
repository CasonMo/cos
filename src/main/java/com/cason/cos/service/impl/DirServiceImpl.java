package com.cason.cos.service.impl;

import com.cason.cos.entity.bo.Dir;
import com.cason.cos.repository.DirRepository;
import com.cason.cos.service.DirService;
import com.cason.cos.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 22:37
 */
@Service
public class DirServiceImpl extends BaseServiceImpl<DirRepository> implements DirService {
    @Transactional
    @Override
    public void setCurrentDir(Integer id) {
        this.repository.updateAllCurrentDirToFalse();
        this.repository.setCurrentDir(id);
    }

    @Override
    public Dir getCurrentDir() {
        Dir dirByCurrentFlag = this.repository.findDirByCurrentFlag(true);
        if(dirByCurrentFlag==null){
            dirByCurrentFlag = new Dir(0, "/", -1);
        }
        return dirByCurrentFlag;
    }
}
