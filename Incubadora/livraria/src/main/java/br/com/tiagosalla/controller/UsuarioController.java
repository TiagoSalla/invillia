package br.com.tiagosalla.controller;

import br.com.tiagosalla.model.dao.UsuarioDAO;
import br.com.tiagosalla.model.entidades.Assunto;
import br.com.tiagosalla.model.entidades.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class UsuarioController extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setUsuario(req.getParameter("usuario"));
        usuario.setSenha(req.getParameter("senha"));
        usuario.setNome(req.getParameter("nome"));
        usuario.setEmail(req.getParameter("email"));

        usuarioDAO.insert(usuario);

        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sucesso.jsp");
        requestDispatcher.forward(req, resp);
    }
}
