package com.doctorhere.base.profession.repository;

import com.doctorhere.base.profession.model.Profession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    @Query(value="select p from Profession p where p.id=:id and p.deleted = false")
    Optional<Profession> findByIdAndDeletedFalse(@Param("id") Long id);
    @Query(value="select p from Profession p  where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%')) and (p.parent.id = :parent)",
            countQuery = "select count(p) from Profession p where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%'))  and ( p.parent.id = :parent)" )
    Page<Profession> findAllChildPageable(@Param("status") Boolean status,
                                     Pageable request,
                                     @Param("name") String name,
                                     @Param("parent") Long parent );

    @Query(value="select p from Profession p  where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%'))  and (p.parent.id = :parent )")
    List<Profession> findAllChildList(@Param("status") Boolean status,
                                 Sort sort,
                                 @Param("name") String name,
                                 @Param("parent") Long parent);

    @Query(value="select p from Profession p  where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%')) and ( p.parent IS NULL )",
            countQuery = "select count(p) from Profession p where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%'))  and ( p.parent IS NULL)" )
    Page<Profession> findAllParentPageable(@Param("status") Boolean status,
                                          Pageable request,
                                          @Param("name") String name);

    @Query(value="select p from Profession p  where (:status is null or p.status = :status) and lower(p.name) like lower(concat('%', :name,'%'))  and ( p.parent IS NULL )")
    List<Profession> findAllParentList(@Param("status") Boolean status,
                                      Sort sort,
                                      @Param("name") String name);
}
