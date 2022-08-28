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
            if(language.equals("pt")){
                result = convertPt(result);
            }
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<CardsResponse> getSearchCard(Integer offset, Integer num,String language,String race,String type,
                                                             String archetype, String attribute,String level,
                                                             String fname,String def,String atk){
        try{
            addLanguage(language);
            String url = createUrl(race,type,archetype,attribute,level,fname,def,atk, offset, num);;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            CardsResumeDtoResponse cards = convertToResumeDTO(result);
            return new ResponseEntity(cards,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getRandomCardHome(String language){
        Random r=new Random();
        List<CardResume> res = new ArrayList<CardResume>();
        try{
            if(language.equals("pt") || language.equals("it")){
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(10436));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    if(language.equals("pt")){
                        result = convertPt(result);
                    }
                    CardsResumeDtoResponse cards = convertToResumeDTO(result);
                    res.add(cards.getData().get(0));
                }
                return new ResponseEntity(res,HttpStatus.OK);

            }else if(language.equals("de")||language.equals("fr")){
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(11380));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    CardsResumeDtoResponse cards = convertToResumeDTO(result);
                    res.add(cards.getData().get(0));
                }
                return new ResponseEntity(res,HttpStatus.OK);
            }else{
                for(int i =0;i < 10;i++){
                    String a = String.valueOf(r.nextInt(11796));
                    addLanguage(language);
                    String url = url_language_base +url_offset+a+url_num+'1';
                    CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
                    CardsResumeDtoResponse cards = convertToResumeDTO(result);
                    res.add(cards.getData().get(0));
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

    public ResponseEntity<?> getCardByName(String language,String name){
        addLanguage(language);
        try{
            String url = url_language_base+"&name="+name;
            CardsResponse result = restTemplate.getForObject(url, CardsResponse.class);
            if(language.equals("pt")){
            result = convertPt(result);
            }
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(ResponseModel.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAllCardsArctype(String archetype, String language) {
        try{
            addLanguage(language);
            String url = url_language_base+"&archetype="+archetype; ;
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
                    response.getCard_images().get(0).getImage_url_small(), response.getArchetype()));
        }
        result.setData(tmp);
        return result;
    }
    private CardsResponse convertPt(CardsResponse cardsResponse){
        CardsResponse response = new CardsResponse();
        response.setMeta(cardsResponse.getMeta());
        List<CardsDtoResponse> tmp = new ArrayList<>();
        for(CardsDtoResponse res:cardsResponse.getData()){
            res.setRace(setPtRace(res.getRace()));
            res.setType(setPtType(res.getType()));
            res.setAttribute(setPtAtribute(res.getAttribute()));
            tmp.add(res);
        }
        response.setData(tmp);
        return response;
    }


    private String setPtRace(String msg){
        if(msg!=null) {

            switch (msg) {
                    case "Aqua":
                        msg = "Água";
                        break;
                    case "Beast":
                        msg = "Fera";
                        break;
                    case "Beast-Warrior":
                        msg = "Besta-Guerreira";
                        break;
                    case "Creator-God":
                        msg = "Deus-Criador";
                        break;
                    case "Cyberse":
                        msg = "Cyberso";
                        break;
                    case "Dinosaur":
                        msg = "Dinossauro";
                        break;
                    case "Fairy":
                        msg = "Fada";
                        break;
                    case "Divine-Beast":
                        msg = "Besta Divina";
                        break;
                    case "Dragon":
                        msg = "Dragão";
                        break;
                    case "Fiend":
                        msg = "Demônio";
                        break;
                    case "Fish":
                        msg = "Peixe";
                        break;
                    case "Insect":
                        msg = "Inseto";
                        break;
                    case "Machine":
                        msg = "Máquina";
                        break;
                    case "Plant":
                        msg = "Planta";
                        break;
                    case "Psychic":
                        msg = "Psíquico";
                        break;
                    case "Pyro":
                        msg = "Pyro";
                        break;
                    case "Reptile":
                        msg = "Réptil";
                        break;
                    case "Rock":
                        msg = "Rocha";
                        break;
                    case "Sea Serpent":
                        msg = "Serpente do mar";
                        break;
                    case "Spellcaster":
                        msg = "Feiticeiro";
                        break;
                    case "Thunder":
                        msg = "Trovão";
                        break;
                    case "Warrior":
                        msg = "Guerreiro";
                        break;
                    case "Winged Beast":
                        msg = "Besta Alada";
                        break;
                    case "Normal":
                        msg = "Normal";
                        break;
                    case "Field":
                        msg = "Campo";
                        break;
                    case "Equip":
                        msg = "Equipamento";
                        break;
                    case "Continuous":
                        msg = "Contínuo";
                        break;
                    case "Quick-Play":
                        msg = "Magia Rápida";
                        break;
                    case "Ritual":
                        msg = "Ritual";
                        break;
                    case "Counter":
                        msg = "Resposta";
                        break;
                    default:
                        break;
                }
            }
           return msg;
    }
    private String setPtType(String msg){
        if(msg!=null) {

            switch (msg) {
                case "Effect Monster":
                    msg = "Monstro de Efeito";
                    break;
                case "Flip Effect Monster":
                    msg = "Monstro Efeito Virar";
                    break;
                case "Flip Tuner Effect Monster":
                    msg = "Monstro de Efeito Flip Tuner";
                    break;
                case "Gemini Monster":
                    msg = "Monstro de Gêmeos";
                    break;
                case "Normal Monster":
                    msg = "Monstro Normal";
                    break;
                case "Normal Tuner Monster":
                    msg = "Monstro Regulador Normal";
                    break;
                case "Pendulum Effect Monster":
                    msg = "Monstro Efeito Pêndulo";
                    break;
                case "Pendulum Flip Effect Monster":
                    msg = "Monstro Efeito Pêndulo Virar";
                    break;
                case "Pendulum Normal Monster":
                    msg = "Monstro Normal Pêndulo";
                    break;
                case "Pendulum Tuner Effect Monster":
                    msg = "Monstro Efeito Regulador Pêndulo";
                    break;
                case "Ritual Effect Monster":
                    msg = "Monstro de Efeito Ritual";
                    break;
                case "Ritual Monster":
                    msg = "Monstro Ritual";
                    break;
                case "Skill Card":
                    msg = "Cartão de Habilidade";
                    break;
                case "Spell Card":
                    msg = "Carta de Magia";
                    break;
                case "Spirit Monster":
                    msg = "Monstro Espiritual";
                    break;
                case "Toon Monster":
                    msg = "Monstro Toon";
                    break;
                case "Trap Card":
                    msg = "Carta Armadilha";
                    break;
                case "Tuner Monster":
                    msg = "Monstro Regulador";
                    break;
                case "Union Effect Monster":
                    msg = "Monstro Efeito União";
                    break;
                case "Fusion Monster":
                    msg = "Monstro de Fusão";
                    break;
                case "Link Monster":
                    msg = "Monstro Link";
                    break;
                case "Pendulum Effect Fusion Monster":
                    msg = "Monstro de Fusão Efeito Pêndulo";
                    break;
                case "Synchro Monster":
                    msg = "Monstro Sincro";
                    break;
                case "Synchro Pendulum Effect Monster":
                    msg = "Monstro Efeito Pêndulo Sincro";
                    break;
                case "Synchro Tuner Monster":
                    msg = "Monstro Regulador Sincro";
                    break;
                case "XYZ Monster":
                    msg = "Monstro XYZ";
                    break;
                case "XYZ Pendulum Effect Monster":
                    msg = "Monstro de Efeito Pêndulo XYZ";
                    break;
                default:
                    break;
            }
        }
        return msg;
    }
    private String setPtAtribute(String msg){
        if(msg!=null) {
            switch (msg) {
                case "DARK":
                    msg = "Trevas";
                    break;
                case "EARTH":
                    msg = "Terra";
                    break;
                case "FIRE":
                    msg = "Fogo";
                    break;
                case "LIGHT":
                    msg = "Luz";
                    break;
                case "WATER":
                    msg = "Água";
                    break;
                case "WIND":
                    msg = "Vento";
                    break;
                case "DIVINE":
                    msg = "Divino";
                    break;
                default:
                    msg = null;
                    break;
            }
        }
        return msg;
    }
}
