package br.ifpe.pg.provacolegiada.cadastro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cursos/")
@Secured("ROLE_ADMIN")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	@Autowired
	private ProfessorService professorService;

	@GetMapping("list")
	public ModelAndView exibirLista(Curso curso) {
		ModelAndView mv = new ModelAndView("cadastros/cursos-list");
		mv.addObject("lista", cursoService.listarTodos());
		mv.addObject("listaModalidades", Modalidade.values());
		mv.addObject("listaProfessores", professorService.listarTodas());
		mv.addObject("curso", curso);
		return mv;
	}

	@PostMapping("salvar")
	public String salvar(@Valid @ModelAttribute Curso curso, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível salvar curso: " + errors.getFieldErrors());
		} else {
			try {
				cursoService.salvar(curso);
				ra.addFlashAttribute("mensagemSucesso", "Curso salvo com sucesso [" + curso.getNome() + "]");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível salvar curso: " + e.getMessage());
			}
		}
		return "redirect:/cursos/list";
	}

	@GetMapping("edit/{id}")
	public ModelAndView exibirEdicao(@PathVariable("id") Integer id) {
		Curso curso = cursoService.buscarPorId(id);
		return exibirLista(curso);
	}
	

	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes ra) {
		Curso cursoRemovido = cursoService.removerPorId(id);
		ra.addFlashAttribute("mensagemSucesso", "Curso removido com sucesso [" + cursoRemovido.getNome() + "]");
		return "redirect:/cursos/list";
	}

}
