package com.bgtb01.bgtb;


import com.alibaba.fastjson2.JSON;
import com.bgtb01.bgtb.entity.Users;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class Ctest {
    @Autowired
    public RestHighLevelClient restHighLevelClient;
    //创建索引
//    @Test
//    public  void  testCreateIndex() throws IOException {
//        System.out.println(restHighLevelClient);
//        CreateIndexRequest testIndex = new CreateIndexRequest("test_index");
//        CreateIndexResponse response = restHighLevelClient.indices().create(testIndex, RequestOptions.DEFAULT);
//        System.out.println(response.isAcknowledged());
//        System.out.println(response);
//        restHighLevelClient.close();
//    }
    //删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test_index");
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());// 是否删除成功
        restHighLevelClient.close();
    }
    //判断索引是否存在
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("test_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
        restHighLevelClient.close();
    }
    //关闭连接
    @Test
    public void testClose() throws IOException {
        restHighLevelClient.close();
    }
    //测试连接
    @Test
    public void testConnect() {
        System.out.println(restHighLevelClient);
    }
    //添加文档
    @Test
    public void testAddDocument() throws IOException{
        //创建一个User对象
        Users users = new Users();
        users.setUserid(1);
        users.setUsername("张三");
        users.setPassword("123456");
        //创建请求
        IndexRequest request = new IndexRequest("test_index");
        //规则 put /test_index/_doc/1
        request.id("1");//设置id
        request.timeout(TimeValue.timeValueMillis(1000));//设置超时时间为1s
        //将数据放入请求 json
        request.source(JSON.toJSONString(users), XContentType.JSON);
        //客户端发送请求,获取响应结果
        IndexResponse response = restHighLevelClient.index(request,RequestOptions.DEFAULT);
        System.out.println(response.status());
        System.out.println(response);

    }
}
