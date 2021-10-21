package com.sportstelling.sportsgame.bo;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SportsBO {
	public String getSportsGame() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		//pageNo=1&numOfRows=5&matchDt=20211020&sports=%EC%95%BC%EA%B5%AC
//		URI uri = UriComponentsBuilder.fromHttpUrl("http://www.kspo.or.kr/openapi/service/sportsMatchInfoService/getList")
//				.queryParam("serviceKey", "WasFiiRrbU7tV5CZN6GVHmtlGQ5w70jfHSyJP%2FHDfVYjqEkXf7R2l6et%2B5vFQobIJgk5Vp2Ras6wRdOqiFxUlw%3D%3D")
//				.queryParam("pageNo", "1")
//				.queryParam("numOfRows", "5")
//				.queryParam("matchDt", "20211020")
//				.queryParam("sports", "야구")
//				.build(false)
//				.toUri();
		URI uri = new URI("http://www.kspo.or.kr/openapi/service/sportsMatchInfoService/getList?serviceKey=WasFiiRrbU7tV5CZN6GVHmtlGQ5w70jfHSyJP%2FHDfVYjqEkXf7R2l6et%2B5vFQobIJgk5Vp2Ras6wRdOqiFxUlw%3D%3D&pageNo=1&numOfRows=5&matchDt=20210630&aTeam=%EB%A1%AF%EB%8D%B0%EC%9E%90%EC%9D%B4%EC%96%B8%EC%B8%A0&hTeam=%ED%82%A4%EC%9B%80%ED%9E%88%EC%96%B4%EB%A1%9C%EC%A6%88&sports=%EC%95%BC%EA%B5%AC");
		String response = restTemplate.getForObject(uri , String.class);
		
		return response;
	}
}
