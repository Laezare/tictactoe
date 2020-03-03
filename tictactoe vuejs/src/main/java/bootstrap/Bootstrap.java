package bootstrap;


import java.lang.reflect.Array;

import dao.DAOFactory;
import dao.DAOGrid;
import model.Grid;

public class Bootstrap {

	public static void main(String[] args) {
		//Test console
		
		DAOFactory factory = new DAOFactory();
		DAOGrid daoGrid = factory.getDaoGrid();
		System.out.println(daoGrid.getGrid(1).getGrid());
		char[] ch = (daoGrid.getGrid(1).getGrid()).toCharArray();
		System.out.println(ch[2]);
		System.out.println(ch);
		Grid newGrid = new Grid();
		
		newGrid.setGrid("101022012");
		newGrid.setId(2);
		//daoGrid.AddGrid(newGrid);
		//daoGrid.deleteGrid(newGrid);
		System.out.println(daoGrid.getAllGrids());
		/*
		System.out.println(daoArticle.getArticle(1).getAuteur());
		System.out.println(daoArticle.getAllArticles());
		System.out.println(daoArticle);
		
		
		Article newArticle = new Article();
		
		newArticle.setTitre("2nd article");
		newArticle.setAuteur("Krepa");
		newArticle.setDate(Date.valueOf(LocalDate.now()));
		newArticle.setDescription("a short description");
		newArticle.setTexte("A really interesting text");
		daoArticle.AddArticle(newArticle);
		
		System.out.println(daoArticle.getAllArticles());
		*/
		/*
		//create Tom
		User userT = new User();
		
		
		userT.setFirstname("Krepa");
		userT.setSurname("Tom");
		userT.setPassword("Parrot");
		userT.setMail("tom.krepa@ynov.com");
		daoUser.AddUser(userT);
		
		//Update Yaya
		User userY = new User();

		userY.setId(3);
		userY.setFirstname("Yanis");
		userY.setSurname("Dj");
		userY.setPassword("LaTaupe");
		userY.setMail("yanis.dj@ynov.com");
		daoUser.updateUser(userY);
		
		//print list
		System.out.println(daoUser.getAllUsers());
		System.out.println("Récuperation de l'utilisateur et affichage");
		User generatedUser = daoUser.getUser(userT.getId());
		System.out.println(generatedUser);
		
		//Delete
		daoUser.deleteUser(userT);
		generatedUser = daoUser.getUser(userT.getId());
		System.out.println(generatedUser);
		*/
	}

}
