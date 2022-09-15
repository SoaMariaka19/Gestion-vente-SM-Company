package school.hei.gestionVente.controller.mapper;

import lombok.AllArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;
 import school.hei.gestionVente.model.Supply;
import school.hei.gestionVente.model.rest.ToSupply;
import school.hei.gestionVente.service.ClientService;
import school.hei.gestionVente.service.SellerService;
import java.util.List;

@Component
@AllArgsConstructor
public class SupplyMapper {
  public Supply toRestList(ToSupply list){
    return
            Supply.builder()
                    .price(list.getPrice())
                    .name(list.getName())
                    .dateOfselling(list.getDateOfselling())
                    .availability(true)
                    .quantity(list.getQuantity() - 1)
                    .build();
  }
  public List<Supply> toDomainList(
          List<ToSupply> contestList
  ){
    return contestList.stream().map(this::toRestList).toList();
  }
}
