package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AulaService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Aula;
import model.session.Discente;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@WebServlet("/CtrlArchivioAula")
public class CtrlArchivioAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AulaService oDoc = new AulaService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlArchivioAula() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String azione = request.getParameter("cmdAzione");
		if(azione == null) {
			visualizzaElenco(request, response);
		} else if(azione.equals("Torna alla Home")){
			getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
		} else if(azione.equals("Nuovo")) {
			nuovoAula(request, response);
		} else if(azione.equals("Annulla")) {
			visualizzaElenco(request, response);
		} else if(azione.equals("Registra")) {
			salvaAula(request, response);
			visualizzaElenco(request, response);
		} else if (azione.equals("Modifica")) {
			modificaAula(request, response);
		} else if (azione.equals("Elimina")) {
			eliminaAula(request, response);
		} else if (azione.equals("Conferma")) {
			cancellaAula(request, response);
			visualizzaElenco(request, response);
		}

	}

	private void cancellaAula(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		oDoc.delete(((Aula) request.getSession().getAttribute("beanAula")).getId());
	}

	private void eliminaAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Aula oAula = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDAula")));
		request.getSession().setAttribute("beanAula", oAula);
		getServletContext().getRequestDispatcher("/ArchivioAula/PgsArchivioAulaElimina.jsp").forward(request, response);
	}

	private void modificaAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Aula oAula = oDoc.findById(Integer.parseInt(request.getParameter("rdoIDAula")));
		request.getSession().setAttribute("beanAula", oAula);
		getServletContext().getRequestDispatcher("/ArchivioAula/PgsArchivioAulaNuovoModifica.jsp").forward(request, response);
	}

	private void salvaAula(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		((Aula) request.getSession().getAttribute("beanAula")).setPosti(request.getParameter("txtPosti"));
		((Aula) request.getSession().getAttribute("beanAula")).setNome(request.getParameter("txtNome"));
		if(((Aula) request.getSession().getAttribute("beanAula")).getId() == 0)
			oDoc.persist(((Aula) request.getSession().getAttribute("beanAula"))); 
		else
			oDoc.update(((Aula) request.getSession().getAttribute("beanAula")));
	}

	private void nuovoAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Aula oAula = new Aula();
		request.getSession().setAttribute("beanAula", oAula);
		getServletContext().getRequestDispatcher("/ArchivioAula/PgsArchivioAulaNuovoModifica.jsp").forward(request, response);
	}

	
	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Aula> elenco = new AulaService().findAll();
		request.setAttribute("elencoAula", elenco);
		getServletContext().getRequestDispatcher("/ArchivioAula/PgsArchivioAula.jsp").forward(request, response);
	}

	

}
