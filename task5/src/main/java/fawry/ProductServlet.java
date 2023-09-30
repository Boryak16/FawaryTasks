package fawry;

import java.io.*;
import java.util.List;
import java.util.Optional;

import fawry.entity.Product;
import fawry.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

@WebServlet("/")
public class ProductServlet extends HttpServlet {
    private Optional<String> action;
    private ProductService productService;
    private List<Product> products ;
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = Optional.ofNullable(request.getServletPath()).orElse("list");
        System.out.println(path);
        switch (path){
            case "/add":
                showAddProductPage(request , response);
            case "/delete":
                deleteProduct(request , response);
            default:
                showProductList(request ,response);

        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action = Optional.ofNullable(req.getParameter("action"));
        if(action.get().equals("save")){
            saveProduct(req , resp);
        }
    }


    private void showAddProductPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-product.jsp");
        requestDispatcher.forward(request , response);
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAllProduct();
       request.setAttribute("products" , products);
        System.out.println(products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
        requestDispatcher.include(request , response);
    }

    private void deleteProduct(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("products");
    }

    private void saveProduct(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        productService.addProduct(name , price);
        response.sendRedirect("products");
    }

}