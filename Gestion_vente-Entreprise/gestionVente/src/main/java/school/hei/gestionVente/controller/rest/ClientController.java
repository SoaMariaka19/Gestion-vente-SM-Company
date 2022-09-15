package school.hei.gestionVente.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import school.hei.gestionVente.controller.mapper.ClientMapper;
import school.hei.gestionVente.model.Client;
import school.hei.gestionVente.model.rest.ToClient;
import school.hei.gestionVente.service.ClientService;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;
  private final ClientMapper clientMapper;
  @GetMapping
  public List<Client> getAll(
          @RequestParam int page,
          @RequestParam int pagesize
  ){
    return  clientService.getAll(page , pagesize);
  }

  @GetMapping("/{id}")
  public Client getById(
          @PathVariable Long id
  ){
    return clientService.getById(id);
  }

  @PostMapping
  public List<Client> saveAllSeller(
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody ToClient sellerList
  ){
      return clientService.saveClient(page, pagesize, clientMapper.toRestList(sellerList));
  }

  @PutMapping("/{id}")
  public List<Client> updateSeller(
          @PathVariable Long id,
          @RequestParam int page,
          @RequestParam int pagesize,
          @RequestBody ToClient seller
  ){
    return clientService.updateClient(id, page, pagesize, clientMapper.toRestList(seller));
  }

  @DeleteMapping("/{id}")
  public String deleteById(
          @PathVariable Long id
  ){
    clientService.deletById(id);
    return "delete successfully";
  }
}
