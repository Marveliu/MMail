package com.marveliu.domain;
/*
 * Copyright [2018] [Marveliu]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Marveliu
 * @since 05/04/2018
 **/

@Mapper
public interface EmailApplyMapper {

    @Select("SELECT * FROM email_apply WHERE appid = #{appid}")
    EmailApply findByName(@Param("appid") String appid);

    @Insert("INSERT INTO email_apply(appid, type) VALUES(#{appid}, #{type})")
    int insert(@Param("appid") String appid, @Param("type") Integer type);

    @Insert("INSERT INTO email_apply(appid, type) VALUES(#{appid,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO email_apply(appid, type) VALUES(#{appid}, #{type})")
    int insertByEmailApply(EmailApply apply);


    @Update("UPDATE email_apply SET type=#{type} WHERE appid=#{appid}")
    void update(EmailApply user);

    @Delete("DELETE FROM email_apply WHERE id =#{id}")
    void delete(Long id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT appid, type FROM email_apply")
    List<EmailApply> findAll();


}
