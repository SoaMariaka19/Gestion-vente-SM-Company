package school.hei.gestionVente.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.Seller;
import school.hei.gestionVente.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
  private final ClientRepository clientRepository;
  public List<Client> getAll(int page , int pagesize){
    Pageable pageable = PageRequest.of(page, pagesize);
    return clientRepository.findAll(pageable).toList();
  }

  public Client getById(Long id){
     return clientRepository.getById(id) ;
  }

  public List<Client> saveClient(int page , int pagesize , Client clientList){

    clientRepository.save(clientList);
    Pageable pageable = PageRequest.of(page, pagesize);
    return clientRepository.findAll(pageable).toList();
  }
  public List<Client> getClient(Long id){
    List<Client> clients = new ArrayList<>();
    clients.add(clientRepository.findById(id).get());

    return clients;
  }
  public List<Client> updateClient(Long id , int page , int pagesize , Client clientList){
    Optional<Client> client = clientRepository.findById(id);
    if(client.isPresent()){
      client.get().setEmail(clientList.getEmail());
      client.get().setPhone(clientList.getPhone());
      client.get().setAddress(clientList.getAddress());
      clientRepository.save(client.get());
    }
    else {
      clientRepository.save(clientList);
    }
    Pageable pageable = PageRequest.of(page, pagesize);
    return clientRepository.findAll(pageable).toList();
  }

  public void deletById(Long id){
    clientRepository.deleteById(id);
  }
}
