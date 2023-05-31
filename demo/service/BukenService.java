package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Buken;
import com.example.demo.obj.BukenDto;
import com.example.demo.repository.BukenRepository;

@Service
public class BukenService {

	// 物件公開一覧
	@Autowired
	private BukenRepository bukenRepository;

	public List<BukenDto> searchAll() {
		List<Buken> bukenList = bukenRepository.findAll(Sort.by(Order.asc("propertyId")));
		List<BukenDto> bukenDtoList = new ArrayList<>();

		for (Buken buken : bukenList) {
			BukenDto bukenDto = convertToDto(buken);
			bukenDtoList.add(bukenDto);
		}

		return bukenDtoList;
	}

	private BukenDto convertToDto(Buken buken) {
		Long id = buken.getPropertyId();
		String name = buken.getPropertyName();
		String address = buken.getAddress();
		String propertyType = buken.getPropertyType();
		Date period = buken.getPeriod();
		String propertyArea = buken.getPropertyArea();
		String price = buken.getPrice();
		String syozokuCompanyId = buken.getSyozokuCompanyId();
		String status = buken.getStatus();
		String imagePath = buken.getImagePath();
		return new BukenDto(id, name, address, propertyType, period, propertyArea, price, syozokuCompanyId, status, imagePath);
	}

	// 物件非公開一覧

	public List<BukenDto> searchBukenHikoukei() {
		List<Buken> bukenList = bukenRepository.findByStatusContainingOrderByPropertyId("なし");

		List<BukenDto> bukenDtoList = new ArrayList<>();

		for (Buken buken : bukenList) {
			BukenDto bukenDto = convertToDto(buken);
			bukenDtoList.add(bukenDto);
		}

		return bukenDtoList;
	}

	private BukenDto convertToDtohikoukei(Buken buken) {
		Long id = buken.getPropertyId();
		String name = buken.getPropertyName();
		String address = buken.getAddress();
		String propertyType = buken.getPropertyType();
		Date period = buken.getPeriod();
		String propertyArea = buken.getPropertyArea();
		String price = buken.getPrice();
		String syozokuCompanyId = buken.getSyozokuCompanyId();
		String status = buken.getStatus();
		String imagePath = buken.getImagePath();
		return new BukenDto(id, name, address, propertyType, period, propertyArea, price, syozokuCompanyId, status, imagePath);
	}

	// 新規の保存

	public Buken saveBuken(Buken buken) {
		// BukenRepository を使って、DBに保存する
		return bukenRepository.save(buken);
	}

	// 検索

	public List<BukenDto> searchById(Long propertyId) {
		List<Buken> bukenList;

		if (propertyId != null) {
			bukenList = bukenRepository.findByPropertyId(propertyId);
		} else {
			bukenList = bukenRepository.findAll(Sort.by(Order.asc("propertyId")));
		}

		List<BukenDto> bukenDtoList = new ArrayList<>();
		for (Buken buken : bukenList) {
			BukenDto bukenDto = convertToDto(buken);
			bukenDtoList.add(bukenDto);
		}

		return bukenDtoList;
	}
	
	//期間検索
	public List<Buken> searchByPeriod(Date fromdate, Date todate) {
	    return bukenRepository.findByPeriodBetweenOrderByPeriod(fromdate, todate);
	}



	// 検索
	// 构造函数注入BukenRepository
	public BukenService(BukenRepository bukenRepository) {
		this.bukenRepository = bukenRepository;
	}

	public List<Buken> searchByUidValue(Long propertyId) {
		return bukenRepository.findByPropertyId(propertyId);
	}

	// 削除
	public void deleteBuken(Long id) {
		bukenRepository.deleteById(id);
	}

	// 編集
	public void updateBuken(BukenDto bukenDto) {
		Long propertyId = bukenDto.getPropertyId();
		Optional<Buken> optionalBuken = bukenRepository.findById(propertyId);
		if (optionalBuken.isPresent()) {
			Buken buken = optionalBuken.get();
			// 更新Buken对象的属性
			buken.setPropertyName(bukenDto.getPropertyName());
			buken.setAddress(bukenDto.getAddress());
			buken.setPropertyType(bukenDto.getPropertyType());
			buken.setPeriod(bukenDto.getPeriod());
			buken.setPropertyArea(bukenDto.getPropertyArea());
			buken.setPrice(bukenDto.getPrice());
			buken.setSyozokuCompanyId(bukenDto.getSyozokuCompanyId());
			buken.setStatus(bukenDto.getStatus());
			buken.setImagePath(bukenDto.getImagePath());
			bukenRepository.save(buken);
		} else {
			throw new NotFoundException("Buken not found with ID: " + propertyId);
		}
	}

	public BukenDto getBukenById(Long propertyId) {
		Optional<Buken> optionalBuken = bukenRepository.findById(propertyId);
		if (optionalBuken.isPresent()) {
			Buken buken = optionalBuken.get();
			return convertToDto(buken);
		} else {
			throw new NotFoundException("Buken not found with ID: " + propertyId);
		}
	}

}
