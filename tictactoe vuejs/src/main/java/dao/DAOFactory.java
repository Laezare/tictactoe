package dao;

public class DAOFactory {
	private MySQLManager manager;
	private DAOGrid daoGrid;
	public DAOFactory() {
		manager = MySQLManager.getInstance();
		daoGrid = new DAOGridImpl(manager.getConnection());
	}
	public DAOGrid getDaoGrid() {
		return daoGrid;
	}

}
