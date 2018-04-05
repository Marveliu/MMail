package com.marveliu;

import com.marveliu.domain.EmailApply;
import com.marveliu.domain.EmailApplyMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTest {

    @Autowired
    private EmailApplyMapper emailApplyMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, EmailApply> redisTemplate;

    @Test
    @Rollback
    public void findByName() throws Exception {
        emailApplyMapper.insert("AAA", 20);
        EmailApply u = emailApplyMapper.findByName("AAA");
        Assert.assertEquals(20, u.getType().intValue());
    }

    @Test
    @Rollback
    @Transactional
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        emailApplyMapper.insert("AAA", 20);
        EmailApply u = emailApplyMapper.findByName("AAA");
        Assert.assertEquals(20, u.getType().intValue());
        // update一条数据，并select出来验证
        u.setType(30);
        emailApplyMapper.update(u);
        u = emailApplyMapper.findByName("AAA");
        Assert.assertEquals(30, u.getType().intValue());
        // 删除这条数据，并select验证
        emailApplyMapper.delete(u.getId());
        u = emailApplyMapper.findByName("AAA");
        Assert.assertEquals(null, u);
    }


    @Test
    @Rollback
    public void testFindAll() throws Exception {
        List<EmailApply> applies = emailApplyMapper.findAll();
        for (EmailApply apply : applies) {
            Assert.assertEquals(null, apply.getId());
            Assert.assertNotEquals(null, apply.getAppid());
        }
    }


    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testReisTemplate() throws Exception {

        // 保存对象
        EmailApply apply = new EmailApply("超人", 20);
        redisTemplate.opsForValue().set(apply.getAppid(), apply);

        apply = new EmailApply("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(apply.getAppid(), apply);

        apply = new EmailApply("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(apply.getAppid(), apply);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getType().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getType().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getType().longValue());

    }
}