package JUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import MemberPack.Member;
import Verein.ClubManagement;
import Verein.MembershipList;

public class ClubTest {
	MembershipList<Integer, Member> verein = new MembershipList<Integer, Member>();
	Member eins = new Member(2, "Mustermann", "Hans", 16);
	Member zwei = new Member(6, "Koch", "Anette", 15);
	Member drei = new Member(5, "Simpson", "Bart", 9);
	Member vier = new Member(3, "Simpson", "Lisa", 5);
	Member fuenf = new Member(2, "Simpson", "Lisa", 5);
	
	@Test
	public void testClear() {
		verein.put(eins);
		verein.put(zwei);
		verein.clear();
		assertTrue(verein.size() == 0);
	}
	@Test
	public void testCloneTrue() {
		verein.put(eins);
		verein.put(zwei);
		MembershipList<Integer, Member> verein2 = (MembershipList<Integer, Member>) verein.clone();
		assertTrue(verein.equals(verein2));
	}
	
	@Test
	public void testCloneFalse() {
		verein.put(eins);
		verein.put(zwei);
		MembershipList<Integer, Member> verein2 = (MembershipList<Integer, Member>) verein.clone();
		verein.put(drei);
		assertFalse(verein.equals(verein2));
	}
	
	@Test
	public void testContainsKeyTrue() {
		verein.put(eins);
		verein.put(zwei);
		assertTrue(verein.containsKey(2));
	}
	
	@Test
	public void testContainsKeyFalse() {
		verein.put(eins);
		verein.put(zwei);
		assertFalse(verein.containsKey(6746334));
	}
	
	@Test
	public void testContainsValueTrue() {
		verein.put(eins);
		verein.put(zwei);
		assertTrue(verein.containsValue(zwei));
	}
	
	@Test
	public void testContainsValueFalse() {
		verein.put(eins);
		verein.put(zwei);
		assertFalse(verein.containsValue(drei));
	}
	
	@Test
	public void testGetTrue() {
		verein.put(eins);
		assertTrue(verein.get(2).equals(eins));
	}
	
	@Test
	public void testGetFalse() {
		verein.put(eins);
		assertFalse(verein.get(2).equals(zwei));
	}
	
	@Test
	public void testIsEmptyTrue() {
		verein.put(eins);
		verein.put(zwei);
		verein.clear();
		assertTrue(verein.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		verein.put(eins);
		verein.put(zwei);
		verein.clear();
		verein.put(eins);
		assertFalse(verein.isEmpty());
	}
	
	@Test
	public void testKeySetTrue() {
		verein.put(eins);
		verein.put(zwei);
		MembershipList<Integer, Member> verein2 = new MembershipList<Integer, Member>();
		verein2.put(eins);
		verein2.put(zwei);
		assertTrue(verein.keySet().equals(verein2.keySet()));
	}
	
	@Test
	public void testKeySetFalse() {
		verein.put(eins);
		verein.put(zwei);
		MembershipList<Integer, Member> verein2 = new MembershipList<Integer, Member>();
		verein2.put(eins);
		verein2.put(zwei);
		verein2.put(drei);
		assertFalse(verein.keySet().equals(verein2.keySet()));
	}
	
	@Test
	public void testPut() {
		verein.put(eins.getMitglieder_ID(), eins);
		assertTrue(verein.containsKey(2));	
		}
	
	@Test
	public void testSizeTrue() {
		verein.put(eins);
		verein.put(zwei);
		verein.put(drei);
		assertTrue(verein.size() == 3);
	}
	
	@Test
	public void testSizeFalse() {
		verein.put(eins);
		verein.put(zwei);
		verein.put(drei);
		assertFalse(verein.size() == 4);
	}
	
	@Test
	public void testValuesTrue() {
		verein.put(eins);
		assertTrue(verein.values().contains(eins));
	}
	
	@Test
	public void testValuesFalse() {
		verein.put(eins);
		assertFalse(verein.values().contains(zwei));
	}
	
	@Test
	public void testRemove() {
		verein.put(eins);
		verein.put(zwei);
		verein.remove(2);
		assertFalse(verein.containsKey(2));
	}
	/**
	 * Ein Member mit der ID2 wird hinzugef�gt und anschlie�end wieder gel�scht, 
	 * danach wird ein neues Mitglied mit der ID 2 hinzugef�gt
	 */
	@Test
	public void testRemoveRandfall() {
		verein.put(eins);
		verein.put(zwei);
		verein.remove(2);
		verein.put(fuenf);
		assertTrue(verein.containsKey(2));
	}
	
	@Test
	public void testPutAll() {
		verein.put(eins);
		verein.put(zwei);
		MembershipList<Integer, Member> verein2 = new MembershipList<Integer, Member>();
		verein2.putAll(verein);
		assertTrue(verein2.equals(verein));
	}
	 /**
	  * Test f�r falschen Key-Datentyp 
	  */
	 @Test
	 public void testRandfall_1() {
	  verein.put(eins);
	  verein.put(zwei);
	  assertFalse(verein.containsKey("2"));
	 }
	 /**
	  * Test f�r Keyentfernung mit falschem Datentyp
	  */
	 @Test
	 public void testRandfall_2() {
	  verein.put(eins);
	  verein.put(zwei);
	  verein.remove("2");
	  assertTrue(verein.containsKey(2));
	 }
	 /**
	  * Test f�r doppeltes einlesen
	  */
	 @Test
	 public void testRandfall_3() {
		 verein.put(eins);
		 verein.remove(2);
		 verein.put(eins);
		 verein.put(eins);
		 verein.remove(2); 
		 assertFalse(verein.containsKey(2));
	 }
	 
	 @Test
	 public void testClubManagment() {
		 ClubManagement.main(null);
	 }
}
	