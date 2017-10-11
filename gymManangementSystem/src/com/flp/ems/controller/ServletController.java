package com.flp.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.action.AddAction;
import com.flp.ems.action.GetAllAction;
import com.flp.ems.action.ModifyAction;
import com.flp.ems.action.RemoveAction;
import com.flp.ems.action.SearchAction;
import com.flp.ems.domain.GymMember;

public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletController() {
		super();

		System.out.println(".......in servlet controller");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GymMember emp = new GymMember();
		System.out.println("host name"+request.getRemoteHost());
		RequestDispatcher dispatcher;
		System.out.println(request.getParameter("submit"));
		switch(request.getParameter("submit")){

		case "register":
			AddAction action=new AddAction();
			dispatcher=request.getRequestDispatcher("addMember.jsp");
			request.setAttribute("message", action.execute(request));
			dispatcher.forward(request, response);
			break;

		case "get all Members":
			GetAllAction get=new GetAllAction();
			try {
			//	ServletContext ctx=getServletContext();
				request.setAttribute("list", get.execute());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher=request.getRequestDispatcher("getAllMember.jsp");

			dispatcher.forward(request, response);

			break;

		case "update Search":
			ModifyAction modify=new ModifyAction();
			try {
				List<GymMember> list=modify.execute(request.getParameter("choice"),request.getParameter("txt"));
				System.out.println(list);
				if(list.size()>0)
					request.setAttribute("modify", list);
					else
						request.setAttribute("message", "no records found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher=request.getRequestDispatcher("modifyMember.jsp");

			dispatcher.forward(request, response);
			
			break;
			
			
		case "update":
			ModifyAction update=new ModifyAction();
			dispatcher=request.getRequestDispatcher("modifyMember.jsp");
			request.setAttribute("message", update.execute(request));
			dispatcher.forward(request, response);
			break;
			

		case "search":

			SearchAction search=new SearchAction();
			try {
				List<GymMember> list=search.execute(request.getParameter("choice"),request.getParameter("txt"));
				System.out.println(list);
				if(list.size()>0)
				request.setAttribute("search", list);
				else
					request.setAttribute("message", "no records found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher=request.getRequestDispatcher("searchMember.jsp");
			dispatcher.forward(request, response);

			break;

		case "remove":

		RemoveAction remove=new RemoveAction();
		dispatcher=request.getRequestDispatcher("removeMember.jsp");
		request.setAttribute("message",remove.execute(request.getParameter("choice"),request.getParameter("txt")));
		dispatcher.forward(request, response);
		break;
		
		}





	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
