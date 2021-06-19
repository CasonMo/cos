package com.cason.cos.service.impl;

import com.cason.cos.entity.bo.Dir;
import com.cason.cos.entity.bo.Tree;
import com.cason.cos.holder.CurrentDirHolder;
import com.cason.cos.repository.DirRepository;
import com.cason.cos.service.CommandService;
import com.cason.cos.service.base.BaseService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 17:28
 */
@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    DirRepository dirRepository;
    @Override
    public Dir cd(String path) throws Exception {
        Dir tempDir =null;
        Dir currentDir = CurrentDirHolder.getDir();
        if ("..".equals(path)) {
            Integer pId = currentDir.getPid();
            if(pId==1){
                return currentDir;
            }
            tempDir = dirRepository.findById(pId).get();

        }else {
            String[] splitPath = path.split("/");

            if (path.startsWith("/")) {
                tempDir = getDirInPath(splitPath, new Dir(0,"/",0), 1);
            }else {
                tempDir = getDirInPath(splitPath, currentDir, 0);
            }
            if(tempDir==null){
                throw new Exception("error : path not found");
            }

        }
        if(tempDir!=null){
            CurrentDirHolder.setDir(tempDir);
        }

        return tempDir;
    }

    @Override
    public Dir pwd() {
        return CurrentDirHolder.getDir();
    }
    private Dir getDirInPath(String[] dirName,Dir dir,int index)  {
        if(index>dirName.length-1){
            return dir;
        }
        Dir tmpDir = null;
        if ("..".equals(dirName[index])) {
            tmpDir = dirRepository.findById(dir.getPid()).get();
        }else {
            tmpDir = dirRepository.findByPidAndName(dir.getId(),dirName[index]);
        }
        if (tmpDir == null) {
            return null;
        }else {
            index++;
            return getDirInPath(dirName, tmpDir, index);
        }

    }
}
