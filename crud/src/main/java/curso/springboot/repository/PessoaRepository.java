/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.springboot.repository;

import curso.springboot.model.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Willian
 */

@Repository // Aqui estou ativando e dizendo que é um repository
@Transactional // Transação com o BD, cuidando da parte de Persistencia
// CrudRepository<Classe da entidade, Tipo da chave primaria>
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
    
    @Query("select p from Pessoa p where p.nome like %?1%")
    List<Pessoa> findPessoaByName(String nome);
}
