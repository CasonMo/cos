//package com.cason.cos.entity.bo;
//
//import javax.annotation.PostConstruct;
//
///**
// * Created by IntelliJ IDEA.
// * User: Cason mo
// * Date: 2021/6/19
// * Time: 17:47
// */
//public class MockDirTree {
//    public static Tree<Dir> dirTree = new Tree<Dir>();
//    @PostConstruct
//    private void mockDirTree(){
//
//        dirTree.setDir(new Dir(1,"/"));
//        dirTree.setPId(0);
//
//        Tree<Dir> dirTree1 = new Tree<Dir>();
//        dirTree1.setDir(new Dir(2,"home"));
//        dirTree1.setPId(1);
//        dirTree.add(dirTree1);
//
//        Tree<Dir> dirTree2 = new Tree<Dir>();
//        dirTree2.setDir(new Dir(3,"logs"));
//        dirTree2.setPId(1);
//        dirTree.add(dirTree2);
//
//        Tree<Dir> dirTree3 = new Tree<Dir>();
//        dirTree3.setDir(new Dir(4,"tmp"));
//        dirTree3.setPId(1);
//        dirTree.add(dirTree3);
//
//        Tree<Dir> dirTree4 = new Tree<Dir>();
//        dirTree4.setDir(new Dir(5,"cason"));
//        dirTree4.setPId(2);
//        dirTree1.add(dirTree4);
//
//        Tree<Dir> dirTree5 = new Tree<Dir>();
//        dirTree5.setDir(new Dir(6,"john"));
//        dirTree5.setPId(2);
//        dirTree1.add(dirTree5);
//
//        Tree<Dir> dirTree6 = new Tree<Dir>();
//        dirTree6.setDir(new Dir(7,"jenkinsLogs"));
//        dirTree6.setPId(3);
//        dirTree2.add(dirTree6);
//
//        Tree<Dir> dirTree7 = new Tree<Dir>();
//        dirTree6.setDir(new Dir(8,"tomcatLogs"));
//        dirTree6.setPId(3);
//        dirTree2.add(dirTree6);
//    }
//}
