package com.github.kozlm.theatre.service;

import com.github.kozlm.theatre.model.client.Address;
import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.repository.AddressRepository;
import com.github.kozlm.theatre.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public ClientService(
            ClientRepository clientRepository,
            AddressRepository addressRepository,
            PasswordEncoder encoder
    ){
        this.encoder = encoder;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Did not find client with id: " + id));
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void removeClientById(Long id){
        clientRepository.deleteById(id);
    }

    public void addClient(ClientDto dto){
        Address address = null;
        if (dto.getStreet()!=null){
            address = Address.builder()
                    .city(dto.getCity())
                    .street(dto.getStreet())
                    .buildingNumber(dto.getBuildingNumber())
                    .roomNumber(dto.getRoomNumber())
                    .postalCode(dto.getPostalCode())
                    .build();
            addressRepository.save(address);
        }
        Client client = Client.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .password(encoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .dateOfBirth(dto.getDateOfBirth())
                .address(address)
                .build();
        clientRepository.save(client);
    }

    @Transactional
    public void updateClient(Long id, ClientDto dto){
        Client client = getClientById(id);

        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setEmail(dto.getEmail());
        client.setGender(dto.getGender());
        client.setPassword(encoder.encode(dto.getPassword()));
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setDateOfBirth(dto.getDateOfBirth());

        if (dto.getStreet() != null) {
            Address address = client.getAddress();
            if (address == null) {
                address = Address.builder()
                        .city(dto.getCity())
                        .street(dto.getStreet())
                        .buildingNumber(dto.getBuildingNumber())
                        .roomNumber(dto.getRoomNumber())
                        .postalCode(dto.getPostalCode())
                        .build();
            } else {
                address.setCity(dto.getCity());
                address.setStreet(dto.getStreet());
                address.setBuildingNumber(dto.getBuildingNumber());
                address.setRoomNumber(dto.getRoomNumber());
                address.setPostalCode(dto.getPostalCode());
            }
            addressRepository.save(address);
            client.setAddress(address);
        }

        clientRepository.save(client);
    }
}
