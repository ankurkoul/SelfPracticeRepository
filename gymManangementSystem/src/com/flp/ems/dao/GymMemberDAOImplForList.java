package com.flp.ems.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.flp.ems.domain.TrainingProgram;
import com.flp.ems.domain.GymMember;
import com.flp.ems.domain.TrainingSchemes;
import com.flp.ems.domain.Role;
import com.flp.ems.utils.HibernateUtils;

public class GymMemberDAOImplForList implements IGymMemberDAO{
	@Override
	public int addGymMember(GymMember ob) throws Exception {

		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		int id=0;
		try {
			if(searchByKinId(ob.getKinId()).size()>0||searchByEmailId(ob.getEmailId()).size()>0)
			{
				return -1;

			}
			else
			{id=(Integer) sess.save(ob);
			tx.commit();
			}
		}
		catch(HibernateException e){
			if(tx!=null){
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());

			}

		}

		finally {
			if (sess != null)
			{sess.flush();
			sess.close();

			}
		}
		return id;
	}

	@Override
	public GymMember showGymMember(int memberId) throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		GymMember member=null;

		try {
			member	=(GymMember) sess.get(GymMember.class,memberId);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		} finally {
			if (sess != null)
			{sess.flush();
			sess.close();

			}
		}
		return member;
	}

	@Override
	public TrainingProgram showTrainingProgram(int trainId) throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		TrainingProgram program=null;

		try {
			program=(TrainingProgram) sess.get(TrainingProgram.class,trainId);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		} finally {
			if (sess != null)
			{sess.flush();
			sess.close();

			}
		}
		return program;
	}

	@Override
	public TrainingSchemes showTrainingSchemes(int schemeId) throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		TrainingSchemes schemes=null;

		try {
			schemes	=(TrainingSchemes) sess.get(TrainingSchemes.class,schemeId);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		} finally {
			if (sess != null)
			{sess.flush();
			sess.close();

			}
		}
		return schemes;
	}

	@Override
	public Role showRole(int roleId) throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		Role role=null;

		try {
			role=(Role) sess.get(Role.class,roleId);
			tx.commit();
		}
		catch (HibernateException e)
		{
			if (tx != null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		} finally {
			if (sess != null)
			{sess.flush();
			sess.close();

			}
		}
		return role;

	}

	public List<GymMember> search(String name,String value) throws Exception {
		// TODO Auto-generated method stub
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		List<GymMember> list=null;

		//GymMember emp = null;
		try{
			Query query = sess.createQuery("from GymMember where'"+name+"' =:code ");
			//query.setParameter("name", name);
			query.setParameter("code", value);
			list = query.list();
			System.out.println(query);
			tx.commit();


		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());

		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}





	public List<GymMember> search(String name,String value,String name2,String value2) throws Exception {
		// TODO Auto-generated method stub
		Session sess=HibernateUtils.getSession();
		//GymMember emp = null;
		Transaction tx=sess.beginTransaction();
		List<GymMember> list =null;

		try{
			Query query = sess.createQuery("from GymMember where :name = :code and :name2=:code2");
			query.setParameter("name", name);
			query.setParameter("code", value);
			query.setParameter("name2", name2);
			query.setParameter("code2", value2);


			list= query.list();
			System.out.println(query);
			tx.commit();


		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
System.out.println("-------------------->"+	e.getMessage());

		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}




	public List<GymMember> search(String name1,String value,String name2,String value2,String name3,String value3) throws Exception {
		// TODO Auto-generated method stub
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		List<GymMember> list = null;
		//GymMember emp = null;
		try{
			Query query = sess.createQuery("from GymMember where :name = :code and :name2=:code2 and :name3=:code3");
			query.setParameter("name", name1);
			query.setParameter("code", value);
			query.setParameter("name2", name2);
			query.setParameter("code2", value2);
			query.setParameter("name3", name3);
			query.setParameter("code3", value3);

			list = query.list();
			System.out.println(query);
			tx.commit();


		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());

		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}



	public List<GymMember> searchByKinId(String kin) throws Exception{
		// TODO Auto-generated method stub
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		List<GymMember> list = null;
		//GymMember emp = null;
		try{Query query = sess.createQuery("from GymMember where kinId = :code ");
		query.setParameter("code", kin);
		list = query.list();
		System.out.println(query);
		tx.commit();


		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			System.out.println("-------------------->"+	e.getMessage());

		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}

	public List<GymMember> searchByEmailId(String email) throws Exception{
		Session sess=HibernateUtils.getSession();
		//GymMember emp = null;
		Transaction tx=sess.beginTransaction();
		List<GymMember> list = null;
		try{

			Query query = sess.createQuery("from GymMember where emailId = :code ");
			query.setParameter("code", email);
			list = query.list();
			System.out.println(query);
			tx.commit(); 

		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list; 
	}

	public ArrayList<GymMember> getAllGymMember() throws Exception {
		Session sess=HibernateUtils.getSession();
		ArrayList<GymMember> list=null;
		Transaction tx=sess.beginTransaction();
		String sql = "from GymMember";
		try
		{
			list=(ArrayList<GymMember>) sess.createQuery(sql).list();
System.out.println("list in get all GymMember");
System.out.println("list----->"+list);

			tx.commit();
			return list;  

		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return null; 
	}


	public boolean removeGymMember(GymMember member)throws Exception
	{
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		boolean status=false;
		try{
			sess.delete(member);
			status=true;
			tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}

		}
		finally{
			if(sess!=null){
				sess.flush();
				sess.close();
			}
		}
		return status;
	}

	@Override
	public boolean removeGymMember(String name,String value)throws Exception
	{
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		boolean status=false;
		try{

			Query query = sess.createQuery("delete from GymMember where :name = :value");
			query.setParameter("name", name);
			query.setParameter("valuee", value);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			status=true;
			tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}

System.out.println("-------------------->"+	e.getMessage());

		}
		finally{
			if(sess!=null){
				sess.flush();
				sess.close();
			}

		}
		return status;
	}

	@Override
	public boolean modifyGymMember(GymMember e,int empId) throws Exception {
		Session sess =HibernateUtils.getSession();
		Transaction tx =sess.beginTransaction();
		boolean status=false;
		try{

			GymMember emp=  (GymMember) sess.get(GymMember.class,empId); 
			emp.setDateOfBirth(e.getDateOfBirth());
			emp.setAddress(e.getAddress());
			emp.setDateOfJoining(e.getDateOfJoining());
			emp.setTrainingProgram(e.getTrainingProgram());
			emp.setEmailId(e.getEmailId());
			emp.setName(e.getName());
			emp.setPhoneNo(e.getPhoneNo());
			emp.setTrainingSchemes(e.getTrainingSchemes());
			emp.setRole(e.getRole());
			sess.update(emp); 
			status=true;
			tx.commit();
		}
		catch (HibernateException h) {
			if (tx!=null) 
				tx.rollback();

System.out.println("-------------------->"+	h.getMessage());
		}finally {
			if(sess!=null){
				sess.flush();
				sess.close();
			}
		}
		return status;
	}
	@Override
	public List<TrainingProgram> getAllTrainingProgramId() throws Exception {
		Session sess=HibernateUtils.getSession();
		ArrayList<TrainingProgram> list=null;
		Transaction tx=sess.beginTransaction();

		String sql = "select trainId,name from TrainingProgram";
		try
		{
			list=(ArrayList<TrainingProgram>) sess.createQuery(sql).list();
			tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}


	@Override
	public List<Role> getAllRoleId() throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		ArrayList<Role> list=null;

		String sql = "select roleId,name from Role";
		try
		{
			list=(ArrayList<Role>) sess.createQuery(sql).list();
			tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}


	@Override
	public List<TrainingSchemes> getAllTrainingSchemesId() throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		ArrayList<TrainingSchemes> list=null;

		String sql = "select schemeId,name from TrainingSchemes";
		try
		{
			list=(ArrayList<TrainingSchemes>) sess.createQuery(sql).list();
			tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}


	@Override
	public List<GymMember> searchByName(String code) throws Exception {
		Session sess=HibernateUtils.getSession();
		Transaction tx=sess.beginTransaction();
		List<GymMember> list=null;
		//GymMember emp = null;
		try{Query query = sess.createQuery("from GymMember where name = :code ");
		query.setParameter("code", code);
		list = query.list();
		System.out.println(query);
		tx.commit();
		}
		catch(HibernateException e){
			if(tx!=null)
				tx.rollback();

System.out.println("-------------------->"+	e.getMessage());
		}
		finally{
			if(sess!=null)
			{
				sess.flush();
				sess.close();

			}
		}
		return list;  
	}




}














