package com.cason.cos.repository;

import com.cason.cos.entity.bo.Dir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 19:42
 */
@Repository
public interface DirRepository extends JpaRepository<Dir,Integer>,JpaSpecificationExecutor<Integer> {

    Dir findByPidAndName(@Param("pid") Integer pid,@Param("name") String name);

    @Modifying
    @Query("update Dir m set m.currentFlag=0")
    void updateAllCurrentDirToFalse();
    @Modifying
    @Query("update Dir m set m.currentFlag=1 where id =:id")
    void setCurrentDir(@Param("id") Integer id);

    Dir findDirByCurrentFlag(Boolean currentFlag);
}
