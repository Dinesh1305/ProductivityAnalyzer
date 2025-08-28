package com.demo.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class Code_MoniterController {

	@GetMapping("getDetails")
	public String details() {
		WebClient client = WebClient.create("https://leetcode.com");

		String query = """
				{
				  recentSubmissionList(username: "akesh_007") {
				    title

				    status

				  }
				}
				""";

		Mono<ResponseEntity<String>> result = client.post().uri("/graphql")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).bodyValue(Map.of("query", query))
				.retrieve().toEntity(String.class);

		ResponseEntity<String> response = result.block();
		return response.getBody();

	}
}
