package dao;

import java.util.List;
import model.Grid;

public interface DAOGrid {
	public Grid getGrid(int id);
	public List<Grid> getAllGrids();
	public void AddGrid(Grid grid);
	public void updateGrid(Grid grid);
	public void deleteGrid(Grid grid);

}
