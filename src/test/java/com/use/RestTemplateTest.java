package com.use;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.use.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testUrl() {
        String  result = restTemplate.getForObject("http://localhost:8080/swagger-ui.html", String.class);
        System.out.println("result info ::"+ result);
    }

    @Test
    public void testAppTrailer_findById(){
        ResultVO resultVO = restTemplate.getForObject("http://localhost:8080/appTrailer/findById", ResultVO.class,1);
        log.info(gson.toJson(resultVO));
    }
}
