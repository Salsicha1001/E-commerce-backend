package com.ecommerceback.service.impl;

import com.ecommerceback.model.dto.*;
import com.ecommerceback.utils.MessagesUtils;
import com.ecommerceback.model.Util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardServiceImpl {
    @Autowired
    private RestTemplate restTemplate;
    private static final String url_base = "https://db.ygoprodeck.com/api/v7/cardinfo.php?";
    private String url_language_base = "";
    private static final String url_language = "language=";
    private static final String url_offset = "&offset=";
    private static final String url_num = "&num=";

    private Object addLanguage(String language) {
        if (!language.equals("")) {
            if (language.equals("fr") || language.equals("pt") || language.equals("it") || language.equals("de")) {
                url_language_base = url_base + url_language + language;
            }
        } else {
            url_language_base = url_base;
        }
        return null;
    }

    public ResponseEntity<Page<CardsResumeDtoResponse>> getAllCardsPage(Integer offset, Integer num, String language) {
        try {
            addLanguage(language);
            String url = url_language_base + url_offset + offset.toString() + url_num + num.toString();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<CardsResponse> result = restTemplate.exchange(url,HttpMethod.GET,entity, CardsResponse.class);
            CardsResponse response;
            if (language.equals("pt")) {
                 response = convertPt(result.getBody());
            }else{
                response = result.getBody();
            }
            CardsResumeDtoResponse res = convertToResumeDTO(response);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<CardsResponse> getSearchCard(Integer offset, Integer num, String language, String race,
            String type,
            String archetype, String attribute, String level,
            String fname, String def, String atk) {
        try {
            addLanguage(language);
            String url = createUrl(race, type, archetype, attribute, level, fname, def, atk, offset, num);
            ;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            CardsResumeDtoResponse cards = convertToResumeDTO(result);
            return new ResponseEntity(cards, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    private String createUrl(String race, String type,
            String archetype, String attribute, String level,
            String fname, String def, String atk, Integer offset, Integer num) {
        String url = url_language_base;
        if (!race.equals("")) {
            url = url + "&race=" + race;
        }
        if (!type.equals("")) {
            url = url + "&type=" + type;
        }
        if (!archetype.equals("")) {
            url = url + "&archetype=" + archetype;
        }
        if (!attribute.equals("")) {
            url = url + "&attribute=" + attribute;
        }
        if (!level.equals("")) {
            url = url + "&level=" + level;
        }
        if (!fname.equals("")) {
            url = url + "&fname=" + fname;
        }
        if (!def.equals("")) {
            url = url + "&def=" + def;
        }
        if (!atk.equals("")) {
            url = url + "&atk=" + atk;
        }
        url = url + url_offset + offset.toString() + url_num + num.toString();
        return url;

    }

    public ResponseEntity<?> getCardByName(String language, String name) {
        addLanguage(language);
        try {
            String url = url_language_base + "&name=" + name;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            if (language.equals("pt")) {
                result = convertPt(result);
            }
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAllCardsArctype(String archetype, String language) {
        try {
            addLanguage(language);
            String url = url_language_base + "&archetype=" + archetype;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            CardsResumeDtoResponse cards = convertToResumeDTO(result);
            return new ResponseEntity(cards, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    private CardsResumeDtoResponse convertToResumeDTO(CardsResponse cardsResponse) {
        CardsResumeDtoResponse result = new CardsResumeDtoResponse();
        result.setMeta(cardsResponse.getMeta());
        List<CardResumeResponse> tmp = new ArrayList<>();
        for (CardsDtoResponse response : cardsResponse.getData()) {
            tmp.add(new CardResumeResponse(response.getId(),
                    response.getName(),
                    response.getCardImages().get(0).getImageUrlSmall(), response.getArchetype()));
        }
        result.setData(tmp);
        return result;
    }

    private CardsResponse convertPt(CardsResponse cardsResponse) {
        CardsResponse response = new CardsResponse();
        response.setMeta(cardsResponse.getMeta());
        List<CardsDtoResponse> tmp = new ArrayList<>();
        for (CardsDtoResponse res : cardsResponse.getData()) {
            res.setRace(MessagesUtils.getMessages(res.getRace(),1));
            res.setType(MessagesUtils.getMessages(res.getType(),2));
            res.setAttribute(MessagesUtils.getMessages(res.getAttribute(),3));
            tmp.add(res);
         }
        response.setData(tmp);
        return response;
    }
}
