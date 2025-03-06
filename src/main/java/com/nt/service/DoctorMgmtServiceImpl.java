package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service
public class DoctorMgmtServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo doctorRepo;
	@Override
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props) {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		Iterable<Doctor>it=doctorRepo.findAll(sort);
		return it ;
	}
	@Override
	public Page<Doctor> showDoctorsinfoByPageNo(int pageNO, int pageSize, boolean ascOrder, String props) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		Pageable pageable =PageRequest.of(pageNO, pageSize,sort);
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return null;
	}
	@Override
	public void showDataThroughPagination(int pageSize) {
		// TODO Auto-generated method stub
		long count=doctorRepo.count();
		long pageCount=count/pageSize;
		//pageCount=count%pageSize==0?pageCount:++pageCount;
		if(count%pageCount!=0) {
			pageCount++;
		}
		for(int i=0;i<pageCount;++i) {
			Pageable pageable=PageRequest.of(i, pageSize);
			//get each  Doctor
			Page<Doctor> page=doctorRepo.findAll(pageable);
			System.out.println("page::"+(page.getNumber()+1)+"reocords of"+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("-------------------");
		}
	}
	

	

}
