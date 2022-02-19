package com.ecommerceback.Model.Card.Response;

import java.util.ArrayList;
import java.util.List;

public class CardsDtoResponse {
    private Long id;
    private String name;
    private String type;
    private String desc;
    private String race;
    private String archetype;
    private long atk;
    private long def;
    private long level;
    private String attribute;
    private long linkval;
    private List<String> linkmarkers;
    private long scale;
    private List<CardSetsDtoResponse> card_sets = new ArrayList<>();
    private List<CardsImagesDtoResponse> card_images = new ArrayList<>();
    private List<CardsPricesDtoResponse> card_prices = new ArrayList<>();

    public CardsDtoResponse() {
    }

    public CardsDtoResponse(Long id, String name, String type, String desc, String race, String archetype, long atk, long def, long level, String attribute, long linkval, List<String> linkmarkers, long scale, List<CardSetsDtoResponse> card_sets, List<CardsImagesDtoResponse> card_images, List<CardsPricesDtoResponse> card_prices) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.race = race;
        this.archetype = archetype;
        this.atk = atk;
        this.def = def;
        this.level = level;
        this.attribute = attribute;
        this.linkval = linkval;
        this.linkmarkers = linkmarkers;
        this.scale = scale;
        this.card_sets = card_sets;
        this.card_images = card_images;
        this.card_prices = card_prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public long getAtk() {
        return atk;
    }

    public void setAtk(long atk) {
        this.atk = atk;
    }

    public long getDef() {
        return def;
    }

    public void setDef(long def) {
        this.def = def;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public long getLinkval() {
        return linkval;
    }

    public void setLinkval(long linkval) {
        this.linkval = linkval;
    }

    public List<String> getLinkmarkers() {
        return linkmarkers;
    }

    public void setLinkmarkers(List<String> linkmarkers) {
        this.linkmarkers = linkmarkers;
    }

    public long getScale() {
        return scale;
    }

    public void setScale(long scale) {
        this.scale = scale;
    }

    public List<CardSetsDtoResponse> getCard_sets() {
        return card_sets;
    }

    public void setCard_sets(List<CardSetsDtoResponse> card_sets) {
        this.card_sets = card_sets;
    }

    public List<CardsImagesDtoResponse> getCard_images() {
        return card_images;
    }

    public void setCard_images(List<CardsImagesDtoResponse> card_images) {
        this.card_images = card_images;
    }

    public List<CardsPricesDtoResponse> getCard_prices() {
        return card_prices;
    }

    public void setCard_prices(List<CardsPricesDtoResponse> card_prices) {
        this.card_prices = card_prices;
    }
}
