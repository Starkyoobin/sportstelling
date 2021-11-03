package com.sportstelling.sportsgame.bo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SportsBO {
	public List<Object> getSportsGame() throws URISyntaxException {
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
		URI uri = new URI("http://www.kspo.or.kr/openapi/service/sportsMatchInfoService/getList?serviceKey=WasFiiRrbU7tV5CZN6GVHmtlGQ5w70jfHSyJP%2FHDfVYjqEkXf7R2l6et%2B5vFQobIJgk5Vp2Ras6wRdOqiFxUlw%3D%3D&pageNo=1&numOfRows=20&matchDt=20211102");
		Map<String, Object> responseData = restTemplate.getForObject(uri , Map.class);
		
		Map<String, Object> response = (Map)responseData.get("response");
		Map<String, Object> body = (Map)response.get("body");
		Map<String, Object> items = (Map)body.get("items");
		List<Object> sports = (List)items.get("item");
		
		return sports;
	}
}
