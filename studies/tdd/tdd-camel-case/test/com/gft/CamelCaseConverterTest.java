package com.gft;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamelCaseConverterTest {

	private CamelCaseConverter camelCase;

	@BeforeEach
	public void setup() throws Exception {
		camelCase = new CamelCaseConverter();
	}

	@Test
	void deveConverterNomeSimples() throws Exception {
		assertEquals("Lionel", camelCase.converter("lionel"));
	}

	@Test
	void deveConveterNomeMisturado() throws Exception {
		assertEquals("Lionel", camelCase.converter("lIOnEl"));
	}

}
