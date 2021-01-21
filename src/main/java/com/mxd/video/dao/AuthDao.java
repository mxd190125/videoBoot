package com.mxd.video.dao;

import com.mxd.video.pojo.Admin;
import com.mxd.video.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface AuthDao {

    public int isExitUser(@Param("username") String username);

    public User getUser(@Param("username") String username , @Param("password") String password);

    public Admin getAdmin(@Param("username") String username , @Param("password") String password);

    public int registerUser(@Param("username") String username , @Param("password") String password , @Param("email") String email);
}
