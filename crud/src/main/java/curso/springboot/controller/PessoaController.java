package curso.springboot.controller;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.PessoaRepository;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Willian
 */
@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository; // Injetando a interface

    @RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("/cadastro/cadastropessoa");
        modelAndView.addObject("pessoaobj", new Pessoa());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
    public ModelAndView salvar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        ModelAndView modelAndView = new ModelAndView("/cadastro/cadastropessoa");
        modelAndView.addObject("pessoaobj", new Pessoa());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView pessoas() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
        modelAndView.addObject("pessoas", pessoasIt);
        modelAndView.addObject("pessoaobj", new Pessoa());
        return modelAndView;
    }

    @GetMapping("/editarpessoa/{idpessoa}")
    public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
        ModelAndView modelAndView = new ModelAndView("/cadastro/cadastropessoa");
        modelAndView.addObject("pessoaobj", pessoa.get());
        return modelAndView;
    }

    @GetMapping("/removerpessoa/{idpessoa}")
    public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa, HttpServletResponse h) {
        pessoaRepository.deleteById(idpessoa);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pessoas", pessoaRepository.findAll());
        modelAndView.addObject("pessoaobj", new Pessoa());
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView pesquisar(@RequestParam("pesquisarnome") String pesquisarnome) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pessoas", pessoaRepository.findPessoaByName(pesquisarnome));
        modelAndView.addObject("pessoaobj", new Pessoa());
        return modelAndView;
    }

}
