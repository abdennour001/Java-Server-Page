package org.supermarket.servlet;

import org.supermarket.ConnectionMySQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get the barcode from the get request
        String barcode = request.getParameter("searchInputField");
        //search for the item
        try {
            ConnectionMySQL.connectToDataBase();
            Statement statement=ConnectionMySQL.connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * from item where barcode="+"'"+barcode+"'");
            resultSet.next();
            String address;

            if (!resultSet.isLast()) {
                System.out.println("No item found !");
                // return to the search page
                address = "/index.html";
            } else {
                // item was found, redirect to the details page
                address = "/details.jsp?barcode="+resultSet.getString(1)+"&name="+resultSet.getString(2)+
                        "&quantity="+resultSet.getString(3)+"&price="+resultSet.getString(4);
            }

            // set the request dispatcher
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher(address);
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
