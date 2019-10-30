package com.company.NadineHernandezrandomquoteservice.controller;

import com.company.NadineHernandezrandomquoteservice.dto.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RefreshScope
public class RandomQuoteServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String quote(){
        Quote quote = new Quote();

        return quote.getRandomQuote();
    }

    @Value("${magicEightBallName}")
    private String magicEightBallName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @RequestMapping(value = "/answerme", method = RequestMethod.GET)
    public String getAnswer(){
        List<ServiceInstance> instances = discoveryClient.getInstances(magicEightBallName);

        String magicEightBallServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String answer = restTemplate.getForObject(magicEightBallServiceUri, String.class);

        return answer;
    }
}
