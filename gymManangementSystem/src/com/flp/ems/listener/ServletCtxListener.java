package com.flp.ems.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;
import com.flp.ems.utils.HibernateUtils;

public class ServletCtxListener implements ServletContextListener {

	ServletContext  ctx=null;
	
	public ServletContext giveCtx()
	{
		return ctx;
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("in listner");
		HibernateUtils.getSf();
		ctx=arg0.getServletContext();
		IGymMemberService service=new GymMemberService();

		try {
			ctx.setAttribute("trainingProgramList",service.getAllTrainingProgramId());
			ctx.setAttribute("roleList",service.getAllRoleId());
			ctx.setAttribute("trainingSchemesList",service.getAllTrainingSchemesId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		giveCtx();

	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("out of listner");
		HibernateUtils.getSf().close();


	}


}
