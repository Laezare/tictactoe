package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOGrid;
import dao.DAOFactory;
import model.Grid;

/**
 * Servlet implementation class PostsList
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int PostId=0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOGrid daoGrid = factory.getDaoGrid();
		System.out.println(request.getParameter("PostButton"));
		if (request.getParameter("PostButton") != null) {
			try {
				PostId = Integer.parseInt(request.getParameter("PostButton"));
				System.out.println(PostId);
			} catch (Exception e) {
			}

		}
		if (PostId != 0) {
		
		char[] ch = (daoGrid.getGrid(PostId).getGrid()).toCharArray();
		request.setAttribute("gridArray0", ch[0]);
		request.setAttribute("gridArray1", ch[1]);
		request.setAttribute("gridArray2", ch[2]);
		request.setAttribute("gridArray3", ch[3]);
		request.setAttribute("gridArray4", ch[4]);
		request.setAttribute("gridArray5", ch[5]);
		request.setAttribute("gridArray6", ch[6]);
		request.setAttribute("gridArray7", ch[7]);
		request.setAttribute("gridArray8", ch[8]);
		}
		request.setAttribute("grids", daoGrid.getAllGrids());
		System.out.println(daoGrid.getAllGrids());
		this.getServletContext().getRequestDispatcher("/WEB-INF/tictactoe.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOGrid daoGrid= factory.getDaoGrid();
		if (request.getParameter("Supprimer") != null) {

			Grid delArticle = new Grid();
			delArticle.setId(Integer.parseInt(request.getParameter("Supprimer")));
			daoGrid.deleteGrid(delArticle);
		}
		request.setAttribute("grids", daoGrid.getAllGrids());
		request.getRequestDispatcher("/WEB-INF/tictactoe.jsp").forward(request, response);
	}

}
