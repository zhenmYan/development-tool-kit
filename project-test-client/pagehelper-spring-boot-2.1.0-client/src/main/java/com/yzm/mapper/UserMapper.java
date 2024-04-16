package com.yzm.mapper;

import com.yzm.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/16  18:49
 */
@Mapper
public interface UserMapper {

    User selectById(@Param("id")int id);

    List<User> selectAll();

}
