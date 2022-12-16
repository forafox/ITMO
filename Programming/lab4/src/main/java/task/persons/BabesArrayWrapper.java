package task.persons;

import task.buildings.HouseBabes;
import task.object.Joyful;
import task.buildings.*;
import task.object.StreetCovet.FloorCovering;

import java.util.ArrayList;

public class BabesArrayWrapper implements WorkWithWrapper {
    private String name;
    //Cписок для хранения интересов
    ArrayList<Babes> BabesList = new ArrayList<Babes>(); //Cписок для Малышек

    public BabesArrayWrapper(String name) {
        this.name = name;
    }

    //    public void addBabes(Babes... babesListSmall) throws BabesIsNotAddedException {
//        for (Babes babe : babesListSmall) {
//            if(babe!=null)
//            BabesList.add(babe);
//            else throw new BabesIsNotAddedException();
//        }
//    }
    public void addBabes(Babes... babeAddList) throws BabesIsNotAddedException,BabesNullExeption {
        for (Babes babe : babeAddList) {
            if (babe != null && !this.contains(babe))
                BabesList.add(babe);
            else if (babe==null) {
                throw new BabesNullExeption();
            }
            else throw new BabesIsNotAddedException();
        }
    }

    public void removeBabes(Babes... babeRemoveList) throws BabesNotFound {
        for (Babes babe : babeRemoveList) {
            if (this.contains(babe))
                BabesList.remove(babe);
            else throw new BabesNotFound();
        }
    }
    public boolean checkTwoGroups(BabesArrayWrapper a) {
        if (a != null && this != null)
            return a.equals(this);
        else throw new BabesArrayWrapperExeption();
    }
    public void addGroupForBabe(Babes babe) throws BabesNullExeption {
        if (babe != null)
            babe.setGroup(this);
        else {
            throw new BabesNullExeption();
        }
    }
    public void setGroup(Babes... babesListSmall) {
        for (Babes babe : babesListSmall) {
                try {
                    this.addBabes(babe);
                } catch(BabesIsNotAddedException e) {
                    System.out.println(e.getMessage());
                }catch (BabesNullExeption e){
                    System.out.println(e.getMessage());
                }
            try {
                this.addGroupForBabe(babe);
            } catch (BabesNullExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public String getName() {
        var result = new StringBuilder();
        for (Babes babe : BabesList)
            result.append(babe.getName()).append(", ");
        if (("" + result).length() > 2) return String.format(result.substring(0, result.length() - 2));
        else return " ";
    }

    @Override
    public void tell(Character x) { //Рассказывает кому-то что-то, повышая заинтересованность,уменьшая внимание
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
        x.changeInteres(1);
        x.changeTiredness(1);
        x.changeAttention(-1);
    }

    @Override
    public void seekOut(Character x) {
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
        x.changeInteres(1);
    }

    @Override
    public void introduce(Character a, Character b) {
        if (a.getClass() == (BabesList.get(0)).getClass()) {
            for (Babes babe : BabesList) {
                babe.addFriend(b);
                babe.changeTiredness(1);
                babe.changeInteres(1);
            }
            for (Babes babe : BabesList) {
                b.addFriend(babe);
            }
            b.changeInteres(1);
            b.changeTiredness(1);
        } else if (b.getClass() == (BabesList.get(0)).getClass()) {
            for (Babes babe : BabesList) {
                babe.addFriend(a);
                babe.changeTiredness(1);
                babe.changeInteres(1);
            }
            for (Babes babe : BabesList) {
                a.addFriend(babe);
            }
            a.changeInteres(1);
            a.changeTiredness(1);
        } else {
            a.addFriend(b);
            a.changeTiredness(1);
            a.changeInteres(1);

            b.addFriend(a);
            b.changeTiredness(1);
            b.changeInteres(1);
        }
    }

    public void introduce(BabesArrayWrapper a, Character b) {
        for (Babes babe : BabesList) {
            babe.addFriend(b);
            babe.changeTiredness(1);
            babe.changeInteres(1);
        }
        for (Babes babe : BabesList) b.addFriend(babe);
        b.changeInteres(1);
        b.changeTiredness(1);
    }


    @Override
    public String toString() {//Состояние героя (Усталость)
        String str = "Каждая из малышек имеет следующее состояние:\n";
        for (Babes babe : BabesList) {
            str += String.format("Усталость: %d,Интерес: %d,Стыд: %d,Внимание: %d\n", babe.getTiredness(), babe.getInteres(), babe.getShame(), babe.getAttention());
        }
        return str;
    }

    public void setTiredness(int n) {
        for (Babes babe : BabesList) {
            babe.setTiredness(n);
        }
    }

    public void changeTiredness(int n) {
        for (Babes babe : BabesList) {
            babe.setTiredness(babe.getTiredness() + n);
        }
    }


    public void setInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(n);
        }
    }

    public void changeInteres(int n) {
        for (Babes babe : BabesList) {
            babe.setInteres(babe.getInteres() + n);
        }
    }

    public void addFriend(Character x) {//метод для добавления интерсов
        for (Babes babe : BabesList) {
            babe.friendList.add(x);
        }
    }

//    public String getFriendList(){ //Получение списка друзей
//        var result = new StringBuilder();
//        for(Character x : friendList)
//            result.append(x.getName()).append(", ");
//        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
//        else return "Нет друзей";
//    }

    public void coverUP(Place place, FloorCovering covering) {
        place.addObjectOnPlace(covering.getName());
    }

    @Override
    public void praise() {
        for (Babes babe : BabesList) {
            babe.changeRespect(1);
        }
    }

    @Override
    public void goWalk() {
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
    }

    public void payAttention() {
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
    }

    public String getNameMale() {
        var result = new StringBuilder();
        for (Babes babe : BabesList)
            if (babe.getGender().equals("Male")) result.append(babe.getName()).append(", ");
        if (("" + result).length() > 2) return String.format(result.substring(0, result.length() - 2));
        else return " Нет таких малышек ";
    }

    public String getNameFemale() {
        var result = new StringBuilder();
        for (Babes babe : BabesList)
            if (babe.getGender().equals("Female")) result.append(babe.getName()).append(", ");
        if (("" + result).length() > 2) return String.format(result.substring(0, result.length() - 2));
        else return " ";
    }

    public void let() {
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
    }

    @Override
    public void rejoice() {
        for (Babes babe : BabesList) {
            babe.changeTiredness(1);
        }
    }

    public void InviteToBabesHouse(Character person, HouseBabes house) {
        person.changeTiredness(1);
        house.addPersonForInvited(person);
    }

    public boolean contains(Babes babe) {
        return (this.BabesList.contains(babe));
    }


    @Override
    public void listen() {
    }

    @Override
    public void question(Character x) {
    }

    @Override
    public void write() {
    }

    @Override
    public void wake() {
    }

    @Override
    public void sit() {

    }

}
