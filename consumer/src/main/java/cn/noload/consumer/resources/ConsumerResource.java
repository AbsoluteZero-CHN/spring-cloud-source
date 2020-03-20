package cn.noload.consumer.resources;

import cn.noload.consumer.model.WebResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-03-17 11:38
 */

@RestController
@RequestMapping("/api/consumer")
public class ConsumerResource {

    private final RestTemplate restTemplate;

    public ConsumerResource(
            @Qualifier("loadBalanced") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public WebResult getTest() {
        ResponseEntity<WebResult> responseEntity = restTemplate.getForEntity("http://SOURCE-PRODUCER-1/api/producer/test", WebResult.class);
        restTemplate.getForEntity("http://SOURCE-PRODUCER-2/api/producer/test", WebResult.class);
        return WebResult.success(responseEntity.getBody().getResult());
    }
}
