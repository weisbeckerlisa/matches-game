package allumettes;
import org.junit.*;
import static org.junit.Assert.*;

public class StrategieRapideTest {
	
	public final static double EPSILON = 0.001;
	
	private Strategie strat;
	
	@Before
	public void setUp() {
		this.strat = new StrategieRapide();
	}
	
	@Test
	public void test1() throws CoupInvalideException {
		JeuDesAllumettes jeu_13 = new JeuDesAllumettes(13);
		assertEquals(this.strat.getPrise(jeu_13), 3, EPSILON);
		jeu_13.retirer(this.strat.getPrise(jeu_13));
		assertEquals(this.strat.getPrise(jeu_13), 3, EPSILON);
		jeu_13.retirer(this.strat.getPrise(jeu_13));
		assertEquals(this.strat.getPrise(jeu_13), 3, EPSILON);
		jeu_13.retirer(this.strat.getPrise(jeu_13));
		assertEquals(this.strat.getPrise(jeu_13), 3, EPSILON);
		jeu_13.retirer(this.strat.getPrise(jeu_13));
		assertEquals(this.strat.getPrise(jeu_13), 1, EPSILON);
	}
	
	@Test
	public void test2() throws CoupInvalideException {
		JeuDesAllumettes jeu_12 = new JeuDesAllumettes(12);
		assertEquals(this.strat.getPrise(jeu_12), 3, EPSILON);
		jeu_12.retirer(this.strat.getPrise(jeu_12));
		assertEquals(this.strat.getPrise(jeu_12), 3, EPSILON);
		jeu_12.retirer(this.strat.getPrise(jeu_12));
		assertEquals(this.strat.getPrise(jeu_12), 3, EPSILON);
		jeu_12.retirer(this.strat.getPrise(jeu_12));
		assertEquals(this.strat.getPrise(jeu_12), 3, EPSILON);
	}
	
	@Test
	public void test3() throws CoupInvalideException {
		JeuDesAllumettes jeu_14 = new JeuDesAllumettes(14);
		assertEquals(this.strat.getPrise(jeu_14), 3, EPSILON);
		jeu_14.retirer(this.strat.getPrise(jeu_14));
		assertEquals(this.strat.getPrise(jeu_14), 3, EPSILON);
		jeu_14.retirer(this.strat.getPrise(jeu_14));
		assertEquals(this.strat.getPrise(jeu_14), 3, EPSILON);
		jeu_14.retirer(this.strat.getPrise(jeu_14));
		assertEquals(this.strat.getPrise(jeu_14), 3, EPSILON);
		jeu_14.retirer(this.strat.getPrise(jeu_14));
		assertEquals(this.strat.getPrise(jeu_14), 2, EPSILON);
	}
}
