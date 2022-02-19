package com.ecommerceback.Service.Cards;

import com.ecommerceback.Model.Card.Response.CardsDtoResponse;
import com.ecommerceback.Model.Card.Response.CardsResponse;
import com.ecommerceback.Model.Util.ResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private RestTemplate restTemplate;
    private static final  String url_base = "https://db.ygoprodeck.com/api/v7/cardinfo.php?";

    public ResponseEntity<Page<CardsResponse>> getAllCardsPage(Integer offset,Integer num,String orderBy,String language){
        try{
            String url = url_base +"offset="+offset.toString()+"&num="+num.toString()+"&sort="+orderBy;
            if(!language.equals("")) {
                if (language.equals("fr") || language.equals("pt") || language.equals("it") || language.equals("de")) {
                    url = url + "&language=" + language;
                } else {
                    return new ResponseEntity(ResponseModel.error("No valid language set. This API accepts the following language values:" +
                            " 'fr', 'de', 'it' or 'pt' which are respectively 'French', 'German', 'Italian' or 'Portuguese'." +
                            " For English, please exclude passing language altogether."), HttpStatus.BAD_REQUEST);
                }
            }
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
/*This API accepts the following parameters: 'name', 'fname', 'desc', 'effect', 'sort',
 'sortorder', 'num', 'offset', 'type', 'atk', 'def', 'level', 'race', 'attribute', 'set',
  'rarity', 'archetype', 'set', 'banlist', 'link', 'scale', 'linkmarker', 'format', 'staple', 'misc',
 'includeAliased', 'startdate', 'enddate', 'dateregion', 'startprice', 'endprice', 'num', 'offset'."*/

}
