package com.app.lab4_20197122_gtics_nube.controller;

import com.app.lab4_20197122_gtics_nube.entity.FloresHasColorHasOcasion;
import com.app.lab4_20197122_gtics_nube.entity.Usuario;
import com.app.lab4_20197122_gtics_nube.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
    final UsuarioRepository usuarioRepository;
    final ColorRepository colorRepository;
    final TipoRepository tipoRepository;
    final FlorRepository florRepository;
    final OcasionRepository ocasionRepository;
    final FloresHasColorHasOcasionRepository floresHasColorHasOcasionRepository;
    public AppController(UsuarioRepository usuarioRepository, ColorRepository colorRepository, TipoRepository tipoRepository, FlorRepository florRepository, OcasionRepository ocasionRepository, FloresHasColorHasOcasionRepository floresHasColorHasOcasionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.colorRepository = colorRepository;
        this.tipoRepository = tipoRepository;
        this.florRepository = florRepository;
        this.ocasionRepository = ocasionRepository;
        this.floresHasColorHasOcasionRepository = floresHasColorHasOcasionRepository;
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model,
                           @RequestParam(value = "color", required = false) Integer colorId,
                           @RequestParam(value = "tipo", required = false) Integer tipoId,
                           @RequestParam(value = "ocasion", required = false) Integer ocasionId) {

        List<FloresHasColorHasOcasion> listaFloresHasColorHasOcasion;
        //Condicional para los filtros
        if (colorId != null || tipoId != null || ocasionId != null) {
            if(colorId != null && tipoId == null && ocasionId == null){
                //Buscar por idcolor
                listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findAllByColorIdcolor_Id(colorId);
            } else if (colorId == null && tipoId != null && ocasionId == null){
                //Buscar por idtipo
                listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findAllByFloresIdflores_TipoIdtipo_Id(tipoId);
            } else if (colorId == null && tipoId == null && ocasionId != null){
                //Buscar por idocasion
                listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findAllByOcasionIdocasion_Id(ocasionId);
            } else {
                //Buscar por los tres
                listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findByFilters(colorId, tipoId, ocasionId);
            }

        }else{
            listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findAll();
        }
        //Enviar a la vista
        model.addAttribute("colores", colorRepository.findAll());
        model.addAttribute("tipos", tipoRepository.findAll());
        model.addAttribute("ocasiones", ocasionRepository.findAll());

        model.addAttribute("listaFloresHasColorHasOcasion", listaFloresHasColorHasOcasion);
        //Imprimir en consola listaFloresHasColorHasOcasion
        System.out.println(listaFloresHasColorHasOcasion);
        return "catalogo";
    }
    @GetMapping("/entretenimiento")
    public String entretenimiento(Model model) {
        List<FloresHasColorHasOcasion> listaFloresHasColorHasOcasion = floresHasColorHasOcasionRepository.findAll();
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaFloresHasColorHasOcasion", listaFloresHasColorHasOcasion);
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "entretenimiento";
    }
}
