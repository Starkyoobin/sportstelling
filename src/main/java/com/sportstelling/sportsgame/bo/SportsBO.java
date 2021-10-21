package com.sportstelling.sportsgame.bo;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SportsBO {
	public String getSportsGame() {
		RestTemplate restTemplate = new RestTemplate();
		//pageNo=1&numOfRows=5&matchDt=20211020&sports=%EC%95%BC%EA%B5%AC
		URI uri = UriComponentsBuilder.fromHttpUrl("http://www.kspo.or.kr/openapi/service/sportsMatchInfoService/getList")
				.queryParam("serviceKey", "WasFiiRrbU7tV5CZN6GVHmtlGQ5w70jfHSyJP/HDfVYjqEkXf7R2l6et+5vFQobIJgk5Vp2Ras6wRdOqiFxUlw==")
				.queryParam("pageNo", "1")
				.queryParam("numOfRows", "5")
				.queryParam("matchDt", "20211020")
				.queryParam("sports", "야구")
				.build()
				.toUri();
		String response = restTemplate.getForObject("http://www.kspo.or.kr/openapi/service/sportsMatchInfoService/getList?serviceKey=WasFiiRrbU7tV5CZN6GVHmtlGQ5w70jfHSyJP/HDfVYjqEkXf7R2l6et+5vFQobIJgk5Vp2Ras6wRdOqiFxUlw==&pageNo=1&numOfRows=5&matchDt=20210630&aTeam=롯데자이언츠&hTeam=키움히어로즈&sports=야구", String.class);
		
		return response;
	}
}
