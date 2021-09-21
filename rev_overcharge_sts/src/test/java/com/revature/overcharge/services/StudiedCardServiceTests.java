package com.revature.overcharge.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.StudiedCard;
import com.revature.overcharge.beans.StudiedCardId;
import com.revature.overcharge.repositories.StudiedCardRepo;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class StudiedCardServiceTests {

	@Autowired
	public StudiedCardService scs;
	@MockBean
	StudiedCardRepo scr;

// 	@Test
// 	void testAddStudiedCard() {
// 		StudiedCard studiedcard = new StudiedCard(0, 0, null);

// 		Mockito.when(scr.save(studiedcard)).thenReturn(new StudiedCard(0, 0, null));
// 		studiedcard = scs.addStudiedCard(studiedcard);

// 		Assertions.assertEquals(0, studiedcard.getCardId());
// 		Assertions.assertEquals(0, studiedcard.getUserId());
// 		Assertions.assertNotEquals(1, studiedcard.getCardId());
// 		Assertions.assertNotEquals(1, studiedcard.getUserId());
// 	}

	@Test
	@Transactional
	void testGetStudiedCards() {
		StudiedCard studiedcard = new StudiedCard(0, 0, null);
		List<StudiedCard> list = new ArrayList<StudiedCard>();
		list.add(studiedcard);

		Mockito.when(scr.findAll()).thenReturn(list);

		Assertions.assertNotNull(list);
	}

//	@Test
//	@Transactional
//	void testDeleteStudiedCard() {
//		StudiedCard studiedcard = new StudiedCard(0, 0, null);
//		StudiedCardId studiedcardid = new StudiedCardId(studiedcard.getCardId(), studiedcard.getUserId());
//
//		Mockito.when(scr.existsById(studiedcardid)).thenReturn(true);
//
//		Assertions.assertEquals(scs.deleteStudiedCard(studiedcardid), true);
//	}
//
}
