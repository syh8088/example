package com.example.api.RestTemplateTests;

import com.example.api.ExampleApplication;
import com.example.api.model.entities.member.Member;
import com.example.api.service.board.BoardService;
import com.example.api.service.member.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
@Slf4j
public class RestTemplateTests {
    Logger logger = Logger.getLogger(this.getClass());

    //@Value("${local.server.port}")
    int port = 8084;

    @Autowired
    MemberService memberService;

    private String baseUrl;

    RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:" +  String.valueOf(port);
    }

    private String jsonStringFromObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private String getUrlString(String path) {
        return "http://localhost:" + String.valueOf(port) + path;
    }

    @Test
    public void testIndex() throws Exception {

        URI uri = URI.create(baseUrl+ "/members/1/types/queryDSL");
//        String responseString = restTemplate.getForObject(uri, String.class);
        Member resultArticles =restTemplate.getForObject(uri, Member.class);

        // 컨트롤러 결과를 로깅
//        logger.info(responseString);

        // 컨트롤러 결과를 확인하기 위한 데이터 가져오기
          Member members = memberService.getMember(1, "queryDSL");
//        String jsonString = jsonStringFromObject(articles);

        // 컨트롤러의 결과와 JSON 문자열로 비교
//        assertThat(responseString, is(equalTo(jsonString)));
        assertThat(resultArticles.getEmail(), is(equalTo(members.getEmail())));
        assertThat(resultArticles.getId(), is(equalTo(members.getId())));
    }
}
