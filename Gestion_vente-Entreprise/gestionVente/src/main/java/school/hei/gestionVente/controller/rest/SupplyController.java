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
import school.hei.gestionVente.controller.mapper.SupplyMapper;
import school.hei.gestionVente.model.Supply;
import school.hei.gestionVente.model.rest.ToSupply;
import school.hei.gestionVente.service.SupplyService;

import java.util.List;

@CrossOrigin("*")
@RestController
@Controller
@AllArgsConstructor
@RequestMapping("/supplies")
public class SupplyController {

  private final SupplyService supplyService;
  private final SupplyMapper supplyMapper;
  @GetMapping
  public List<Supply> getAll(
          @RequestParam int page,
          @RequestParam int pagesize
  ){
    return supplyService.getAll(page , pagesize);
  }

  @GetMapping("/{id}")
  public List<Supply> getById(
          @PathVariable Long id
  ){
    return supplyService.getSupply(id);
  }
  @PostMapping
  public List<Supply> saveAllSeller(
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody List<Supply> supplyList
  ){
    return supplyService.saveSupply(page, pagesize,supplyList);
  }

  @PutMapping("/{id}")
  public List<Supply> updateSeller(
          @PathVariable Long id,
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody ToSupply supply
  ) throws Exception {
    return supplyService.updateSupply(id, page, pagesize, supplyMapper.toRestList(supply));
  }

  @DeleteMapping("/{id}")
  public String deleteById(
          @PathVariable Long id
  ){
    supplyService.deletById(id);
    return "delete successfully";
  }
}
