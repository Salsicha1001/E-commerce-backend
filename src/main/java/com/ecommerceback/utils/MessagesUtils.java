package com.ecommerceback.utils;


public class MessagesUtils {

    public static String getMessages(String property,Integer type) {
        String msg ;
        if(type == 1){
            msg =getRace(property);
        }else if(type ==2){
            msg =getType(property);
        }else{
            msg =getAttribute(property);
        }
        return  msg;
    }


    private static String getRace(String msg){
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
    private static String getType(String msg){
        if(msg !=null){
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
    private static String getAttribute(String msg){
        if(msg!=null){
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
                    break;
        }
        }

        return msg;
    }
}
