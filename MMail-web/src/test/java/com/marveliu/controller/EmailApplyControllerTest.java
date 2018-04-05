package com.marveliu.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class EmailApplyControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new EmailApplyController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(get("/EmailApply/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }


    @Test
    public void testEmailApplyController() throws Exception {
        // 测试EmailApplyController
        RequestBuilder request = null;

        // 1、get查一下EmailApply列表，应该为空
        request = get("/EmailApply/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2、post提交一个EmailApply
        request = post("/EmailApply/")
                .param("id", "1")
                .param("appid", "测试大师")
                .param("type", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取EmailApply列表，应该有刚才插入的数据
        request = get("/EmailApply/");
        mvc.perform(request)
                .andExpect(status().isOk());
                // .andExpect(content().string(equalTo("[{\"id\":1,\"appid\":\"测试大师\",\"type\":20}]")));

        // 4、put修改id为1的EmailApply
        request = put("/EmailApply/1")
                .param("appid", "测试终极大师")
                .param("type", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的EmailApply
        request = get("/EmailApply/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"appid\":\"测试终极大师\",\"type\":30}")));

        // 6、del删除id为1的EmailApply
        request = delete("/EmailApply/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下EmailApply列表，应该为空
        request = get("/EmailApply/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}