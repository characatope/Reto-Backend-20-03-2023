package com.agora.retobackend.service;

import com.agora.retobackend.entity.Client;
import com.agora.retobackend.repository.ClientRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl {
    @Autowired
    private ClientRespository clientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    public Client createClient(Client client) {
        if(client!=null){
            client.setDCreate(new Date());
        }
        return clientRepository.save(client);
    }

    public Client getClientByDNI(int dni) {
        return clientRepository.findClientByDni(dni);
    }

    public Client getClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Client client) {
        LOGGER.info("Starting ClientService.updateClient");
        Client oldClient = getClientByDNI(client.getDni());
        if (oldClient!=null){
            oldClient.setName(client.getName());
            oldClient.setLastName(client.getLastName());
            oldClient.setEmail(client.getEmail());
            oldClient.setDBirth(client.getDBirth());
            oldClient.setDCreate(client.getDCreate());
            clientRepository.save(oldClient);
        }
        LOGGER.info("End ClientService.updateClient");
        return oldClient;
    }
    public boolean deleteClientByDNI(int dni){
        try{
            clientRepository.deleteById(dni);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public int countClientsByDBirth_Month(int month){
        return clientRepository.countClientsByDBirth_Month(month);
    }

    public int moreClientesByYear(){
        List<Object[]> data = clientRepository.moreClientesByYear();

        Integer year = 0;
        Integer count = 0;

        for (Object[] resultado : data) {
            Integer yearTemp = (Integer) resultado[0];
            Long cbirth = (Long) resultado[1];
            if (cbirth > count) {
                count = cbirth.intValue();
                year = yearTemp;
            }
        }

        return year;
    }
    public int moreClientesByMonth(){
        List<Object[]> data = clientRepository.moreClientesByMonth();

        Integer month = 0;
        Integer count = 0;

        for (Object[] resultado : data) {
            Integer yearTemp = (Integer) resultado[0];
            Long cbirth = (Long) resultado[1];
            if (cbirth > count) {
                count = cbirth.intValue();
                month = yearTemp;
            }
        }

        return month;
    }
    public int lessClientesByYear(){
        List<Object[]> data = clientRepository.lessClientesByYear();

        Integer year = 0;
        Integer count = 1000;

        for (Object[] resultado : data) {
            Integer yearTemp = (Integer) resultado[0];
            Long cbirth = (Long) resultado[1];
            if (cbirth < count) {
                count = cbirth.intValue();
                year = yearTemp;
            }
        }

        return year;
    }
    public int lessClientesByMonth(){
        List<Object[]> data = clientRepository.lessClientesByMonth();

        Integer month = 0;
        Integer count = 1000;

        for (Object[] resultado : data) {
            Integer yearTemp = (Integer) resultado[0];
            Long cbirth = (Long) resultado[1];
            if (cbirth < count) {
                count = cbirth.intValue();
                month = yearTemp;
            }
        }

        return month;
    }

    public Map<String, Double> birthrateByMonth(){
        List<Object[]> data = clientRepository.birthrateByMonth();

        Long total = clientRepository.count();

        Map<String, Double> birthrateByMonth = new HashMap<>();

        for (Object[] result : data) {
            Integer month = (Integer) result[0];
            Long cbirth = (Long) result[1];

            double birthrate = (double) cbirth / total * 1000.0;

            birthrateByMonth.put(Month.of(month).toString(), birthrate);
        }

        return birthrateByMonth;
    }
}
