package school.hei.gestionVente.controller.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.Supply;
import school.hei.gestionVente.model.rest.ToClient;
import school.hei.gestionVente.service.SupplyService;

import java.util.List;

@Component
@AllArgsConstructor
public class ClientMapper {
  private final SupplyService supplyService;
  public Client toRestList(ToClient list){
    List<Supply> supplyList = supplyService.getSupply(list.getId_supply());
    return
            Client.builder()
                    .phone(list.getPhone())
                    .address(list.getAddress())
                    .email(list.getEmail())
                    .supplies(supplyList)
                    .build();
  }
  public List<Client> toDomainList(
          List<ToClient> contestList
  ){
    return contestList.stream().map(this::toRestList).toList();
  }
}
