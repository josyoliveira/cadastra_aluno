package br.com.joseane.cadastraaluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controler {

    @Autowired
    private AlunoRepositorio ar;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/formulario", method = RequestMethod.GET)
    public ModelAndView form(){
        return new ModelAndView("formulario");
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView cadastro(Aluno a){

        ModelAndView retorno = new ModelAndView("resultado.html");
        retorno.addObject("aluno", a);
        ar.save(a);
        
        // retorno.addObject("nome", a.getNome());
        // retorno.addObject("senha", a.getSenha());
        // retorno.addObject("idade", a.getIdade());
        return retorno;
    }
    
}