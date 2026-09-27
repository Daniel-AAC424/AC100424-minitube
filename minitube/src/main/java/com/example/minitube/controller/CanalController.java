package com.example.minitube.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.minitube.model.Canal;
import com.example.minitube.model.CategoriaVideo;
import com.example.minitube.service.CanalService;

@Controller
public class CanalController {
	
    private final CanalService canalService;

    public CanalController(CanalService canalService) {
        this.canalService = canalService;
    }

    @GetMapping("/")
    public String inicio(
            @RequestParam(name = "nombre", defaultValue = "") String nombre,
            Model model) {

        List<Canal> resultados =
            canalService.buscarCanalesPorNombre(nombre);

        model.addAttribute("canales", resultados);
        model.addAttribute("busqueda", nombre);
        model.addAttribute("busquedaActiva", !nombre.isBlank());

        return "index";
    }

    @GetMapping("/canales/nuevo")
    public String nuevoCanal() {
        return "nuevo-canal";
    }

    @PostMapping("/canales")
    public String crearCanal(
    		@RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "usuario") String usuario,
            @RequestParam(name = "descripcion") String descripcion,
            @RequestParam(name = "urlPortada", required = false) String urlPortada){

        Canal canal = canalService.crearCanal(
            nombre,
            usuario,
            descripcion,
            urlPortada
        );

        return "redirect:/canales/" + canal.getId();
    }

    @GetMapping("/canales/{id}")
    public String verCanal(
            @PathVariable Long id,
            Model model) {

        Canal canal = canalService.buscarCanal(id);

        if (canal == null) {
            return "redirect:/";
        }

        model.addAttribute("canal", canal);
        model.addAttribute("categorias", CategoriaVideo.values());
        return "canal";
    }

    @PostMapping("/canales/{id}/videos")
    public String agregarVideo(
    		@PathVariable Long id,
            @RequestParam(name = "titulo") String titulo,
            @RequestParam(name = "urlYoutube") String urlYoutube,
            @RequestParam(name = "categoria") CategoriaVideo categoria) {

        canalService.agregarVideo(
            id,
            titulo,
            urlYoutube,
            categoria
        );

        return "redirect:/canales/" + id;
    }
           
    @PostMapping("/canales/{canalId}/videos/{videoId}/eliminar")
    public String eliminarVideo(
             @PathVariable Long canalId,
             @PathVariable Long videoId) {

             canalService.eliminarVideo(canalId, videoId);

             return "redirect:/canales/" + canalId;
    }



}
