package Aplication.damir.Controller;

import Aplication.damir.service.ExchangeRatesService;
import Aplication.damir.service.GifService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @MockBean
    private GifService gifService;
    @MockBean
    private ExchangeRatesService exchangeRatesService;

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRatesCodesOfTrue() throws Exception {
        List<String> responseList = new ArrayList<>();
        responseList.add("TEST");
        Mockito.when(exchangeRatesService.getRatesCodes())
                .thenReturn(responseList);
        mockMvc.perform(get("/api/getcodes")
                        .content(mapper.writeValueAsString(responseList))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0]").value("TEST"));
    }

    @Test
    public void getRatesCodesIsNull() throws Exception {
        Mockito.when(exchangeRatesService.getRatesCodes())
                .thenReturn(null);
        mockMvc.perform(get("/api/getcodes")
                        .content(mapper.writeValueAsString(null))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0]").doesNotExist());
    }

    @Test
    public void getGifRich() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("tag", "rich");
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(map, HttpStatus.OK);

        Mockito.when(gifService.getRandomGif(exchangeRatesService.compareRatesResult("rich")))
                .thenReturn(responseEntity);
        mockMvc.perform(get("/api/getgif/TEST")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.tag").value("rich"));
    }

    @Test
    public void getGifBroke() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("tag", "broke");
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
        Mockito.when(gifService.getRandomGif(exchangeRatesService.compareRatesResult("broke")))
                .thenReturn(responseEntity);
        mockMvc.perform(get("/api/getgif/TEST")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.tag").value("broke"));
    }
}