package com.cason.cos.controller;

import com.cason.cos.controller.base.BaseController;
import com.cason.cos.entity.bo.Dir;
import com.cason.cos.entity.vo.Resp;
import com.cason.cos.repository.DirRepository;
import com.cason.cos.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 14:34
 */
@RestController
public class CommandController extends BaseController<CommandService> {
    @Autowired
    DirRepository dirRepository;
    @GetMapping("cd")
    public Resp cd(HttpSession session, @RequestParam("path") String path)  {

        Dir dir = null;
        try {
            dir = this.service.cd(path);
        } catch (Exception e) {
            return Resp.fail(e.getMessage());
        }
//        session.setAttribute("currentDirId",dir.getId());

        return Resp.success();
    }
    @GetMapping("pwd")
    public Resp pwd(HttpSession session){
//        Integer currentDirId =  (Integer) session.getAttribute("currentDirId");
//        Dir dir = this.service.pwd(currentDirId);
        Dir dir = this.service.pwd();
        return Resp.success(getAbsolutePath(dir.getName(),dir));
    }

    private String getAbsolutePath(String path,Dir dir){
        if(dir==null){
            return path;
        }
        if(dir.getPid()==-1 ){
            return "/";
        }
        if(dir.getPid()==0 ){
            return "/"+path;
        }
        Dir tmpDir = dirRepository.findById(dir.getPid()).get();
        if(tmpDir!=null){
            if ("/".equals(tmpDir.getName())) {
                path=tmpDir.getName()+path;
            }else {
                path=tmpDir.getName()+"/"+path;
            }

        }
        return getAbsolutePath(path,tmpDir);

    }
}
