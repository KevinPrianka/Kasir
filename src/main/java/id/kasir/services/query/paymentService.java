/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasir.app.services;

import kasir.app.core.mysql;

/**
 *
 * @author baros
 */
import kasir.app.core.configurasidb;
import kasir.app.models.Productpost;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class paymentService extends mysql {

    private boolean status;
    private String errorMessage;

    public List<Productpost> getAll() {

        List<Productpost> products = new ArrayList<>();

        String sql = "SELECT * from barang";

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                Productpost product = new Productpost();
                product.setCode(result.getString("code"));
                product.setName(result.getString("name"));
                product.setPrice(result.getInt("price"));

                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.status = false;
            this.errorMessage = e.getMessage();
        }

        return products;
    }

    public Productpost getByName(String name) {

        Productpost product = null;

        String sql = "SELECT * from barang WHERE name = '%s'";
        sql = String.format(sql, name);

        try {
            Statement stmt = paymentService.this.connection.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result.next()) {
                product = new Productpost();
                product.setCode(result.getString("code"));
                product.setName(result.getString("name"));
                product.setPrice(result.getInt("price"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.status = false;
            this.errorMessage = e.getMessage();
        }

        return product;
    }

    public boolean decreaseStock(String productId, int amount) {
        String sql = "UPDATE barang SET stock = stock - %d WHERE code = '%s'";
        sql = String.format(sql, amount, productId);

        try {
            Statement stmt = paymentService.this.connection.createStatement();
            boolean process = stmt.execute(sql);
            return process;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.status = false;
            this.errorMessage = e.getMessage();
        }

        return false;
    }
}
