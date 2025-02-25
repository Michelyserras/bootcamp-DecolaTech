package dio.java.rest_api.repository;

import dio.java.rest_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
