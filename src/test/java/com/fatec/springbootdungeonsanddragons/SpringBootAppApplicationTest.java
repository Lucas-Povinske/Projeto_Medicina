package com.fatec.springbootdungeonsanddragons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import org.springframework.test.annotation.Rollback;
//import com.fatec.springbootdungeonsanddragons.entity.Autorizacao;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
//import com.fatec.springbootdungeonsanddragons.service.SegurancaService;
//import com.fatec.springbootdungeonsanddragons.repository.AutorizacaoRepository;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private FeiticeiroRepository feitiRepo;

    @Autowired
    private UsuarioService usuarioService;

    // TESTES PRINCIPAIS
	@Test
	void contextLoads() {
    }
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Povs");
        usuario.setSenha("senha");
        usuario.setNomeExibicao("teste");

        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }

    // TESTES DE BUSCA
    @Test
    void testaBuscaUsuarioNomeContains() {
        List<Usuario> usuarios = usuarioRepo.findByNomeUsuario("Povs");
        assertTrue(!usuarios.isEmpty());
    }
    /*
    @Test
    void testaBuscaUsuarioId() {
        Usuario usuario = usuarioRepo.findById("1");
        assertNotNull(usuario);
    }

    // TESTES DE BUSCA COM @QUERY
    @Test
    void testaQueryBuscaUsuarioNome() {
        Usuario usuario = usuarioRepo.buscaPorNome("rodrigo reis");
        assertNotNull(usuario);
    }
    @Test
    void testaQueryBuscaUsuarioNomeSenha() {
        Usuario usuario = usuarioRepo.buscaPorNomeESenha("rodrigocr16", "pepino");
        assertNotNull(usuario);
    }
    @Test
    void testaQueryBuscaUsuarioAutorizacao() {
        List<Usuario> usuarios = usuarioRepo.buscaPorNomeAutorizacao("admin");
        assertTrue(!usuarios.isEmpty());
    }

    // TESTE DE SERVICES
    @Test
    void testaServicoCriaUsuario() {
        Usuario usuario = segService.criarUsuario("joedoe", "j03m4m4", "joseph doestar", "usuario");
        assertNotNull(usuario);
    }
    */
}