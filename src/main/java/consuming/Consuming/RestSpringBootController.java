package consuming.Consuming;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class RestSpringBootController {
    @RequestMapping("/hello")
    public String hello(){
        return "Yellow worll";
    }
@GetMapping(value = "/callhello")
    private String getHelloClient(){
        String url = "https://api.chucknorris.io/jokes/random";
    RestTemplate restTemplate = new RestTemplate();
    String quotes = restTemplate.getForObject(url,String.class);
    return quotes;
}
@GetMapping(value = "/jerrysCrypto")
    private ResponseEntity<String> getJerrysProfits(){
        String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";
        String apiKey = "3fcb20d4-f3b9-43b8-8415-1f4bbf94c661";
        // 3fcb20d4-f3b9-43b8-8415-1f4bbf94c661
        RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    //headers.set("Accept", "application/json");
    headers.set("X-CMC_PRO_API_KEY","3fcb20d4-f3b9-43b8-8415-1f4bbf94c661");
       //String data = restTemplate.getForObject(url,String.class);
    HttpEntity request = new HttpEntity(headers);
    ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            request,
            String.class,
            1
    );

        return response;
}




}
