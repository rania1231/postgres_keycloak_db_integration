package enit.rhamdi.connectionkeycloakmysql.services.customDataUser;

import enit.rhamdi.connectionkeycloakmysql.dto.UserCustomData;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;



@Service
@Transactional
public class CustomDataUserServiceImpl implements CustomDataUserService {

    private final String customDataServiceURL = "http://localhost:8082/custom-users";
    private final WebClient webClient;

    public CustomDataUserServiceImpl() {
        this.webClient = WebClient.builder().baseUrl(customDataServiceURL).build();
    }


    @Override
    public List<UserCustomData> getAllCustomData() {

        return webClient.get()
                .retrieve()
                .bodyToFlux(UserCustomData.class)
                .collectList()
                .block();
    }

    @Override
    public UserCustomData createCustomData(UserCustomData userCustomData) {

        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/create").build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userCustomData)
                .retrieve()
                .bodyToMono(UserCustomData.class)
                .block();

    }

    @Override
    public void deleteCustomData(String id) {
        webClient.delete()
                .uri(uriBuilder -> uriBuilder.path("/delete/{id}").build(id))
                .retrieve()
                .bodyToMono(UserCustomData.class)
                .block();

    }
}
