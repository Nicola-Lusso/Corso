package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CorsoService;
import model.dao.DiscenteService;
import model.dao.DocenteService;
import model.session.Corso;
import model.session.Discente;
import model.session.Docente;

/**
 * Servlet implementation class CtrlArchivioDocente
 */
@WebServlet("/CtrlGestioneCorso")
public class CtrlGestioneCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CorsoService oDoc = new CorsoService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlGestioneCorso() {
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
			nuovoCorso(request, response);
		} else if(azione.equals("Annulla")) {
			visualizzaElenco(request, response);
		} else if(azione.equals("Registra")) {
			salvaCorso(request, response);
			visualizzaElenco(request, response);
		} else if (azione.equals("Modifica")) {
			modificaCorso(request, response);
		} else if (azione.equals("Elimina")) {
			eliminaCorso(request, response);
		} else if (azione.equals("Conferma")) {
			cancellaCorso(request, response);
			visualizzaElenco(request, response);
		}

	}

	private void nuovoCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Corso oCorso = new Corso();
		request.getSession().setAttribute("beanCorso", oCorso);
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovoModifica.jsp").forward(request, response);
	}

	private void cancellaCorso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		oDoc.delete(((Corso) request.getSession().getAttribute("beanCorso")).getId());
	}

	private void eliminaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Corso oCorso = oDoc.findById(Integer.parseInt(request.getParameter("rdoIdCorso")));
		request.getSession().setAttribute("beanCorso", oCorso);
		getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteElimina.jsp").forward(request, response);
	}

	private void modificaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Corso oCorso = oDoc.findById(Integer.parseInt(request.getParameter("rdoIdCorso")));
		request.getSession().setAttribute("beanCorso", oCorso);
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsGestioneCorsoNuovoModifica.jsp").forward(request, response);
	}

	private void salvaCorso(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		((Corso) request.getSession().getAttribute("beanCorso")).setData_inizio(request.getParameter("txtCognome"));
		((Corso) request.getSession().getAttribute("beanCorso")).setNome(request.getParameter("txtNome"));
		if(((Corso) request.getSession().getAttribute("beanCorso")).getId() == 0)
			oDoc.persist(((Corso) request.getSession().getAttribute("beanCorso"))); 
		else
			oDoc.update(((Corso) request.getSession().getAttribute("beanCorso")));
	}
	


	private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Corso> elenco = new CorsoService().findAll();
		request.setAttribute("elencoCorsi", elenco);
		getServletContext().getRequestDispatcher("/GestioneCorso/PgsAGestioneCorso.jsp").forward(request, response);
	}

	

}
