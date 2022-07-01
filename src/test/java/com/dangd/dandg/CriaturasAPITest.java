/*
package com.dangd.dandg;

import com.dangd.dandg.domain.classes.Criatura;
import com.dangd.dandg.domain.dto.CriaturaDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DandgApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CriaturasAPITest {
    @Autowired
    protected TestRestTemplate rest;

    private ResponseEntity<CriaturaDTO> getCriatura(String url) {
        return rest.withBasicAuth("user", "user").getForEntity(url, CriaturaDTO.class);
    }

    private ResponseEntity<List<CriaturaDTO>> getCriaturas(String url) {
        return rest.withBasicAuth("user", "user").exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CriaturaDTO>>(){
                });
    }

    @Test
    public void testLista() {
        List<CriaturaDTO> criaturas = getCriaturas("/api/v1/criaturas").getBody();
        assertNotNull(criaturas);
        assertEquals(5, criaturas.size());
    }

    @Test
    public void testListaPorTipo() {
        assertEquals(3, getCriaturas("/api/v1/criaturas/tipo/humanoide").getBody().size());
        assertEquals(1, getCriaturas("/api/v1/criaturas/tipo/monstro").getBody().size());
        assertEquals(1, getCriaturas("/api/v1/criaturas/tipo/besta").getBody().size());
        assertEquals(HttpStatus.NO_CONTENT, getCriaturas("/api/v1/criaturas/tipo/anemona").getStatusCode());
    }

    @Test
    public void testGetJessie() {
        ResponseEntity<CriaturaDTO> response = getCriatura("/api/v1/criaturas/2");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Jessie", response.getBody().getNomeCriatura());
    }

    @Test
    public void testGetNotFound() {
        ResponseEntity<CriaturaDTO> response = getCriatura("/api/v1/criaturas/22");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testSaveDelete() {
        Criatura criatura = new Criatura(null, "Maykon", "gigante");

        ResponseEntity response = rest.withBasicAuth("dungeonmaster", "dungeonmaster").postForEntity("/api/v1/criaturas", criatura, null);
        System.out.println(response);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        String location = response.getHeaders().get("location").get(0);

        assertEquals("Maykon", getCriatura(location).getBody().getNomeCriatura());
        assertEquals("gigante", getCriatura(location).getBody().getTipoCriatura());

        rest.withBasicAuth("dungeonmaster", "dungeonmaster").delete(location);
        assertEquals(HttpStatus.NOT_FOUND, getCriatura(location).getStatusCode());
    }
}
*/