package com.doctorhere.base.profession.service;

import com.doctorhere.base.profession.model.Profession;
import com.doctorhere.base.profession.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionService {
	private final ProfessionRepository professionRepository;

	@Transactional
	public Profession save(Profession profession) {
		return professionRepository.save(profession);
	}
    @Transactional
	public Profession update(Profession profession) {
		return professionRepository.save(profession);
	}
    @Transactional
	public void delete(Profession profession) {
		professionRepository.delete(profession);
	}
 

	public Optional<Profession> findByIdAndDeletedFalse(long id) {
		return professionRepository.findByIdAndDeletedFalse(id);
	}

    public Page<Profession> findAllPageable(Integer pageNumber, Integer pageSize, String sortingDirection, String sortingName, String name, Boolean status, Long parentId, Boolean parents) {
        Sort.Direction direction;
        if (sortingDirection.equals("ASC")) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        if(parents){
            return professionRepository.findAllParentPageable(status,PageRequest.of(pageNumber - 1, pageSize, Sort.by(direction, sortingName)),name);
        }else{
            return professionRepository.findAllChildPageable(status,PageRequest.of(pageNumber - 1, pageSize, Sort.by(direction, sortingName)),name,parentId);
        }

    }

    public List<Profession> findAllList(String sortingDirection, String sortingName, Boolean status, String name,Long parentId,Boolean parents) {
        Sort.Direction direction;
        if (sortingDirection.equals("ASC")) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        if(parents){
            return professionRepository.findAllParentList(status, Sort.by(direction, sortingName),name);
        }else{
            return professionRepository.findAllChildList(status, Sort.by(direction, sortingName),name,parentId);
        }
    }

}
