package cl.amisoft.usuarioapp.controller;
import java.util.List;

import cl.amisoft.usuarioapp.service.UsuariosService;
import cl.amisoft.usuarioapp.vo.ToUsuariosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT})
public class UsuariosController {
    @Autowired
    private final UsuariosService usuariosService;
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }
    @GetMapping(value = "/{ccrUsuario}", produces = "application/json")
    public ToUsuariosVo getByCcrUsuario(@PathVariable(name = "ccrUsuario") Long ccrUsuario){
        return usuariosService.obtener(ccrUsuario);
    }
    @GetMapping()
    public List<ToUsuariosVo> getAll() {
        return usuariosService.listar();
    }
    @PostMapping()
    public ToUsuariosVo addUsuario(@RequestBody ToUsuariosVo toUsuariosVo){
        return usuariosService.agregar(toUsuariosVo);
    }
    @PutMapping()
    public ToUsuariosVo updateUsuario(@PathVariable Long ccrUsuario, @RequestBody ToUsuariosVo toUsuariosVo){
        return usuariosService.editar(ccrUsuario,toUsuariosVo);
    }

    @DeleteMapping()
    public ToUsuariosVo deleteUsuario(@PathVariable Long ccrUsuario){
        return usuariosService.eliminar(ccrUsuario);
    }
}
