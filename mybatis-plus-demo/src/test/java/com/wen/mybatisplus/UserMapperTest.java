package com.wen.mybatisplus;

import com.wen.mybatisplus.mapper.UserMapper;
import com.wen.mybatisplus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 21up on 2020/9/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect(){
        System.out.println("-------Select All method test------");
        List<User> userList = userMapper.selectList(null);
        for (User user:userList){
            System.out.println(user);
        }
    }
}
