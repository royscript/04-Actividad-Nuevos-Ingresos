package cl.amisoft.usuarioapp.service.impl;

import cl.amisoft.usuarioapp.dao.UsuariosDao;
import cl.amisoft.usuarioapp.models.Usuarios;
import cl.amisoft.usuarioapp.service.UsuariosService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cl.amisoft.usuarioapp.vo.ToUsuariosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UsuarioServiceImpl implements UsuariosService {
    private final UsuariosDao usuariosDao;

    @Autowired
    public UsuarioServiceImpl(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }

    @Override
    public ToUsuariosVo obtener(Long id) {
        Optional<Usuarios> usuarios = usuariosDao.obtenerUsuario(id);
        if (usuarios.isPresent()) {
            return new ToUsuariosVo.Builder()
                    .ccrUsuario(usuarios.get().getCcrUsuario())
                    .codUsuarioCrea(usuarios.get().getCodUsuarioCrea())
                    .codUsuarioMod(usuarios.get().getCodUsuarioMod())
                    .glsFuncionarioCrea(usuarios.get().getGlsFuncionarioCrea())
                    .glsFuncionarioMod(usuarios.get().getGlsFuncionarioMod())
                    .fecCrea(usuarios.get().getFecCrea())
                    .fecMod(usuarios.get().getFecMod())
                    .glsUsername(usuarios.get().getGlsUsername())
                    .glsConcepto(usuarios.get().getGlsConcepto())
                    .fecConcepto(usuarios.get().getFecConcepto())
                    .codConcepto(usuarios.get().getCodConcepto())
                    .rut(usuarios.get().getRut())
                    .rutDiv(usuarios.get().getRutDiv())
                    .build();
        }
        return new ToUsuariosVo();
    }

    @Override
    public List<ToUsuariosVo> listar() {
        return usuariosDao.listar().stream()
                .map(u -> new ToUsuariosVo.Builder()
                        .ccrUsuario(u.getCcrUsuario())
                        .codUsuarioCrea(u.getCodUsuarioCrea())
                        .codUsuarioMod(u.getCodUsuarioMod())
                        .glsFuncionarioCrea(u.getGlsFuncionarioCrea())
                        .glsFuncionarioMod(u.getGlsFuncionarioMod())
                        .fecCrea(u.getFecCrea())
                        .fecMod(u.getFecMod())
                        .glsUsername(u.getGlsUsername())
                        .glsConcepto(u.getGlsConcepto())
                        .fecConcepto(u.getFecConcepto())
                        .codConcepto(u.getCodConcepto())
                        .rut(u.getRut())
                        .rutDiv(u.getRutDiv())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ToUsuariosVo agregar(ToUsuariosVo toUsuariosVo) {
        Usuarios usuario = usuariosDao.agregar(new Usuarios.Builder()
                .ccrUsuario(toUsuariosVo.getCcrUsuario())
                .codUsuarioCrea(toUsuariosVo.getCodUsuarioCrea())
                .codUsuarioMod(toUsuariosVo.getCodUsuarioMod())
                .glsFuncionarioCrea(toUsuariosVo.getGlsFuncionarioCrea())
                .glsFuncionarioMod(toUsuariosVo.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(toUsuariosVo.getGlsUsername())
                .glsConcepto(toUsuariosVo.getGlsConcepto())
                .fecConcepto(toUsuariosVo.getFecConcepto())
                .codConcepto(toUsuariosVo.getCodConcepto())
                .rut(toUsuariosVo.getRut())
                .rutDiv(toUsuariosVo.getRutDiv())
                .build());
        return new ToUsuariosVo.Builder()
                .ccrUsuario(usuario.getCcrUsuario())
                .codUsuarioCrea(usuario.getCodUsuarioCrea())
                .codUsuarioMod(usuario.getCodUsuarioMod())
                .glsFuncionarioCrea(usuario.getGlsFuncionarioCrea())
                .glsFuncionarioMod(usuario.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuario.getGlsUsername())
                .glsConcepto(usuario.getGlsConcepto())
                .fecConcepto(usuario.getFecConcepto())
                .codConcepto(usuario.getCodConcepto())
                .rut(usuario.getRut())
                .rutDiv(usuario.getRutDiv())
                .build();
    }

    @Override
    @Transactional
    public ToUsuariosVo eliminar(Long ccrUsuario) {
        Optional<Usuarios> usuario = usuariosDao.obtenerUsuario(ccrUsuario);
        if (usuario.isPresent()) {
            Usuarios usuario1 = usuariosDao.eliminar(usuario.get());
            return new ToUsuariosVo.Builder()
                    .ccrUsuario(usuario.get().getCcrUsuario())
                    .codUsuarioCrea(usuario.get().getCodUsuarioCrea())
                    .codUsuarioMod(usuario.get().getCodUsuarioMod())
                    .glsFuncionarioCrea(usuario.get().getGlsFuncionarioCrea())
                    .glsFuncionarioMod(usuario.get().getGlsFuncionarioMod())
                    .fecCrea(LocalDate.now())
                    .fecMod(LocalDate.now())
                    .glsUsername(usuario.get().getGlsUsername())
                    .glsConcepto(usuario.get().getGlsConcepto())
                    .fecConcepto(usuario.get().getFecConcepto())
                    .codConcepto(usuario.get().getCodConcepto())
                    .rut(usuario.get().getRut())
                    .rutDiv(usuario.get().getRutDiv())
                    .build();
        }
        return null;
    }

    @Override
    @Transactional
    public ToUsuariosVo editar(Long ccrUsuario, ToUsuariosVo toUsuariosVo) {
        Usuarios usuario =  usuariosDao.editar(new Usuarios.Builder()
                .ccrUsuario(toUsuariosVo.getCcrUsuario())
                .codUsuarioCrea(toUsuariosVo.getCodUsuarioCrea())
                .codUsuarioMod(toUsuariosVo.getCodUsuarioMod())
                .glsFuncionarioCrea(toUsuariosVo.getGlsFuncionarioCrea())
                .glsFuncionarioMod(toUsuariosVo.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(toUsuariosVo.getGlsUsername())
                .glsConcepto(toUsuariosVo.getGlsConcepto())
                .fecConcepto(toUsuariosVo.getFecConcepto())
                .codConcepto(toUsuariosVo.getCodConcepto())
                .rut(toUsuariosVo.getRut())
                .rutDiv(toUsuariosVo.getRutDiv())
                .build());
        return new ToUsuariosVo.Builder()
                .ccrUsuario(usuario.getCcrUsuario())
                .codUsuarioCrea(usuario.getCodUsuarioCrea())
                .codUsuarioMod(usuario.getCodUsuarioMod())
                .glsFuncionarioCrea(usuario.getGlsFuncionarioCrea())
                .glsFuncionarioMod(usuario.getGlsFuncionarioMod())
                .fecCrea(LocalDate.now())
                .fecMod(LocalDate.now())
                .glsUsername(usuario.getGlsUsername())
                .glsConcepto(usuario.getGlsConcepto())
                .fecConcepto(usuario.getFecConcepto())
                .codConcepto(usuario.getCodConcepto())
                .rut(usuario.getRut())
                .rutDiv(usuario.getRutDiv())
                .build();
    }
}
