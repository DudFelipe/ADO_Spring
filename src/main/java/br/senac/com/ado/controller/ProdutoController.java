package br.senac.com.ado.controller;

import br.senac.com.ado.model.Categoria;
import br.senac.com.ado.model.Produto;
import br.senac.com.ado.repository.CategoriaRepository;
import br.senac.com.ado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ModelAndView listagem(){
        ModelAndView mv = new ModelAndView("Tela1A");
        List<Produto> produtos = produtoRepository.findAll();

        mv.addObject("produtos", produtos);


        return mv;
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionar(){
        ModelAndView mv = new ModelAndView("Tela2A");

        List<Categoria> categorias = categoriaRepository.findAll();

        for(Categoria c : categorias){
            System.out.println(c.getId());
            System.out.println(c.getName());
        }

        mv.addObject("produto", new Produto());
        mv.addObject("categoriasNome", categorias);


        return mv;
    }
//mm
    @PostMapping("/adicionar")
    public ModelAndView adicionar(Produto p){
        ModelAndView mv = new ModelAndView("redirect:/produto");

        p.setDtCadastro(LocalDate.now());

        produtoRepository.save(p);

        List<Produto> produtos = produtoRepository.findAll();

        mv.addObject("produtos", produtos);

        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable int id){
        ModelAndView mv = new ModelAndView("Tela2A");

        Produto p = produtoRepository.getOne(id);

        mv.addObject("produto", p);

        return mv;
    }

    @PostMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable int id, Produto p){
        ModelAndView mv = new ModelAndView("redirect:/produto");

        List<Categoria> categorias = categoriaRepository.findAll();

        Produto prod = produtoRepository.getOne(id);

        prod.setDescricao(p.getDescricao());
        prod.setDisponivel(p.getDisponivel());
        prod.setDtCadastro(p.getDtCadastro());
        prod.setNome(p.getNome());
        prod.setPrecoCompra(p.getPrecoCompra());
        prod.setPrecoVenda(p.getPrecoVenda());
        prod.setQuantidade(p.getQuantidade());
        prod.setCategoria((p.getCategoria()));

        mv.addObject("categoriasNome", categorias);

        produtoRepository.save(prod);

        return mv;
    }


}
