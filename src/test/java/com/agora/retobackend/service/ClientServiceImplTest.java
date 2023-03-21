package com.agora.retobackend.service;

import com.agora.retobackend.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClientServiceImplTest {
    private MockMvc mockMvc;
    @MockBean
    private ClientServiceImpl clientService;

    @Test
    void createClient() {
    }

    @Test
    void getClientByDNI() {
    }

    @Test
    void getClientByEmail() {
    }

    @Test
    void getClients() throws Exception {
        List<Client> clients = Arrays.asList(
                new Client(1,74032011, "Italo", "Figaro","italo@gmail.com", new Date(), new Date()),
                new Client(2,74032012, "Maria", "Maldini","ana@gmail.com", new Date(), new Date())
        );

        /*Mockito.when(clientService.getClients()).thenReturn(clients);
        mockMvc.perform(getClients("/getClients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nombre", is("Italo")))
                .andExpect(jsonPath("$[1].nombre", is("Maria")));*/
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClientByDNI() {
    }

    @Test
    void countClientsByDBirth_Month() {
    }

    @Test
    void moreClientesByYear() {
    }

    @Test
    void moreClientesByMonth() {
    }

    @Test
    void lessClientesByYear() {
    }

    @Test
    void lessClientesByMonth() {
    }

    @Test
    void birthrateByMonth() {
    }
}