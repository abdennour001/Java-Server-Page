package org.supermarket.servlet;

import org.supermarket.ConnectionMySQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get form data from the post request
        String Sbarcode="";
        String Sname="";
        String Squantity="";
        String Sprice="";

        Sbarcode = request.getParameter("barCodeField");
        Sname = request.getParameter("nameField");
        Squantity = request.getParameter("quantityField");
        Sprice = request.getParameter("priceField");

        int quantity=Integer.parseInt(Squantity);
        int price=Integer.parseInt(Sprice);

        // Starting insert query
        String insertItemQuery="INSERT INTO `"+ ConnectionMySQL.getBDD() +"`.`item` (`barcode`, `name`, `quantity`, `price`) VALUES ('"+
                Sbarcode+"', '"+
                Sname+"', '"+
                quantity+"', '"+
                price+"')";

        try {
            ConnectionMySQL.connectToDataBase();
            Statement statement = ConnectionMySQL.connection.createStatement();
            statement.executeUpdate(insertItemQuery);
            ConnectionMySQL.closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // after the insertion, we go to the item details page
        // set the request dispatcher
        String address = "/details.jsp?barcode="+Sbarcode+"&name="+Sname+
                "&quantity="+Squantity+"&price="+Sprice;
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
