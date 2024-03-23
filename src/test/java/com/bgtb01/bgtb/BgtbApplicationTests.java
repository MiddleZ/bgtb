package com.bgtb01.bgtb;

import com.bgtb01.bgtb.entity.Users;
import com.bgtb01.bgtb.mapper.ProvincesMapper;
import com.bgtb01.bgtb.mapper.UsersMapper;
import com.bgtb01.bgtb.entity.Provinces;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BgtbApplicationTests {

    @Autowired
    private ProvincesMapper provincesMapper;
    @Resource
    private UsersMapper usersMapper;
//    void contextLoads() {
//        List<Forumtitles> forumtitles = forumtitlesMapper.selectList(null);
//        forumtitles.forEach(System.out::println);
//    }
    @Test
    void test0(){
        List<Users> list = usersMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test1(){
        Provinces provinces = new Provinces();

        //provinces.setProvinceID(5);
        provinces.setProvinceName("测试省4");

        int result = provincesMapper.insert(provinces);
        System.out.println(result);
    }
    @Test
    public void test2(){
        Provinces provinces = new Provinces();
        provinces.setProvinceID(4);
        provinces.setProvinceName("广东省");
        int i = provincesMapper.updateById(provinces);
        System.out.println(i);
    }
//    @Test
//    public void testPage(){
//        Page<Forumtitles> page = new Page<>(1,2);
//        forumtitlesMapper.selectPage(page,null);
//        page.getRecords().forEach(System.out::println);
//    }
    @Test
    public void logintest3(){

        String password= usersMapper.getPassword("admin");
        if(password.equals("admin")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }



    }



}












