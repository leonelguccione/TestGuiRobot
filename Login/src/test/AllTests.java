package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ GuiTestConjuntoVacio.class, GuiTestConjuntoConDatos.class, GuiTestEnabledDisabled.class })
public class AllTests {
}
