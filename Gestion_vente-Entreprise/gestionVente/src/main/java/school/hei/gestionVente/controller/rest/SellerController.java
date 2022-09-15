package school.hei.gestionVente.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.gestionVente.controller.mapper.SellerMapper;
import school.hei.gestionVente.model.Seller;
import school.hei.gestionVente.model.User;
import school.hei.gestionVente.model.rest.ToSeller;
import school.hei.gestionVente.service.SecurityService;
import school.hei.gestionVente.service.SellerService;
import java.util.List;

@CrossOrigin("*")
@RestController
@Controller
@AllArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

  private final SellerService sellerService;
  private final SellerMapper sellerMapper;
  private final SecurityService securityService;

  @GetMapping
  public List<Seller> getAll(
          @RequestParam int page,
          @RequestParam int pagesize
  ){
    return sellerService.getAll(page , pagesize);
  }

  @GetMapping("/{id}")
  public Seller getById(
          @PathVariable Long id
  ){
    return sellerService.getById(id);
  }

  @PostMapping
  public List<Seller> saveAllSeller(
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody List<ToSeller> sellerList
  ){
    return sellerService.saveSeller(page, pagesize, sellerMapper.toDomainList(sellerList));
  }

  @PostMapping("/admin")
  public String addSellerAdmin(
          @RequestBody User sellerAdmin
  ){
    return securityService.signUp(sellerAdmin);
  }

  @PutMapping("/{id}")
  public List<Seller> updateSeller(
          @PathVariable Long id,
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody ToSeller seller
  ){
    return sellerService.updateSeller(id, page, pagesize, sellerMapper.toRestList(seller));
  }
  @DeleteMapping("/{id}")
  public String deleteById(
          @PathVariable Long id
  ){
    sellerService.deletById(id);
    return "delete successfully";
  }
}
