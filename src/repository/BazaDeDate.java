package repository;

import models.CasaDeMarcatImplementare;
import models.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BazaDeDate {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/proiect";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";

    private static final String GET_ALL_PRODUCTS = "SELECT * FROM produse";
    private static final String Update = "UPDATE produse SET pretProdus = ? WHERE numeProdus = ?";

    private static final String GET_ID = "SELECT * FROM produse";
    private static final String CREATE_NEW_PRODUCT = "INSERT INTO produse(idproduse,numeProdus,pretProdus)" +
            " values (NULL,?,?)";
    private static final String DELETE_PRODUCT = "DELETE FROM produse WHERE idproduse = ?";

    public static Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }

    public List<Produs> getProduts() throws SQLException {
        List<Produs> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(GET_ALL_PRODUCTS);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Produs p = new Produs(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            returnedList.add(p);
        }
        return returnedList;
    }

    public boolean addProduct(Produs p) throws SQLException {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(CREATE_NEW_PRODUCT);
        preparedStatement.setString(1, p.getNumeProdus());
        preparedStatement.setDouble(2, p.getPretProdus());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteProduct(int idProdus) throws SQLException {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(DELETE_PRODUCT);
        preparedStatement.setInt(1, idProdus);
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateProduct(double PretProdus, String NumeProdus) throws SQLException {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(Update);
        preparedStatement.setDouble(1, PretProdus);
        preparedStatement.setString(2, NumeProdus);
        return preparedStatement.executeUpdate() > 0;
    }

    public static int getId(String nume) throws SQLException {
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(GET_ID);
        ResultSet rs = preparedStatement.executeQuery();
        int id = 0;
        while (rs.next()) {
            if (rs.getString(2).equals(nume))
                id = rs.getInt(1);
        }
        return id;
    }


}
