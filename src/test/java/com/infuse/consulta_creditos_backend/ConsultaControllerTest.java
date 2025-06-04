package com.infuse.consulta_creditos_backend;
import com.infuse.consulta_creditos_backend.controllers.ConsultaController;
import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.services.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConsultaController.class)
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService creditoService;  // usar @MockBean mesmo se está deprecated

    private final CreditoDto creditoDto1 = CreditoDto.builder()
            .numeroCredito("123")
            .nfse("NFSE1")
            .build();

    private final CreditoDto creditoDto2 = CreditoDto.builder()
            .numeroCredito("456")
            .nfse("NFSE2")
            .build();

    @Test
    public void testGetAllCreditos() throws Exception {
        List<CreditoDto> lista = List.of(creditoDto1, creditoDto2);

        when(creditoService.getCreditosAll()).thenReturn(lista);

        mockMvc.perform(get("/api/creditos")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("dan", "123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].numeroCredito", is("123")))
                .andExpect(jsonPath("$[1].numeroCredito", is("456")));
    }

    @Test
    public void testGetCreditosByNumeroNfse() throws Exception {
        List<CreditoDto> lista = List.of(creditoDto1);

        when(creditoService.getCreditosByNfse(anyString())).thenReturn(lista);

        mockMvc.perform(get("/api/creditos/NFSE1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("dan", "123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nfse", is("NFSE1")));
    }

    @Test
    public void testGetCreditoByNumeroCredito() throws Exception {
        when(creditoService.getCreditoByNumero(anyString())).thenReturn(creditoDto1);

        mockMvc.perform(get("/api/credito/123")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("dan", "123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroCredito", is("123")));
    }
}
