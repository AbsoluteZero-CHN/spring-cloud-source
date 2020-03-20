package cn.nolad.producer.resources;

import cn.nolad.producer.model.WebResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 11:24
 */
@RestController
@RequestMapping("/api/producer")
public class ProducerResources {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/test")
    public WebResult getTest() {
        return WebResult.success(serverPort);
    }
}
