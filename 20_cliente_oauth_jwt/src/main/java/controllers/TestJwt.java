package controllers;

import java.io.IOException;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestJwt {
	@GetMapping(value="testJwt",produces=MediaType.TEXT_PLAIN_VALUE)
	public String recuperarMensaje() {
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		//agregamos credenciales a cabecera
		String credentials = "prueba:pruebapwd";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		headers.add("Authorization", "Basic " + encodedCredentials);
		
		//construimos objeto HttEntity y solicitamos el token al servidor		
		HttpEntity<String> request = new HttpEntity<String>(headers);		
		String access_token_url = "http://localhost:6000/oauth/token";
		access_token_url += "?grant_type=password";
		access_token_url += "&username=user";
		access_token_url += "&password=secret";//+new String(Base64.encodeBase64("secret".getBytes()));
		//access_token_url += "&redirect_uri=http://localhost:10000/test";
		//petición al servidor de autorización
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		String token=obtenerToken(response);
		System.out.println("--"+token);
		//enviamos la respuesta al recurso y devolvemos resultado
		String url = "http://localhost:5000/test";

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers1);

		ResponseEntity<String> data = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(data);
		return data.getBody();
	}
	
	
	private String obtenerToken(ResponseEntity<String> response) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;
		try {
			node = mapper.readTree(response.getBody());
			return node.path("access_token").asText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
