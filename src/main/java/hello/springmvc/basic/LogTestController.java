package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Rest API
@Slf4j // 자동으로 해줌
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "String";

        System.out.println("name" + name); // 이건 쓰면 안됨

        // 필요한 정보만 남겨야함
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 개발 서버
        log.info("info log={}", name); // 운영 서버
        log.warn("warn log={}", name); // 경고
        log.info("error log={}", name); // 에러

        // 연산이 일어남
        // name + "Sring" 치환을 이루어 지기때문에 log를 보지 못함
        log.trace("trace my log=" + name);

        return "ok";
    }

}
