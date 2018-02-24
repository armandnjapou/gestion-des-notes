package servicesImpl;

import java.util.List;

import dao.CoursDao;
import entities.Cours;
import services.CoursService;

public class CoursServiceImpl implements CoursService {

	private CoursDao coursDao;
	
	public CoursDao getCoursDao() {
		return coursDao;
	}

	public void setCoursDao(CoursDao coursDao) {
		this.coursDao = coursDao;
	}

	@Override
	public void addCours(Cours cours) {
		// TODO Auto-generated method stub
		this.coursDao.addCours(cours);
	}

	@Override
	public void updateCours(Cours cours) {
		// TODO Auto-generated method stub
		this.coursDao.updateCours(cours);
	}

	@Override
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		return this.coursDao.getAllCours();
	}

	@Override
	public Cours getCoursByIntitule(String initutle) {
		// TODO Auto-generated method stub
		return this.coursDao.getCoursByIntitule(initutle);
	}

	@Override
	public void removeCours(String intitule) {
		// TODO Auto-generated method stub
		this.coursDao.removeCours(intitule);
	}

	@Override
	public Cours getCoursByID(int id) {
		
		return  this.coursDao.getCoursByID(id);
	}

	@Override
	public void removeCours(int id) {
		this.coursDao.removeCours(id);
		
	}

}
