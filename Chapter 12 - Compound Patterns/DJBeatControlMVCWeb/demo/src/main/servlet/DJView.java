package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beat.BeatModel;

// @WebServlet("/DJView")
// Servlet is the Controller in the MVC (Web) Model 2
public class DJView extends HttpServlet {

    public void init() throws ServletException {
        BeatModel beatModel = new BeatModel();
        beatModel.initialize();
        getServletContext().setAttribute("beatModel", beatModel);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws IOException, ServletException {
        BeatModel beatModel = (BeatModel) getServletContext().getAttribute("beatModel");

        String bpm = request.getParameter("bpm");
        if (bpm == null) {
            bpm = beatModel.getBPM() + "";
        }

        String set = request.getParameter("set");
        if (set != null) {
            int bpmNumber = 90;
            bpmNumber = Integer.parseInt(bpm);
            beatModel.setBPM(bpmNumber);
        }

        String decrease = request.getParameter("decrease");
        if (decrease != null) {
            beatModel.setBPM(beatModel.getBPM() - 1);
        }

        String increase = request.getParameter("increase");
        if (increase != null) {
            beatModel.setBPM(beatModel.getBPM() + 1);
        }

        String on = request.getParameter("on");
        if (on != null) {
            beatModel.start();
        }

        String off = request.getParameter("off");
        if (off != null) {
            beatModel.stop();
        }

        request.setAttribute("beatModel", beatModel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("DJView.jsp");
        dispatcher.forward(request, response);
    }
}