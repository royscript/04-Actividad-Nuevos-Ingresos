package cl.amisoft.usuarioapp.service;

import cl.amisoft.usuarioapp.vo.ToUsuariosVo;

import java.util.List;

public interface UsuariosService {
    ToUsuariosVo obtener(Long ccrUsuario);

    List<ToUsuariosVo> listar();

    ToUsuariosVo agregar(ToUsuariosVo toUsuariosVo);

    ToUsuariosVo eliminar(Long ccrUsuario);

    ToUsuariosVo editar(Long ccrUsuario, ToUsuariosVo toUsuariosVo);
}
