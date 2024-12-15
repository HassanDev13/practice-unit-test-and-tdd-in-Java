package com.tp.tp5;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.tp.tp5.exception.ErreurPersistance;
import com.tp.tp5.exception.TooMuchResultException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

public class ProgrammeVoitureTest {

    @InjectMocks
    private ProgrammeVoiture programmeVoiture;

    @Mock
    private IPersistanceModeleVoiture mockPersistance;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        programmeVoiture.setPersistance(mockPersistance);
    }

    /**
     * Test: Rechercher une voiture par marque avec des résultats.
     */
    @Test
    public void testRechercherVoitureParMarque_Success() {
        String marque = "Peugeot";
        List<ModeleVoiture> voitures = Arrays.asList(
            new ModeleVoiture(1L, "Peugeot", "208", 2022L, 20000L),
            new ModeleVoiture(2L, "Peugeot", "308", 2023L, 25000L)
        );

        when(mockPersistance.searchModeleVoiture(any())).thenReturn(voitures);

        List<ModeleVoiture> result = programmeVoiture.rechercherVoitureParMarque(marque);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(mockPersistance, times(1)).searchModeleVoiture(any());
    }

    /**
     * Test: Rechercher une voiture par marque sans résultats.
     */
    @Test
    public void testRechercherVoitureParMarque_NoResults() {
        String marque = "Ferrari";
        List<ModeleVoiture> voitures = Collections.emptyList();

        when(mockPersistance.searchModeleVoiture(any())).thenReturn(voitures);

        List<ModeleVoiture> result = programmeVoiture.rechercherVoitureParMarque(marque);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

  
  
    /**
     * Test: Enregistrer un modèle en insertion (sans ID).
     */
    @Test
    public void testEnregisterModeleVoiture_Insert() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture(null, "Toyota", "Yaris", 2022L, 15000L);

        when(mockPersistance.addModeleVoiture(any())).thenReturn(true);

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertTrue(result);
        verify(mockPersistance, times(1)).addModeleVoiture(any());
    }

    /**
     * Test: Enregistrer un modèle en mise à jour avec succès.
     */
    @Test
    public void testEnregisterModeleVoiture_Update() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture(1L, "Ford", "Focus", 2021L, 17000L);

        when(mockPersistance.updateModeleVoiture(any())).thenReturn(true);

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertTrue(result);
        verify(mockPersistance, times(1)).updateModeleVoiture(any());
    }

    /**
     * Test: Enregistrer un modèle avec exception ErreurPersistance.
     */
    @Test
    public void testEnregisterModeleVoiture_ErreurPersistance() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture(null, "Peugeot", "208", 2022L, 20000L);

        when(mockPersistance.addModeleVoiture(any())).thenThrow(new ErreurPersistance("Database error"));

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertFalse(result);
        verify(mockPersistance, times(1)).addModeleVoiture(any());
    }
}
