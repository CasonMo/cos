package com.cason.cos.holder;

import com.cason.cos.entity.bo.Dir;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 17:24
 */
public class CurrentDirHolder {
    private static ThreadLocal<Dir> dirThreadLocal = new ThreadLocal<>();
    public static void setDir(Dir dir) {
        dirThreadLocal.set(dir);
    }

    public static Dir getDir() {
        if (null == dirThreadLocal || dirThreadLocal.get()==null) {
            CurrentDirHolder.setDir(new Dir(0,"/",0));
        }
        return dirThreadLocal.get();
    }

}
