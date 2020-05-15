package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class DeleteContactServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.contactService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramName;

        if (req.getParameter("oneContactId") != null) {
            paramName = "oneContactId";
        } else {
            paramName = "id";
        }

        int[] idsArray = Arrays.stream(req.getParameterValues(paramName)).mapToInt(Integer::parseInt).toArray();

        phoneBookService.deleteContact(idsArray);

        resp.sendRedirect("/phonebook");
    }
}