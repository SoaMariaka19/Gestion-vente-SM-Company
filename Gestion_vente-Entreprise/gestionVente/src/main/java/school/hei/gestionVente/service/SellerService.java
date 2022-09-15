package school.hei.gestionVente.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.Seller;
import school.hei.gestionVente.repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerService {
  private final SellerRepository sellerRepository;

  public List<Seller> getAll(int page , int pagesize){
    Pageable pageable = PageRequest.of(page, pagesize);
    return sellerRepository.findAll(pageable).toList();
  }
  public List<Seller> getSeller(Long id){
    List<Seller> sellers = new ArrayList<>();
    sellers.add(sellerRepository.findById(id).get());

    return sellers;
  }
  public Seller getById(Long id){
    return sellerRepository.getById(id) ;
  }

  public List<Seller> saveSeller(int page , int pagesize , List<Seller> clientList){
    sellerRepository.saveAll(clientList);
    Pageable pageable = PageRequest.of(page, pagesize);
    return sellerRepository.findAll(pageable).toList();
  }

  public List<Seller> updateSeller(Long id , int page , int pagesize , Seller sellerList){
    Optional<Seller> seller = sellerRepository.findById(id);
    if(seller.isPresent()){
      seller.get().setFirstName(sellerList.getFirstName());
      seller.get().setMail(sellerList.getMail());
      seller.get().setLastName(sellerList.getLastName());
      sellerRepository.save(seller.get());
    }
    else {
      sellerRepository.save(sellerList);
    }
    Pageable pageable = PageRequest.of(page, pagesize);
    return sellerRepository.findAll(pageable).toList();
  }
  public void deletById(Long id){
    sellerRepository.deleteById(id);
  }
}
