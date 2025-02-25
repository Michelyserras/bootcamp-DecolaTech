package dio.java.rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dio.java.rest_api.service.ProdutoService;
import dio.java.rest_api.model.Produto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController //anotation para dizer que esse controller é proprio para apis
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired //injeção de dependencia
    private ProdutoService service;

   // @RequestMapping(method=RequestMethod.GET, value = "/save" ) maneira mais extensa

   @PostMapping("/save")  
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {
        produto = service.save(produto);

        return ResponseEntity.ok().body(produto);
    }


    @GetMapping("/getById")
    public ResponseEntity<Produto> buscarProduto(@RequestParam Long id){
        Produto produto = service.findById(id);
        
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Produto>> buscarProduto(){
        List<Produto> produtos = service.findAll();
        
        return ResponseEntity.ok().body(produtos);
    }



}
