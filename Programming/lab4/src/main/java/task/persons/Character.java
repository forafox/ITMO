package task.persons;
import task.partCity.AreaInCity;
import task.buildings.Building;
import task.city.City;
import task.partCity.*;
import task.object.*;

import java.util.ArrayList;

public abstract class Character implements WorkWithWrapper,Moveable,Joyful {
    private Brain myBrain =new Brain();//?
    private String name;
    private String gender;

    private int joy=0;//радость
    private int obscurity=0;//неизвестность
    private int interest=0;//интерес
    private int tiredness=0;//усталость
    private int attention=0;//Внимание
    private int shame=0;//стыд
    private int respect=0;//респект
    public Character(String name){
        this.name = name;
        this.gender="Male";
        this.tiredness=5;
        this.interest=5;
        this.shame=5;
        this.attention=7;
        this.obscurity=10;
        this.joy=0;
    }
    public Character(String name,String gender){
        this.name = name;
        this.gender=gender;
        this.tiredness=5;
        this.interest=5;
        this.shame=5;
        this.attention=7;
        this.obscurity=10;
        this.joy=0;
    }
    public Character(String name,int tiredness,int interest,int shame,int attention){
        this.name=name;
        this.tiredness=tiredness;
        this.interest=interest;
        this.shame=shame;
        this.attention=attention;
    }

    ArrayList<Joyful> FunList = new ArrayList<>(); //Cписок для хранения интересов
    ArrayList<Character> friendList = new ArrayList<>(); //Cписок для хранения имен друзей
    //ArrayList<Work> WorkList = new ArrayList<>(); //Cписок для работы
    private Work[] workList;


    public void setName(String name){
        this.name=name;
    }

    public void addFun(Joyful ... joyfulsList){//метод для добавления интерсов
        for (Joyful joyful : joyfulsList) {
            FunList.add(joyful);
        }
    }
    public String getFunNameList(){ //Получение списка интересов
        var result = new StringBuilder();
        for(Joyful x : FunList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public void addFriend(Character x){//метод для добавления интерсов
        friendList.add(x);
    }

    public String getFriendList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(Character x : friendList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public void setWork(Work[] workList){//метод для добавления интерсов
        this.workList=(workList);
    }
    public String getWorkList(){ //Получение списка друзей
        var result = new StringBuilder();
        for(var workElement : workList)
            result.append(workElement.getNameWork()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет друзей";
    }

    public String getName(){
        return this.name;
    }

//    @Override
//    public String toString() {//Состояние героя (Усталость)
//        return String.format(ANSI_RED+"Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d"+ANSI_RESET, this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
//    }
    @Override
    public String toString() {//Состояние героя (Усталость)
        return String.format("Герой %s с уровнем усталости,интереса,cтыда,внимания: %s , %d, %d , %d", this.getName(), this.getTiredness(),this.getInteres(),getShame(),getAttention());
    }
    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

    @Override
    public void wake(){
        changeTiredness(1);
    }

    @Override
    public void tell(Character x){ //Рассказывает кому-то что-то, повышая заинтересованность
        x.changeInteres(1);
        changeTiredness(1);
        x.changeTiredness(1);
        x.changeAttention(-1);
    }
    @Override
    public void listen(){
        //System.out.println("Слушал");
        changeTiredness(1);
        changeAttention(-1);
    }
    @Override
    public void question(Character x){
        //System.out.println("Распрашивать");
        x.changeTiredness(1);
        x.changeInteres(1);
        changeTiredness(1);
        changeAttention(-1);
        x.changeAttention(-1);
    }
    @Override
    public void write(){
        //System.out.println("Записывал");
        changeTiredness(1);
        changeAttention(-1);
        Books.NOTEBOOK.changeClear_paper(1);
        Books.NOTEBOOK.changeScribbled_paper(1);
    }
    @Override
    public void seekOut(Character x){
        changeTiredness(1);
        x.changeInteres(1);
    }
    @Override
    public void praise(){
        changeRespect(1);
    }
    public void praise(Character x){
        x.changeRespect(1);
    }
    @Override
    public void introduce(Character a,Character b){
        a.addFriend(b);
        a.changeTiredness(1);
        a.changeInteres(1);
        b.changeInteres(1);
        b.changeTiredness(1);
        b.addFriend(a);
    }
    @Override
    public void sit(){
        changeTiredness(1);
}

    public String getGender(){return this.gender;}
    public void setGender(String gender){ this.gender=gender;}
    public int getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(int n) {
        this.tiredness=n;
    }
    public void changeTiredness(int n){
        this.tiredness =getTiredness()+n;
    }

    public String checkTiredness(){
        if(getTiredness()>=5) return " хватало терпения ";
    else if (getTiredness()>=3) return " еле-еле хватало терпения ";
    else return " не хватало терпения ";}


    public int getObscurity(){return this.obscurity;}
    public void setObscurity(int n){this.obscurity=n;}
    public void changeObscurity(int n){this.obscurity=getObscurity()+n;}

    public String checkObscurity(){
        if(getAttention()>=5) return " Вовсе не обращали на него никакого внимания,будто его не существовало";
        else if (getAttention()>=3) return " не обращали на него внимания, но знали, что он существовал ";
        else return " Обращали внимание ";
    }

    public int getAttention() {
        return attention;
    }
    public void setAttention(int n) {
        this.attention=n;
    }
    public void changeAttention(int n){ this.attention=getAttention()+n;}

    public String checkAttention(){ //Степень внимания от значения переменной
        if(getAttention()>=5) return " очень внимательно ";
        else if (getAttention()>=3) return " внимательно ";
        else return " не внимательно ";
    }
    public void look() {
        changeTiredness(1);
    }//Посмотреть что-либо
    public int getJoy() {
        return joy;
    }
    public void setJoy(int n) {
        this.joy=n;
    }

    public String checkJoy(){
        return this.joy>2 ? " с радостью " : " с досадой";
    }
    public void changeJoy(int n){
        this. joy=getJoy()+n;
    }

    public int getShame() {
        return shame;
    }
    public void setShame(int n) {
        this.shame=n;
    }
    public void changeShame(int n){
        this.shame=getShame()+n;
    }

    public int getRespect(){return respect;}
    public void setRespect(int n){this.respect=n;}
    public void changeRespect(int n){this.respect=getRespect()+n;}


    public int getInteres() {
        return interest;
    }

    public void setInteres(int n) {
        this.interest=n;
    }

    public void changeInteres(int n) {
        this.interest=getInteres()+n;
    }

    public String checkInteres(){
        return (this.getInteres() > 3) ? " захотеть " : " не хотеть ";
    }

    @Override
    public void makeHappy(Character x){
        x.changeInteres(1);
        x.changeTiredness(1);
    }
    @Override
    public void move(Character a,Place b){
        b.addObjectOnPlace(this.name);
    }

    public String inspect(Place ... placeList){
        var result = new StringBuilder();
        for(Place x : placeList)
            result.append(x.getObjectOnPlace()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "На местах ничего нет";
    }
    public String inspect(City x){
        return x.getSight();}

    @Override
    public void goWalk(){changeTiredness(1);}

    @Override
    public void rejoice(){};

    public void rush(){
        changeTiredness(1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character that = (Character) o;

         return ((name==that.name)&&(interest==that.interest));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + interest;
        return result;
    }

    public String getOut(){
        changeTiredness(1);
        return this.badCondition(true);
    }

    public String walkAroundCity(Furniture ... furnitureList){
        changeTiredness(1);
        changeInteres(-1);
        changeAttention(-1);
        ArrayList <Furniture> newFurnitureList= new ArrayList<>();
        for(Furniture furnitureElement:furnitureList) newFurnitureList.add(furnitureElement);
        class MainArea extends AreaInCity {
            public String seeInBuilding(Building x) {
                for (Furniture furnitureElement : newFurnitureList) x.addConditionalList(furnitureElement);
                return x.getConditionalList();
            }
            public String checkHouse(){
                return seeInBuilding(new Building() {
                });
            }
        }

        MainArea mainArea = new MainArea();
       return "В одном из домов увидел "+mainArea.checkHouse()+" и сказал, что когда вернется домой, то и себе сделает "+mainArea.checkHouse();
    }

    public String badCondition(Boolean x){
        return x ? " Приходилось туго" : " Приходилось не туго ";
    }
    public void decided(String idea){ //решил
        myBrain.addIdea(idea);
    }
    public String getIdea(){
        return myBrain.getIdea();
    }

    public void think(String idea){
         myBrain.addIdea(idea);
    }
    public void clearIdeaList(){
        myBrain.ideaList.clear();
    }
    private class Brain{
        ArrayList<String> ideaList = new ArrayList<>();
        private void addIdea(String ... newIdeaList){
            for(String idea : newIdeaList) ideaList.add(idea);
        }
        private String getIdea(){
            var result = new StringBuilder();
            for(String idea : ideaList)
                result.append(idea).append(", ");
            if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
            else return "У персонажа идей нет";
        }
    }
}
