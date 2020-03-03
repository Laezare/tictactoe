package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grid;

public class DAOGridImpl implements DAOGrid {

	private Connection connection;

	public DAOGridImpl(Connection setConnection) {
		this.connection = setConnection;
	}

	
	public Grid getGrid(int id) {
		Grid grid = new Grid();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM grids WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultat = preparedStatement.executeQuery();

			if (resultat.next() == false) {
				return null;
			} else {
				do {
					grid.setGrid(resultat.getString("grid"));
				} while (resultat.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return grid;
	}

	public List<Grid> getAllGrids() {
		List<Grid> grids = new ArrayList<Grid>();
		try {
			System.out.println(connection);
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM grids");
			ResultSet resultat = preparedStatement.executeQuery();

			while (resultat.next()) {
				Grid grid = new Grid();
				grid.setId(resultat.getInt("id"));
				grid.setGrid(resultat.getString("grid"));
				grids.add(grid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grids;
	}

	public void AddGrid(Grid grid) {
		try {
			String query = "INSERT INTO grids(grid) VALUES (?)";			
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement = connection.prepareStatement(query, generatedColumns);
			preparedStatement.setString(1, grid.getGrid());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			while (rs.next()) {
				grid.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateGrid(Grid grid) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE grids SET grid = ? WHERE id = ?");

			preparedStatement.setString(1, grid.getGrid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteGrid(Grid grid) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete FROM grids WHERE id = ?");
			preparedStatement.setInt(1, grid.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
