package com.cason.cos.entity.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 16:49
 */
@Data
public class Tree<T> {
    private Dir dir;
    private Integer  pId;
    private List<Tree<T>> children =new ArrayList<>();;
    public void add(Tree<T> node) {
        children.add(node);
    }
}