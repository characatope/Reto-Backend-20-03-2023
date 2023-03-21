package com.agora.retobackend.controller;

import com.agora.retobackend.entity.Client;
import com.agora.retobackend.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/h2/clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @PostMapping("/createClient")
    public Client createClient(@RequestBody Client client){return clientServiceImpl.createClient(client);}

    @GetMapping("/getClients")
    public List<Client> getClients(){return clientServiceImpl.getClients();}
    @GetMapping("/client/dni/{dni}")
    public Client getClientByDNI(@PathVariable int dni){return clientServiceImpl.getClientByDNI(dni);}
    @GetMapping("/client/email/{email}")
    public Client getClientByEmail(@PathVariable String email){return clientServiceImpl.getClientByEmail(email);}
    @GetMapping("/client/month/{month}")
    public int countClientsByDBirth_Month(@PathVariable int month){return clientServiceImpl.countClientsByDBirth_Month(month);}
    @GetMapping("/client/month/more")
    public int moreClientesByMonth(){return clientServiceImpl.moreClientesByMonth();}
    @GetMapping("/client/month/less")
    public int lessClientesByMonth(){return clientServiceImpl.lessClientesByMonth();}
    @GetMapping("/client/year/more")
    public int moreClientesByYear(){return clientServiceImpl.moreClientesByYear();}
    @GetMapping("/client/year/less")
    public int lessClientesByYear(){return clientServiceImpl.lessClientesByYear();}
    @GetMapping("/client/birthrateByMonth")
    public Map<String, Double> birthrateByMonth(){return clientServiceImpl.birthrateByMonth();}
}
