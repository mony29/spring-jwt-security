package com.example.loginwithjwt.repository;

import com.example.loginwithjwt.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("""
            select r.role_name from user_role ur
             inner join roles r on r.id = ur.role_id
             where ur.user_id = #{user_id};
            """)
    List<String> getRoleByUserId(Integer user_id);

    @Select("""
            select * from users where email=#{email} or username=#{email}
            """)
    @Results(
            id = "userMapper",
            value = {
                    @Result(column = "username", property = "name"),
                    @Result(property = "roles",column = "id",
                            many = @Many(select = "getRoleByUserId"))
            }
    )
    UserInfo findByEmail(String email);
}
