package dio.java.rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.java.rest_api.exceptions.ProductNullException;
import dio.java.rest_api.exceptions.ProductPriceException;
import dio.java.rest_api.model.Produto;
import dio.java.rest_api.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception{
        if(produto.getNome() == null || produto.getPreco() == null){
            throw new ProductNullException();
        }
        if(produto.getPreco() < 0){
            throw new ProductPriceException();
        }
        return repository.save(produto);
    }

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

}
