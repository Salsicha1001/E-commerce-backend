package com.ecommerceback.Repository.Localization;

import com.ecommerceback.Model.Localization.LocalizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<LocalizationModel,Long> {
}
