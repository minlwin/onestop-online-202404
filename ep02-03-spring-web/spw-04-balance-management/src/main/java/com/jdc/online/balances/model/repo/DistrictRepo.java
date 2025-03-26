package com.jdc.online.balances.model.repo;

import java.util.List;

import com.jdc.online.balances.model.BaseRepository;
import com.jdc.online.balances.model.entity.District;

public interface DistrictRepo extends BaseRepository<District, Integer>{

	List<District> findByRegionId(int regionId);

}
