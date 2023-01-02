package task;


import task.buildings.HouseBabes;
import task.city.FlowerCity;
import task.city.GreenCity;
import task.object.StreetCovet.Doormat;
import task.object.StreetCovet.Dust;
import task.object.StreetCovet.Sidewalk;
import task.persons.*;
import task.object.*;
import task.persons.Character;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws BabesNotFound {
        long start = System.currentTimeMillis();//Таймер

        BabesArrayWrapper babesArrayWrapper = new BabesArrayWrapper("Малышки");
        Babes babeOne = new Babes("Кнопочка", "Female");
        Babes babeTwo = new Babes("Синеглазка", "Female");
        Babes babeThree = new Babes("Ромашка", "Female");
        Babes babeFour = new Babes("Листик", "Male");
        babesArrayWrapper.setGroup(babeTwo, babeThree, babeOne, babeFour);
        Table table = new Table();
        Bed bed = new Bed();
        BookCase bookCase = new BookCase();
        Books Harry_Potter = Books.HARRY_POTTER;
        Books War_and_Piece = Books.WAR_AND_PIECE;
        Books Coloring_book = Books.COLORING_BOOK;

        HouseBabes houseBabes = new HouseBabes();

        Doormat doormat = new Doormat();
        Sidewalk sidewalk = new Sidewalk();
        Dust dust = new Dust();

        GreenCity.getInstance().addSight(Place.BRIDGE);
        Place.BRIDGE.addObjectOnPlace("Пыль");

        Solomka.getInstance().setWork(new Work[]{Work.FRUIT_GROWING, Work.VEGETABLES_GROWING});

        Population population = new Population(Znayka.getInstance(), Solomka.getInstance(), Dunno.getInstance(), babeFour, babeOne, babeTwo, babeThree);


        System.out.println(babesArrayWrapper.getName());

//        System.out.println("Действующие лица: ");
//        for (Character person : population) {
//            System.out.println(person.getName() + " " + person.toString());
//        }

//        Znayka.getInstance().decided("Буду сидеть в одуванчиках, а потом они забудут про эту историю -- и я вылезу");
//        System.out.println(Znayka.getInstance().getIdea() + ", -- решил " + Znayka.getInstance().getName());
//
//        System.out.println("Знайка" + Znayka.getInstance().checkInteres() + "осмотреть " + GreenCity.getInstance().getName());
//
//        System.out.println(babesArrayWrapper.getName() + " пошли с ними,чтобы показать все достопримечательности");
//        babesArrayWrapper.goWalk();
//        Znayka.getInstance().goWalk();
//        System.out.println(Znayka.getInstance().inspect(GreenCity.getInstance()));
//
//        System.out.println(Znayka.getInstance().getName() + " " + Znayka.getInstance().checkAttention() + "осмотрел " + Place.BRIDGE.getName() + ",потом стал осматривать " + Place.REED_WATER_SUPPLY.getName());
//        System.out.println(Znayka.getInstance().inspect(Place.BRIDGE, Place.REED_WATER_SUPPLY));
//        Znayka.getInstance().changeTiredness(1);
//        Znayka.getInstance().changeInteres(-1);
//        Znayka.getInstance().changeAttention(-1);
//
//
//        Znayka.getInstance().addFun(Device.FONTAIN, Device.WATERSUPPLY);
//        System.out.println("Он очень " + Znayka.getInstance().checkInteres() + " узнать " + Znayka.getInstance().getFunNameList());
//
//        System.out.println("Малышки подробно рассказали ему, как устроен водопровод и как нужно делать фонтаны, чтобы вода била вверх, а не вниз.  ");
//        babesArrayWrapper.tell(Znayka.getInstance());
//        Place.REED_WATER_SUPPLY.addDeviceDescription("1)Сделать 1 часть\n2) Сделать 2 часть\n3) Сделать 3 часть");
//        Place.FONTAIN.addDeviceDescription("1)Сделать 1.1 часть\n2) Сделать 2.2 часть\n3) Сделать 3.3 часть");
//        System.out.println(Place.REED_WATER_SUPPLY.getDeviceDescription());
//        System.out.println(Place.FONTAIN.getDeviceDescription());
//
//        System.out.println("Знайке понравилось,что у малышек " + GreenCity.Everywhere.checkClear());
//        Znayka.getInstance().rejoice();
//
//        Place.STREET.addObjectOnPlace(sidewalk.getName());
//        babesArrayWrapper.coverUP(Place.STREET, doormat);
//        System.out.println("Он похвалил их за то, что даже " + Place.STREET.getName() + " застилали " + doormat.getName());
//        System.out.println("Теперь " + Place.STREET.getObjectOnPlace());
//        babesArrayWrapper.praise();
//
//        long finish = System.currentTimeMillis();
//        long elapsed = finish - start;
//        System.out.println("Время от времени в " + elapsed + " миллисекунд он вылезал,и вот тут-то ему приходилось " + Znayka.getInstance().getOut());
//
//
//        System.out.println("Малышки обрадовались и стали приглашать" + Znayka.getInstance().getName() + "в дома");
//        babesArrayWrapper.InviteToBabesHouse(Znayka.getInstance(), houseBabes);
//        System.out.println("Чтобы он посмотрел внутренее устройство");
//        houseBabes.getConditionalList();
//        Znayka.getInstance().look();
//
//        System.out.println("Внутри было " + houseBabes.checkClear() + " ,как и снаружи");
//
//        //
//        System.out.println("Знайка " + Znayka.getInstance().walkAroundCity(bookCase, table, bed));
//        //

        ///////////////////////СТАРАЯ ЧАСТЬ//////////////////////////////////////////////////////////////////////////
//        System.out.println("Знайка машет рукой");
//        Znayka.getInstance().wake();
//        System.out.println(Znayka.getInstance().toString());
//
//        System.out.println("Ему" + Znayka.getInstance().checkShame() + "признаться, что ");
//        table.setBooks(new Books[]{Harry_Potter, War_and_Piece});
//        bed.setBooks(new Books[]{Coloring_book});
//        System.out.println(table.getContent() + " и " + bed.getContent());
//
//          Znayka.getInstance().addFun(new Watermelon());
//        System.out.println("Знайку,конечно,заинтересовали " + Znayka.getInstance().getFunNameList());
//
//        System.out.println("Малышки рассказали ему про Соломку");
//        babesArrayWrapper.introduce(babesArrayWrapper,Znayka.getInstance());
//        babesArrayWrapper.tell(Znayka.getInstance());
//        System.out.println("Знайка "+Znayka.getInstance().checkInteres()+" познакомиться с ней");
//        System.out.println(Znayka.getInstance().toString());
//        System.out.println(babesArrayWrapper.toString());
//
//        System.out.println("Малышки разыскали Соломку");
//        babesArrayWrapper.introduce(babesArrayWrapper,Solomka.getInstance());
//        babesArrayWrapper.seekOut(Solomka.getInstance());
//        System.out.println(Solomka.getInstance().toString());
//        System.out.println(babesArrayWrapper.toString());
//
//
//        System.out.println("и познакомили её со Знайкой");
//        babesArrayWrapper.introduce(Znayka.getInstance(),Solomka.getInstance());
//        System.out.println("Друзья знайки : "+Znayka.getInstance().getFriendList());
//        System.out.println("Друзья соломки : "+Solomka.getInstance().getFriendList());
//
//        System.out.println("Знайка стал её распрашивать"); //добавить незнание
//        Znayka.getInstance().question(Solomka.getInstance());
//        System.out.println("обо всем, что его интересовало("+Znayka.getInstance().getFunNameList()+")");
//        System.out.println(Solomka.getInstance().toString());
//        System.out.println(Znayka.getInstance().toString());
//
//        System.out.println("Соломка рассказала о своей работе : "+ Solomka.getInstance().getWorkList());
//        Solomka.getInstance().tell(Znayka.getInstance());
//        System.out.println(Znayka.getInstance().toString());
//        System.out.println(Solomka.getInstance().toString());
//
//
//        System.out.println("Знайка"+Znayka.getInstance().checkAttention()+"Слушал");
//        Znayka.getInstance().listen();
//        System.out.println(Znayka.getInstance().toString());
//
//        System.out.println("И даже записывал");
//        Znayka.getInstance().write();
//        System.out.println("в свою маленькую "+Books.NOTEBOOK.getNameBook());
//        System.out.println(Znayka.getInstance().toString());
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        System.out.println("А у Нейзнайки,конечно," + Dunno.getInstance().checkTiredness() + " сидеть в " + Place.DANDELION_THICKETS.getName());
//        Place.DANDELION_THICKETS.addObjectOnPlace(Dunno.getInstance().getName());
//        if (Dunno.getInstance().checkTiredness() != "не хватало")
//            Dunno.getInstance().sit();
//
//        System.out.println(babesArrayWrapper.getNameFemale() + Znayka.getInstance().checkObscurity());
//        System.out.println(",но зато " + babesArrayWrapper.getNameMale() + " просто не давали проходу");
//        babesArrayWrapper.let();
//
//        Znayka.getInstance().clearIdeaList();
//        Znayka.getInstance().think("Нет, видно, еще не забыли!");
//        System.out.println(Znayka.getInstance().getIdea() + Znayka.getInstance().checkJoy() +
//                "думал Незнайка и бросался обратно в одуванчики");
//        Znayka.getInstance().rush();
//        Place.DANDELION_THICKETS.addObjectOnPlace(Znayka.getInstance().getName());
//        System.out.println(Place.DANDELION_THICKETS.getObjectOnPlace());
    }
}
