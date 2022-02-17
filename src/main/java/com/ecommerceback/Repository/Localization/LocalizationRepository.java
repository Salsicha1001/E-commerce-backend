package com.ecommerceback.Repository.Localization;

import com.ecommerceback.Model.Localization.LocalizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LocalizationRepository extends JpaRepository<LocalizationModel,Long> {
    @Query(value = "SELECT * FROM LOCALIZATION_MODEL WHERE ID_USER=:id ",nativeQuery = true)
    List<LocalizationModel> findAllByUser(@Param("id")Long id);
}
