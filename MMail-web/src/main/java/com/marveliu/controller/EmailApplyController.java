package com.marveliu.controller;
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

import com.marveliu.domain.EmailApply;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Marveliu
 * @since 05/04/2018
 **/


@RestController
@RequestMapping(value="/EmailApply")
public class EmailApplyController {

    // 创建线程安全的Map
    static Map<Long, EmailApply> applies = Collections.synchronizedMap(new HashMap<Long, EmailApply>());


    @ApiOperation(value="获取用户列表", notes="")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<EmailApply> getEmailApplyList() {
        // 处理"/EmailApplys/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<EmailApply> r = new ArrayList<EmailApply>(applies.values());
        return r;
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postEmailApply(@ModelAttribute EmailApply EmailApply) {
        // 处理"/EmailApplys/"的POST请求，用来创建EmailApply
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        applies.put(EmailApply.getId(), EmailApply);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public EmailApply getEmailApply(@PathVariable Long id) {
        // 处理"/EmailApplys/{id}"的GET请求，用来获取url中id值的EmailApply信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return applies.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putEmailApply(@PathVariable Long id, @ModelAttribute EmailApply EmailApply) {
        // 处理"/EmailApplys/{id}"的PUT请求，用来更新EmailApply信息
        EmailApply u = applies.get(id);
        u.setAppid(EmailApply.getAppid());
        u.setTo(EmailApply.getTo());
        applies.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteEmailApply(@PathVariable Long id) {
        // 处理"/EmailApplys/{id}"的DELETE请求，用来删除EmailApply
        applies.remove(id);
        return "success";
    }

}
