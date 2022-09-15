package school.hei.gestionVente.controller.mapper;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.Seller;
import school.hei.gestionVente.model.Supply;
import school.hei.gestionVente.model.rest.ToClient;
import school.hei.gestionVente.model.rest.ToSeller;
import school.hei.gestionVente.service.ClientService;
import school.hei.gestionVente.service.SellerService;
import school.hei.gestionVente.service.SupplyService;
import java.util.List;

@Component
@AllArgsConstructor
public class SellerMapper {
  private final SupplyService supplyService;
  public Seller toRestList(ToSeller list){
    List<Supply> supplyList = supplyService.getSupply(list.getId_supply());
    return
            Seller.builder()
                    .mail(list.getEmail())
                    .firstName(list.getFirstName())
                    .lastName(list.getLastName())
                    .supplies(supplyList)
                    .build();
  }
  public List<Seller> toDomainList(
          List<ToSeller> contestList
  ){
    return contestList.stream().map(this::toRestList).toList();
  }
}
