package com.ecommerceback.Service.Cards;

import com.ecommerceback.Model.Card.Response.CardResume;
import com.ecommerceback.Model.Card.Response.CardsResumeDtoResponse;
import com.ecommerceback.Model.Card.Response.CardsDtoResponse;
import com.ecommerceback.Model.Card.Response.CardsResponse;
import com.ecommerceback.Model.Util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class CardService {
    @Autowired
    private RestTemplate restTemplate;
    private static final String url_base = "https://db.ygoprodeck.com/api/v7/cardinfo.php?";
    private  String url_language_base="";
    private static final String url_language="language=";
    private static final String url_offset="&offset=";
    private static final String url_num="&num=";

    private Object addLanguage(String language){
            if (!language.equals("")) {
                if (language.equals("fr") || language.equals("pt") || language.equals("it") || language.equals("de")) {
                    url_language_base = url_base + url_language + language;
                } else {
                    return new ResponseEntity(ResponseModel.error("No valid language set. This API accepts the following language values:" +
                            " 'fr', 'de', 'it' or 'pt' which are respectively 'French', 'German', 'Italian' or 'Portuguese'." +
                            " For English, please exclude passing language altogether."), HttpStatus.BAD_REQUEST);
                }
            }else{
                url_language_base = url_base;
            }
            return null;
    }


    public ResponseEntity<Page<CardsResponse>> getAllCardsPage(Integer offset,Integer num,String language){
        try{
            addLanguage(language);
            String url = url_language_base +url_offset+offset.toString()+url_num+num.toString();
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Page<CardsResponse>> getSearchCard(Integer offset, Integer num,String language,String race,String type,
                                                             String archetype, String attribute,String level,
                                                             String fname,String def,String atk){
        try{
            addLanguage(language);
            String url = createUrl(race,type,archetype,attribute,level,fname,def,atk, offset, num);;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getRandomCardHome(String language){
        Random r=new Random();
        List<CardsDtoResponse> res = new ArrayList<CardsDtoResponse>();
        try{
            if(language.equals("pt") || language.equals("it")){
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(10436));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    res.add(result.getData().get(0));
                }
                return new ResponseEntity(res,HttpStatus.OK);

            }else if(language.equals("de")||language.equals("fr")){
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(11380));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    res.add(result.getData().get(0));
                }
                return new ResponseEntity(res,HttpStatus.OK);
            }else{
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(11796));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    res.add(result.getData().get(0));
                }
                return new ResponseEntity(res,HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    private String createUrl(String race,String type,
                             String archetype, String attribute,String level,
                             String fname,String def,String atk,Integer offset, Integer num){
        String url = url_language_base;
        if(!race.equals("")){
            url = url+"&race="+race;
        } if(!type.equals("")){
            url = url+"&type="+type;
        }
        if(!archetype.equals("")){
            url = url+"&archetype="+archetype;
        }if(!attribute.equals("")) {
            url = url + "&attribute=" + attribute;
        }if(!level.equals("")){
            url = url+"&level="+level;
        }if(!fname.equals("")){
            url = url+"&fname="+fname;
        }if(!def.equals("")){
            url = url+"&def="+def;
        }
        if(!atk.equals("")){
            url = url+"&atk="+atk;
        }
        url = url +url_offset+offset.toString()+url_num+num.toString();
        return url;

    }

/*This API accepts the following parameters: 'name', 'fname', 'desc', 'effect', 'sort',
 'sortorder', 'num', 'offset', 'type', 'atk', 'def', 'level', 'race', 'attribute', 'set',
  'rarity', 'archetype', 'set', 'banlist', 'link', 'scale', 'linkmarker', 'format', 'staple', 'misc',
 'includeAliased', 'startdate', 'enddate', 'dateregion', 'startprice', 'endprice', 'num', 'offset'."*/


    public ResponseEntity<?> getCardByName(String language,String name){
        addLanguage(language);
        try{
            String url = url_language_base+"&name="+name;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<?> getCardByID(String language,Long id){
        addLanguage(language);
        try{
            String url = url_language_base+"&id="+id;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAllCardsResumePage(Integer offset, Integer num, String language) {
        try{
            addLanguage(language);
            String url = url_language_base +url_offset+offset.toString()+url_num+num.toString();
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            CardsResumeDtoResponse cards = convertToResumeDTO(result);
            return new ResponseEntity(cards,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    private CardsResumeDtoResponse convertToResumeDTO(CardsResponse cardsResponse){
        CardsResumeDtoResponse result = new CardsResumeDtoResponse();
        result.setMeta(cardsResponse.getMeta());
        List<CardResume> tmp = new ArrayList<>();
        for(CardsDtoResponse response: cardsResponse.getData()){
            tmp.add(new CardResume(response.getId(),
                    response.getName(),
                    response.getCard_images().get(0).getImage_url_small()));
        }
        result.setData(tmp);
        return result;
    }
}
