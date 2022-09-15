package school.hei.gestionVente.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.Supply;
import school.hei.gestionVente.repository.SupplyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplyService {
  private final SupplyRepository supplyRepository;

  public List<Supply> getAll(int page , int pagesize){
    Pageable pageable = PageRequest.of(page, pagesize);
    return supplyRepository.findAll(pageable).toList();
  }

  public List<Supply> getSupply(Long id) {
    List<Supply> category = new ArrayList<>();
    category.add(supplyRepository.findById(id).get());
    return category;
  }
  public Supply getById(Long id){
    return supplyRepository.getById(id) ;
  }

  public List<Supply> saveSupply(int page , int pagesize , List<Supply> clientList){
    supplyRepository.saveAll(clientList);
    Pageable pageable = PageRequest.of(page, pagesize);
    return supplyRepository.findAll(pageable).toList();
  }
  public List<Supply> updateSupply(Long id , int page , int pagesize , Supply supplyList) throws Exception {
    Optional<Supply> supply = supplyRepository.findById(id);
    if(supply.isPresent()){
      if(supplyList.getQuantity() > 0.0){
        supply.get().setId(supplyList.getId());
        supply.get().setName(supplyList.getName());
        supply.get().setDateOfselling(supplyList.getDateOfselling());
        supply.get().setPrice(supplyList.getPrice());
        supply.get().setQuantity(supplyList.getQuantity() - 1);
        supplyRepository.save(supply.get());
      }
      else{
        supplyList.setAvailability(false);
        throw new Exception();
      }
    }
    else {
      supplyRepository.save(supplyList);
    }
    Pageable pageable = PageRequest.of(page, pagesize);
    return supplyRepository.findAll(pageable).toList();
  }

  public void deletById(Long id){
    supplyRepository.deleteById(id);
  }
}
