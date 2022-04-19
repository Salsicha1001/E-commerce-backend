package com.ecommerceback.Repository.Preferences;

import java.util.List;

import com.ecommerceback.Model.Preferences.PreferencesModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<PreferencesModel, Long> {
    @Query(value = "SELECT * FROM PREFERENCES_MODEL WHERE ID_USER=:id ",nativeQuery = true)
    PreferencesModel findByUser(@Param("id")Long id);







}
