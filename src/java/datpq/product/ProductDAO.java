/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.product;

import datpq.registration.RegistrationDTO;
import datpq.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> productList;

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public List<ProductDTO> buyBook()
            throws SQLException, NamingException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Write SQL
                String sql = "Select SKU, ProductName, Quantity, Price, Status "
                        + "From Products ";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                //4. Excute stm to get result
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    String SKU = rs.getString("SKU");
                    String ProductName = rs.getString("ProductName");
                    int Quantity = rs.getInt("Quantity");
                    float Price = rs.getFloat("Price");
                    boolean Status = rs.getBoolean("Status");

                    ProductDTO dto = new ProductDTO(SKU, ProductName, Quantity, Price, Status);
                    if (this.productList == null) {
                        this.productList = new ArrayList<>();
                    }
                    this.productList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return productList;
    }

}
